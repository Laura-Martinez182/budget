package model;
import ui.*;
import java.util.Scanner;
public class budget {
	
	private final static double ROUGH_CONSTRUCTION = 1300000;
	private final static double FINAL_WORK = 2600000;
	private final static double PAINT = 980000;
	
	
		public static double total_store(int[] materials_price, int[] materials_quantity, int general_amount, String location) {
			int total_price = 0;
			for (int i = 0; i < result; i++) {
				total_price += (materials_quantity[i]* materials_price[i]);
			}	
				if (total_price < 80000) {
					if (location.equalsIgnoreCase("Norte") || location .equalsIgnoreCase("Sur")) {
						total_price	+= 120000;
				}else if (location.equalsIgnoreCase("Centro")) {
					total_price += 50000;
				}
			}
			else if (total_price < 300000) {
				if (location.equalsIgnoreCase("Norte")) {
					total_price += 28000;
			}else if(location.equalsIgnoreCase("Sur")) {
					total_price += 55000;
			}
		
		}
			total_price += (ROUGH_CONSTRUCTION + FINAL_WORK + PAINT);
				return total_price;
	}



		public static int utilizationGroups (String[] work, String typeUtilization) {
			int count = 0; //Contador de materiales en el mismo grupo
				for (int a = 0; a < work.length(); a++) {
					if (work[a].equalsIgnoreCase(typeUtilization)) {
							count++;
			}
			return count;
	}
	
	
	
		public static String[] utilizationsArrays (String[] work, String typeUtilization, String name) {
			int groups = utilizationGroups(work);
			String[] separation = new String [groups];
			int position = 0; // variable entera que indica la posicion en el arreglo donde esta el material de esa utilidad
				for (int a = 0; a < work.length(); a++) {
					if (work[a].equalsIgnoreCase(typeUtilization)){
						separation[position] = work[a];
							position++;
						}
					}
			
				return separation;
	}

				
				

	
     
	
}
	