package model;
import ui.*;
import java.util.Scanner;
public class budget {
	
	private final static double ROUGH_CONSTRUCTION = 1300000;
	private final static double FINAL_WORK = 2600000;
	private final static double PAINT = 980000;
	
	private final static string obraNegra = "";
	private final static string obraBlanca = "";
	private final static string pintura = "";
	
	
		public static double total_store(homecenter_prices, centerstore_prices, neighborhood_prices, work) {
			Scanner ab = new Scanner(System.in);
			
			double delivery = 0;
			double[] total_price =	main.price_for_each_place(ab, result);
			double total_price = 0;
			for (int i = 0; i < result; i++) {
			total_price += (each_amount[i]*total_price[i]);
		}
		return total_price;		
}	

	if(name){
            if(name.equals("homecenter")){
                if(total_price<80000){
                    delivery=120000;
                }
                if(total_price<300000){
                    delivery=28000;
                }
                if(total_price>=300000){
                    delivery=120000;
                }
            if(name.equals("ferreteria del centro")){
                if(total_price<80000){
                    delivery=50000;
                }
                if(total_price<300000){
                    delivery=0;
                }
                if(total_price>=300000){
                    delivery=0;
                }
            if(name.equals("ferreteria del barrio")){
                if(total_price<80000){
                    delivery=120000;
                }
                if(total_price<300000){
                    delivery=55000;
                }
                if(total_price>=300000){
                    delivery=0;
                }
			}
          }
        }
		return delivery;
      }
     
	
}
	