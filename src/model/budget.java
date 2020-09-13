package model;
import ui.*;
import java.util.Scanner;
public class budget {
	private final static double BLACK_WORK = 1300000;
	private final static double WHITE_WORK = 2600000;
	private final static double PAINT = 980000;
	
	public static double total_homecenter() {
		Scanner sc = new Scanner(System.in);
		int result = main.ask_for_general_amount(sc);
		double[] each_product_amount= main.ask_for_product_amount(sc, result);
		double[] price_hc =	main.price_homecenter(sc, result);
		double total_hc = 0;
		for (int i = 0; i < result; i++) {
		total_hc += (each_product_amount[i]*price_hc[i]);
	}
		total_hc += (PAINT + WHITE_WORK + BLACK_WORK);
		return total_hc;
	}	
	
	
	

	
}
	