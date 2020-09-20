package ui;
import model.*;
import java.util.Scanner;
public class Main {
	private Scanner sc;
	Budget budget; 
	
	public Main () {
		sc = new Scanner(System.in);
		budget = new Budget();
	}
	
	public static void main(String[] args) {
	Main m = new Main(); 
	m.showMenu();
	}
	
	/**
	*This method groups all the methods needed to make the program work.
	*<b>pre: </b> All the preconditions for the others methods altogether.
	*<b>post: </b> It saves the results of all the methods to show them in the Main.
	*/
	public void showMenu() {
		
		int generalAmount = askForGeneralAmount();
		String[] name = askForProductName(generalAmount);
		int[] eachAmount = askForProductAmount(generalAmount);
		String[] work = utilization (generalAmount);
		String location = delivery ();
		
		
		int[] homecenterPrices = priceForEachPlace (generalAmount, "homecenter");
		int[] centerstorePrices = priceForEachPlace (generalAmount, "ferreteria del centro");
		int[] neighborhoodPrices = priceForEachPlace (generalAmount, "ferreteria del barrio");
		
		System.out.println ("El precio total para HomeCenter es: " + budget.totalStore(homecenterPrices, eachAmount, generalAmount, location));
		System.out.println ("El precio total para la Ferreteria del Centro es: " + budget.totalStore(centerstorePrices, eachAmount, generalAmount, location));
		System.out.println ("El precio total para la Ferreteria del Barrio es: " + budget.totalStore(neighborhoodPrices, eachAmount, generalAmount, location));
		
		bestPlace (homecenterPrices, centerstorePrices, neighborhoodPrices, name, generalAmount, eachAmount);
		
		utilizationsGroups (work, name, generalAmount);
		
		
	}
	
	/**
	*This method saves the total amount of materials for the construction.
	*<b>pre: </b> The number has to be an integer (bigger than 0).   
	*<b>post: </b> The total amount of materials will be saved. 
	*/
		public int askForGeneralAmount() {
			System.out.println ("Ingrese el numero de materiales necesarios para llevar a cabo la obra:");
			int generalAmount = sc.nextInt();
			sc.nextLine();
			return generalAmount;
		}
		
		/**
		*This method saves the names of each product.
		*<b>pre: </b> The user has to enter the names in order of utility, first those for black work, then for white work, and then for paint.
		*<b>post: </b> The names have been saved in an array of strings.
		*@param generalAmount Total amount of materials for the construction. generalAmount != null && generalAmount > 0.
		*/
		public String[] askForProductName (int generalAmount) {
			String[] name = new String [generalAmount];
			for (int i = 0; i < generalAmount; i++) {
			System.out.println ("Ingrese el nombre de los materiales en el orden de utilidad, primero los de obra negra, luego, obra blanca y pintura");
			System.out.println ("Ingrese el nombre del material " + (i+1) + ":");
			name[i] = sc.nextLine().toUpperCase();
			sc.nextLine();
			}
				return name;
		}
		/**
		*This method saves the individual quantity of each product 
		*<b>pre: </b> The user has to enter integers numbers. 
		*<b>post: </b> The individual quantities have been saved in an array of integers.
		*@param generalAmount Total amount of materials for the construction. generalAmount != null && generalAmount > 0.
		*/
		public int[] askForProductAmount (int generalAmount) {
			int[] eachAmount = new int [generalAmount];
			for (int i = 0; i < generalAmount; i++) {
			System.out.println ("Ingrese la cantidad necesitada del material " + (i+1) + ":");	
			eachAmount[i] = sc.nextInt();
			sc.nextLine();
			}
				return eachAmount;
		}
		/**
		*This method saves the utilization of each product. 
		*<b>pre: </b> The user has to enter strings. First those for black work, then for white work, and then for paint. 
		*<b>post: </b> The individual utilities have been saved in an array of strings.
		*@param generalAmount Total amount of materials for the construction. generalAmount != null && generalAmount > 0.
		*/
		public String[] utilization (int generalAmount) {
			String[] work = new String [generalAmount];
			System.out.println ("Ingrese una de las siguientes opciones de obra: obra negra || obra blanca || pintura");		
			for (int i = 0; i < generalAmount; i++) {
			System.out.println ("Ingrese la utilidad del material " + (i+1) + ":");		
			work[i] = sc.nextLine().toUpperCase();
			sc.nextLine();
			}
			  return work;
		}
		
