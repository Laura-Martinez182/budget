package ui;
import model.*;
import java.util.Scanner;
public class main {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int result = ask_for_general_amount(sc);
		String[] name = ask_for_product_name(sc, result);
		int[] each_amount = ask_for_product_amount(sc, result);
		String[] work = utilization (sc, result);
		String location = delivery (sc);
		
		int[] homecenter_prices = price_for_each_place (sc, result, "homecenter");
		int[] centerstore_prices = price_for_each_place (sc, result, "ferreteria del centro");
		int[] neighborhood_prices = price_for_each_place (sc, result, "ferreteria del barrio");
		
		System.out.println ("El precio total para homecenter es: " + budget.total_store(homecenter_prices, each_amount, result, location));
		System.out.println ("El precio total para la ferreteria del centro es: " + budget.total_store(centerstore_prices, each_amount, result, location));
		System.out.println ("El precio total para la ferreteria del barrio es: " + budget.total_store(neighborhood_prices, each_amount, result, location));
		
		System.out.println ("Productos para obra negra: " + budget.utilizationsArrays(work, "obra negra", name);
		System.out.println ("Productos para obra blanca: " + budget.utilizationsArrays(work, "obra blanca", name);
		System.out.println ("Productos para pintura: " + budget.utilizationsArrays(work, "pintura", name);
		
		
	}

		public static int ask_for_general_amount(Scanner sc) {
			System.out.println ("Ingrese el numero de materiales necesarios para llevar a cabo la obra:");
			int num_products = sc.nextInt();
			sc.nextLine();
			return num_products;
		}
		
		public static String[] ask_for_product_name (Scanner sc, int general_amount) {
			String[] product_Name = new String [general_amount];
			for (int i = 0; i < general_amount; i++) {
			System.out.println ("Ingrese el nombre del material " + (i+1) + ":");
			product_Name[i] = sc.nextLine().toUpperCase();
			sc.nextLine();
			}
				return product_Name;
		}
	
		public static int[] ask_for_product_amount (Scanner sc, int general_amount) {
			int[] each_product_amount = new int [general_amount];
			for (int i = 0; i < general_amount; i++) {
			System.out.println ("Ingrese la cantidad necesitada del material " + (i+1) + ":");	
			each_product_amount[i] = sc.nextInt();
			sc.nextLine();
			}
				return each_product_amount;
		}
	
		public static String[] utilization (Scanner sc, int general_amount) {
			String[] each_product_type = new String [general_amount];
			System.out.println ("Ingrese una de las siguientes opciones de obra: obra negra || obra blanca || pintura");		
			for (int i = 0; i < general_amount; i++) {
			System.out.println ("Ingrese la utilidad del material " + (i+1) + ":");		
			each_product_type[i] = sc.nextLine().toUpperCase();
			sc.nextLine();
			}
			  return each_product_type;
		}
			
		public static int[] price_for_each_place (Scanner sc, int general_amount, String name) {
			int[] price = new int[general_amount];
			System.out.println ("Ingrese el nombre del estableciemiento" + name); 
			for (int i = 0; i < general_amount; i++) {
			System.out.println ("Ingrese el precio del material " + (i+1));		
			price[i] = sc.nextInt();
			sc.nextLine();
				
			}
			  return price;
		}
		
		public static String delivery (Scanner sc) {
			String location = ""; 
			System.out.println ("Ingrese su ubicacion: "); 
			location = sc.nextLine().toUpperCase();
			sc.nextLine();
			return location;
		}
		
		
	
			
}
		
			
			
			
			