package util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Helper {
	public static String formatRupiah(float gaji) {
		DecimalFormatSymbols simbol = new DecimalFormatSymbols();
		simbol.setCurrencySymbol("Rp ");
		simbol.setMonetaryDecimalSeparator(',');
		simbol.setGroupingSeparator('.');
		DecimalFormat format = (DecimalFormat) DecimalFormat.getCurrencyInstance();
		format.setDecimalFormatSymbols(simbol);
		format.setMaximumFractionDigits(0);
		
		return format.format(gaji);
	}
}
