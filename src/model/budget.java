package model;
import ui.*;
import java.util.Scanner;
public class Budget {
	
	private final static double ROUGH_CONSTRUCTION = 1300000;
	private final static double FINAL_WORK = 2600000;
	private final static double PAINT = 980000;
	
	/**
	*
	
	
	
	*/
	
	public Budget(){
	}
		public double totalStore(int[] materialsPrice, int[] materialsQuantity, int generalAmount, String location) {
			double totalPrice = 0;
			for (int i = 0; i < generalAmount; i++) {
				totalPrice += (materialsQuantity[i]* materialsPrice[i]);
			}	
				if (totalPrice < 80000) {
					if (location.equalsIgnoreCase("Norte") || location.equalsIgnoreCase("Sur")) {
						totalPrice	+= 120000;
					}
				}else if (location.equalsIgnoreCase("Centro")) {
					totalPrice += 50000;
				}
			if (totalPrice < 300000) {
					if (location.equalsIgnoreCase("Norte")) {
					totalPrice += 28000;
				}else if(location.equalsIgnoreCase("Sur")) {
					totalPrice += 55000;
				}
			} else if (totalPrice >= 300000) {
			}
				
				totalPrice += (ROUGH_CONSTRUCTION + FINAL_WORK + PAINT);
				return totalPrice;
	}
			

	
	
		public static int[] cheaperPrice (int[] homecenterPrices, int[] centerstorePrices, int[] neighborhoodPrices) {
			int[] cheaper = new int [homecenterPrices.length];
			for(int i = 0; i < homecenterPrices.length; i++) {
				if (homecenterPrices[i] < centerstorePrices[i] && homecenterPrices[i] < neighborhoodPrices[i]) {
						cheaper[i] = homecenterPrices[i];
					}
				else if (centerstorePrices[i] < homecenterPrices[i] && centerstorePrices[i] < neighborhoodPrices[i]) {
						cheaper[i] = centerstorePrices[i];
					}
					else {
						cheaper[i] = neighborhoodPrices[i];
					}
			}
			
			return cheaper;
		}
		
		
		
		
			
				
				

	
     
	
}
	