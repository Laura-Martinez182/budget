package ui;
import model.*;
import java.util.Scanner;
public class Main {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Budget Budget = new Budget();
		int generalAmount = askForGeneralAmount(sc);
		String[] name = askForProductName(sc, generalAmount);
		int[] eachAmount = askForProductAmount(sc, generalAmount);
		String[] work = utilization (sc, generalAmount);
		String location = delivery (sc);
		
		
		int[] homecenterPrices = priceForEachPlace (sc, generalAmount, "homecenter");
		int[] centerstorePrices = priceForEachPlace (sc, generalAmount, "ferreteria del centro");
		int[] neighborhoodPrices = priceForEachPlace (sc, generalAmount, "ferreteria del barrio");
		
		System.out.println ("El precio total para HomeCenter es: " + Budget.totalStore(homecenterPrices, eachAmount, generalAmount, location));
		System.out.println ("El precio total para la Ferreteria del Centro es: " + Budget.totalStore(centerstorePrices, eachAmount, generalAmount, location));
		System.out.println ("El precio total para la Ferreteria del Barrio es: " + Budget.totalStore(neighborhoodPrices, eachAmount, generalAmount, location));
		
		bestPlace (homecenterPrices, centerstorePrices, neighborhoodPrices, name, generalAmount);
		
		utilizationsGroups (work, name, generalAmount);
		
		
	}

		public static int askForGeneralAmount(Scanner sc) {
			System.out.println ("Ingrese el numero de materiales necesarios para llevar a cabo la obra:");
			int generalAmount = sc.nextInt();
			sc.nextLine();
			return generalAmount;
		}
		
		public static String[] askForProductName (Scanner sc, int generalAmount) {
			String[] name = new String [generalAmount];
			for (int i = 0; i < generalAmount; i++) {
			System.out.println ("Ingrese el nombre de los materiales en el orden de utilidad, primero los de obra negra, luego, obra blanca y pintura");
			System.out.println ("Ingrese el nombre del material " + (i+1) + ":");
			name[i] = sc.nextLine().toUpperCase();
			sc.nextLine();
			}
				return name;
		}
	
		public static int[] askForProductAmount (Scanner sc, int generalAmount) {
			int[] eachAmount = new int [generalAmount];
			for (int i = 0; i < generalAmount; i++) {
			System.out.println ("Ingrese la cantidad necesitada del material " + (i+1) + ":");	
			eachAmount[i] = sc.nextInt();
			sc.nextLine();
			}
				return eachAmount;
		}
	
		public static String[] utilization (Scanner sc, int generalAmount) {
			String[] work = new String [generalAmount];
			System.out.println ("Ingrese una de las siguientes opciones de obra: obra negra || obra blanca || pintura");		
			for (int i = 0; i < generalAmount; i++) {
			System.out.println ("Ingrese la utilidad del material " + (i+1) + ":");		
			work[i] = sc.nextLine().toUpperCase();
			sc.nextLine();
			}
			  return work;
		}
			
		public static int[] priceForEachPlace (Scanner sc, int generalAmount, String placeName) {
			int[] price = new int[generalAmount];
			System.out.println ("Ingrese el precio para: " + placeName); 
			for (int i = 0; i < generalAmount; i++) {
			System.out.println ("Ingrese el precio del material " + (i+1));		
			price[i] = sc.nextInt();
			sc.nextLine();
				
			}
			  return price;
		}
		
		public static String delivery (Scanner sc) {
			String location = ""; 
			System.out.println ("Ingrese una de las siguientes opciones de ubicacion: norte || sur || centro");	
			System.out.println ("Ingrese su ubicacion: "); 
			location = sc.nextLine().toUpperCase();
			sc.nextLine();
			return location;
		}
		
		public static void bestPlace (int[] homecenterPrices, int[] centerstorePrices, int[] neighborhoodPrices, String[] name, int generalAmount) {
			int[] cheaper = Budget.cheaperPrice(homecenterPrices, centerstorePrices, neighborhoodPrices);
			for (int i = 0; i < generalAmount;i++) {
				double totalMaterials = 0;
				if (homecenterPrices[i] < centerstorePrices[i] && homecenterPrices[i] < neighborhoodPrices[i]) {
					System.out.println ("El mejor establecimiento para comprar: " + name[i] + " es en HomeCenter con un precio de: " + cheaper[i]);
						totalMaterials += cheaper[i];
			}
				else if (centerstorePrices[i] < homecenterPrices[i] && centerstorePrices[i] < neighborhoodPrices[i]) {
					System.out.println ("El mejor establecimiento para comprar: " + name[i] + " es en la Ferreteria del centro con un precio de: " + cheaper[i]);
						totalMaterials += cheaper[i];
			}
				else {
					System.out.println ("El mejor establecimiento para comprar: " + name[i] + " es en la Ferreteria del barrio con un precio de: " + cheaper[i]);
						totalMaterials += cheaper[i];
				
			}
			System.out.println("El total a pagar por los materiales en estos establecimientos es: " + (totalMaterials += totalMaterials));
		}
	}
	
	
		public static void utilizationsGroups (String[] work, String[] name, int generalAmount) {
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
		
			
			
			
			