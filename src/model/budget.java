package model;
import ui.*;
import java.util.Scanner;
public class Budget {
	
	private final static double ROUGH_CONSTRUCTION = 1300000;
	private final static double FINAL_WORK = 2600000;
	private final static double PAINT = 980000;
	
	
	public Budget(){
	}
	
		/**
		*This method saves the total price taking into account the delivery and the workforce.
		*<b>pre: </b> The arrays where the prices are saved have to be inicializated.
		*<b>post: </b> The total price will be save. 
		*@param homecenterPrices Price of each material in HomeCenter. homecenterPrices > 0 && homecenterPrices != null.
		*@param centerstorePrices Price of each material in the Center store. centerstorePrices > 0 && centerstorePrices != null.
		*@param neighborhoodPrices Price of each material in the Neighborhood store. neighborhoodPrices > 0 && neighborhoodPrices != null.
		*@param generalAmount Total amount of materials for the construction. generalAmount > 0 && generalAmount != null.
		*@param materialsQuantity Quantity of each item. In the Main is: eachAmount > 0 && eachAmount != null.
		*@param location The location of the user. location != "" && location != null.
		*/ 
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
			} 
				
				totalPrice += (ROUGH_CONSTRUCTION + FINAL_WORK + PAINT);
				return totalPrice;
	}
			/**
			*This method compare the prices for each item in all the stores and saves the cheaper price for each one of them. 
			*<b>pre: </b> The arrays where the prices are saved have to be inicializated.
			*<b>post: </b> The cheaper price for each material will be save with the name of the store where it cost that. 
			*@param homecenterPrices Price of each material in HomeCenter. homecenterPrices > 0 && homecenterPrices != null.
			*@param centerstorePrices Price of each material in the Center store. centerstorePrices > 0 && centerstorePrices != null.
			*@param neighborhoodPrices Price of each material in the Neighborhood store. neighborhoodPrices > 0 && neighborhoodPrices != null.
			*/ 

	
		public int[] cheaperPrice (int[] homecenterPrices, int[] centerstorePrices, int[] neighborhoodPrices) {
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
	