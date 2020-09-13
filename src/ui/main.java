package ui;
import model.*;
import java.util.Scanner;
public class main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ask_for_product_name(sc, general_amount);
		utilization (sc, general_amount);
		System.out.println("El precio total a pagar en HomeCenter es:" + budget.total_homecenter());
		
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
			product_Name[i] = sc.nextLine();
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
			for (int i = 0; i < general_amount; i++) {
			System.out.println ("Ingrese la utilidad del material " + (i+1) + ":");		
			each_product_type[i] = sc.nextLine();
			sc.nextLine();
			}
			  return each_product_type;
		}
			
		public static double[] price_homecenter (Scanner sc, int general_amount) {
			double[] price_hc = new double[general_amount];
			for (int i = 0; i < general_amount; i++) {
			System.out.println ("Ingrese el precio del material " + (i+1) + " para Homecenter:");		
			price_hc[i] = sc.nextDouble();
			sc.nextLine();
				
			}
			  return price_hc;
		}
			
		public static double[] store_center (Scanner sc, int general_amount) {
			double[] price_storecenter = new double[general_amount];
			for (int i = 0; i < general_amount; i++) {
			System.out.println ("Ingrese el precio del material " + (i+1) + "para la ferretería del centro:");		
			price_storecenter[i] = sc.nextDouble();
			sc.nextDouble();
				
			}
			  return price_storecenter;
		}
			
		public static double[] store_of_neighborhood (Scanner sc, int general_amount) {
			double[] price_neighborhood = new double[general_amount];
			for (int i = 0; i < general_amount; i++) {
			System.out.println ("Ingrese el precio del material " + (i+1) + "para Ferreteria del barrio:");		
			price_neighborhood[i] = sc.nextDouble();
			sc.nextDouble();
				
			}
			  return price_neighborhood;
		}
}
		
			
			
			
			