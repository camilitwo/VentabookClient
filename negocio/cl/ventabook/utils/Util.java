package cl.ventabook.utils;

import java.text.NumberFormat;
import java.util.Currency;

public class Util {
	
	
	 public static String formatPrice(double amnt) {
	    NumberFormat formatter = NumberFormat.getCurrencyInstance();
	    Currency currency = Currency.getInstance("CLP");
	    formatter.setCurrency(currency);
	    return formatter.format(amnt);
	}

}