		/**
		*This method saves the price of each product in the diferents stores. 
		*<b>pre: </b> The user has to enter integers. First those for HomeCenter, then for Ferreteria del Centro, and then for Ferreteria del barrio.
		*<b>pre: </b> Don´t repeat the same price for an item in diferents stores.
		*<b>post: </b> The individual prices will be saved in an array of integers.
		*@param generalAmount Total amount of materials for the construction. generalAmount != null && generalAmount > 0.
		*@param placeName Name of the store. They are called in the Main.
		*/ 
			
		public int[] priceForEachPlace (int generalAmount, String placeName) {
			int[] price = new int[generalAmount];
			System.out.println ("Ingrese el precio para: " + placeName); 
			for (int i = 0; i < generalAmount; i++) {
			System.out.println ("Ingrese el precio del material " + (i+1));		
			price[i] = sc.nextInt();
			sc.nextLine();
				
			}
			  return price;
		}
		
		/**
		*This method saves the location of the user. 
		*<b>pre: </b> The user has to enter a string. It could be norte, sur or centro.
		*<b>post: </b> The location have been saved in an string.
		*/ 
		public String delivery () {
			String location = ""; 
			System.out.println ("Ingrese una de las siguientes opciones de ubicacion: norte || sur || centro");	
			System.out.println ("Ingrese su ubicacion: "); 
			location = sc.nextLine().toUpperCase();
			sc.nextLine();
			return location;
		}
		
		/**
		*This method show the best place to buy each item and how much it will cost in total if the user bought it that way.
		*<b>pre: </b> The arrays where the prices are saved have to be inicializated.
		*<b>post: </b> It will show the best place to buy each material and the price there (taking into account the quantity), then the total price.
		*@param homecenterPrices Price of each material in HomeCenter. homecenterPrices > 0 && homecenterPrices != null.
		*@param centerstorePrices Price of each material in the Center store. centerstorePrices > 0 && centerstorePrices != null.
		*@param neighborhoodPrices Price of each material in the Neighborhood store. neighborhoodPrices > 0 && neighborhoodPrices != null.
		*@param name Name of each material. name != "" && name != null.
		*@param generalAmount Total amount of materials for the construction. generalAmount > 0 && generalAmount != null.
		*@param eachAmount Quantity of each item. eachAmount > 0 && eachAmount != null.
		*/ 
		public void bestPlace (int[] homecenterPrices, int[] centerstorePrices, int[] neighborhoodPrices, String[] name, int generalAmount, int[] eachAmount) {
			int[] cheaper = budget.cheaperPrice(homecenterPrices, centerstorePrices, neighborhoodPrices);
			int totalMaterials = 0;
			for (int i = 0; i < generalAmount;i++) {
				
				if (homecenterPrices[i] < centerstorePrices[i] && homecenterPrices[i] < neighborhoodPrices[i]) {
					System.out.println ("El mejor establecimiento para comprar: " + name[i] + " es en HomeCenter con un precio de: " + (cheaper[i]*eachAmount[i]));
						totalMaterials += (cheaper[i]*eachAmount[i]);
			}
				else if (centerstorePrices[i] < homecenterPrices[i] && centerstorePrices[i] < neighborhoodPrices[i]) {
					System.out.println ("El mejor establecimiento para comprar: " + name[i] + " es en la Ferreteria del centro con un precio de: " + (cheaper[i]*eachAmount[i]));
						totalMaterials += (cheaper[i]*eachAmount[i]);
			}
				else {
					System.out.println ("El mejor establecimiento para comprar: " + name[i] + " es en la Ferreteria del barrio con un precio de: " + (cheaper[i]*eachAmount[i]));
						totalMaterials += (cheaper[i]*eachAmount[i]);
				
			}
		}
		System.out.println("El total a pagar por los materiales en estos establecimientos es: " + (totalMaterials));
	}
		/**
		*This method separate the materials according to the utilization. 
		*<b>pre: </b> All the materials have to have their utilization in the right order.
		*<b>post: </b> It will print the name of the materials for each group of utilizations.
		*@param work Utilization of each material. work != null && work != "".
		*@param name Name of each material. name != "" && name != null.
		*@param generalAmount Total amount of materials for the construction. generalAmount > 0 && generalAmount != null.
		*/
	
		public void utilizationsGroups (String[] work, String[] name, int generalAmount) {
			for (int i = 0; i < generalAmount; i++) {
				if (work[i].equalsIgnoreCase("obra negra")) {
					System.out.println ("Los materiales usados para la obra negra son: " + name[i]);
				}
				else if (work[i].equalsIgnoreCase("obra blanca")) {
					System.out.println("Los materiales usados en la obra blanca son: " + name[i]);
				}
				else { 
						System.out.println("Los materiales usados para pintura son: " + name[i]);
			}
		}
	}
			
			
			
}
		
			
			
			
			