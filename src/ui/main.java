package ui;
import model.*;
import java.util.Scanner;
public class main {
	
	public final static String NORTE = "";
	public final static String CENTRO = "";
	public final static String SUR = "";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = ask_for_general_amount(sc);
		String[] name = ask_for_product_name(sc, result);
		double[] each_amount = ask_for_product_amount(sc, result);
		String[] work = utilization (sc, result);
		double[] homecenter_prices = price_for_each_place (sc, result, "homecenter");
		double[] centerstore_prices = price_for_each_place (sc, result, "ferreteria del centro");
		double[] neighborhood_prices = price_for_each_place (sc, result, "ferreteria del barrio");
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
	
		public static double[] ask_for_product_amount (Scanner sc, int general_amount) {
		double[] each_product_amount = new double [general_amount];
		for (int i = 0; i < general_amount; i++) {
		System.out.println ("Ingrese la cantidad necesitada del material " + (i+1) + ":");	
		each_product_amount[i] = sc.nextDouble();
		sc.nextLine();
		}
			return each_product_amount;
	}
	
		public static String[] utilization (Scanner sc, int general_amount) {
			String[] each_product_type = new String [general_amount];
			System.out.println ("Ingrese una de las siguientes opciones de obra: obraNegra || obraBlanca || pintura");		
			for (int i = 0; i < general_amount; i++) {
			System.out.println ("Ingrese la utilidad del material " + (i+1) + ":");		
			each_product_type[i] = sc.nextLine().toUpperCase();
			sc.nextLine();
			}
			  return each_product_type;
		}
			
		public static double[] price_for_each_place (Scanner sc, int general_amount, String name) {
			double[] price = new double[general_amount];
			System.out.println ("Ingrese el nombre del estableciemiento" + name); 
			for (int i = 0; i < general_amount; i++) {
			System.out.println ("Ingrese el precio del material " + (i+1));		
			price[i] = sc.nextDouble();
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
		
			
			
			
			