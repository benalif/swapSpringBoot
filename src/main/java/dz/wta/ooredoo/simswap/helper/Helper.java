package dz.wta.ooredoo.simswap.helper;

import static java.lang.Math.random;

import java.util.Calendar;
import java.util.Date;

public class Helper {

	public static String getRandomCode() {
		int code = getRandomNumber(999, 9999);
		return Integer.toString(code);
	}

	public static int getRandomNumber(int lowerLimit, int upperLimit) {
		int value = (int) (random() * upperLimit);
		if (value < lowerLimit) {
			value += lowerLimit;
		}
		return value;
	}

	public static Date setExpiryDate(Date date, int number) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, number);

		return calendar.getTime();
	}
}
