package com.Banking.Utilities;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class AutomationCore {

	public static Object appType;
	public static String currentBrowser;

	/**
	 * This method Loads the config.properties file
	 */
	public Properties loadProperties() {
		InputStream instream = getClass().getClassLoader().getResourceAsStream("config.properties");
		if (instream != null) {
			Properties prop = new Properties();
			try {
				prop.load(instream);
				return prop;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * This method is used to get the property value from config.properties file.
	 * 
	 * @param propertyName
	 *            : The name of the property for which user need to retrieve the
	 *            value
	 * @return the property value for specified property name
	 * 
	 *         Ex: Environment("browserName"):- it returns the value of browserName
	 *         property from config.properties file
	 */
	public String Environment(String propertyName) {
		Properties propValue = loadProperties();
		// System.out.println("Property Name: "+propValue);
		return propValue.getProperty(propertyName);
	}

	/**
	 * This method is used to format the date type value into required date format
	 * in string
	 * 
	 * @param dateValue
	 *            The date value that is in other format
	 * @param format
	 *            Required format type to be formatted
	 * @return Returns the string type date value
	 *         <p>
	 *         Example:-
	 *         <p>
	 *         formatDateAndTime(13 dec 2015, "MM_dd_yyyy");
	 */
	public String formatDateAndTime(Date dateValue, String format) {
		SimpleDateFormat ft = new SimpleDateFormat(format);
		String formatedDateValue = ft.format(dateValue);
		return formatedDateValue;
	}

	public String formatDateAndTime(String dateValue, String inputformat, String outputFormat) {
		SimpleDateFormat inputDateFormat = new SimpleDateFormat(inputformat);
		SimpleDateFormat outputDateFormat = new SimpleDateFormat(outputFormat);
		String formatedDateValue = null;
		Date inputDate = null;
		try {
			inputDate = inputDateFormat.parse(dateValue);
			formatedDateValue = outputDateFormat.format(inputDate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return formatedDateValue;
	}

	/**
	 * This method is used to change the current Date format to expected date format
	 * 
	 * @param dateValue
	 *            The current date value that is supposed to change the format
	 * @param currentFormat
	 *            The current format of date value
	 * @param expFormat
	 *            The expected format that data is supposed to be
	 * @return Returns the a string type date value in expected format
	 * 
	 *         <p>
	 *         Example :- convertDateFromString(13 dec 2015, "dd MM yyyy"
	 */
	public String convertDateFromString(String dateValue, String currentFormat, String expFormat) {
		try {
			// Locale.setDefault(Locale.US);
			DateFormat ft = new SimpleDateFormat(currentFormat);
			DateFormat dft = new SimpleDateFormat(expFormat);
			Date formatedDateValue = (Date) ft.parse(dateValue);
			Date finalDate = (Date) dft.parse(formatedDateValue.toString());

			return finalDate.toString();

		} catch (Exception e) {
			e.getMessage();
		}
		return null;

	}

	/**
	 * This method is used to get the current time stamp
	 * 
	 * @return Current Date
	 */
	public Date getCurrentDateAndTime() {
		Date dNow = new Date();
		return dNow;
	}

	public Date getWeekDayCurrentDateAndTime() {
		try {
			Calendar cal = Calendar.getInstance();
			int day = cal.get(Calendar.DAY_OF_WEEK);
			if (day == Calendar.SUNDAY) {
				cal.add(Calendar.DATE, -2);
				return cal.getTime();
			} else if (day == Calendar.SATURDAY) {
				cal.add(Calendar.DATE, -1);
				return cal.getTime();
			} else {
				return getCurrentDateAndTime();
			}
		} catch (Exception e) {
			e.getMessage();
		}

		return null;
	}

	/**
	 * This method is used to get the difference between time values
	 * 
	 * @param time1
	 *            The start time value
	 * @param time2
	 *            The end time value
	 * @param formatValue
	 *            Format type of time to return
	 * @return Returns the long type time value
	 */
	public long timeDiffInSeconds(String time1, String time2, String formatValue) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(formatValue);
			Date date1 = format.parse(time1);
			Date date2 = format.parse(time2);
			long difference = date2.getTime() - date1.getTime();
			difference = (difference) / (1000);
			return difference;
		} catch (Exception e) {
			e.getMessage();
			return 0;
		}
	}

	/**
	 * This method is used to generate random string
	 * 
	 * @param length
	 *            of Int type
	 * @param strType
	 *            of string type
	 * @return Generate random string according to length and type Example:
	 *         Seleniumhelper.generateRandomString(4,"AB")
	 */
	public String generateRandomString(int length, String strType) {
		StringBuffer buffer = new StringBuffer();
		String characters = "";

		if (strType.equalsIgnoreCase("AB")) {
			characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		} else if (strType.equalsIgnoreCase("N")) {
			characters = "123456789";
		} else if (strType.equalsIgnoreCase("AN")) {
			characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		}

		int charactersLength = characters.length();

		for (int i = 0; i < length; i++) {
			double index = Math.random() * charactersLength;
			buffer.append(characters.charAt((int) index));
		}
		return buffer.toString().toUpperCase();
	}

	/**
	 * This method is used to generate random integer
	 * 
	 * @param minRange
	 *            of Int type
	 * @param maxRange
	 *            of Int type
	 * @return Generate random Int according to minRange and maxRange Example:
	 *         Seleniumhelper.generateRandomInteger(1,5)
	 */
	public double generateRandomInteger(int minRange, int maxRange) {
		int num = -1;
		try {
			num = maxRange - minRange;
			return minRange + (Math.random() * num);
		} catch (Exception e) {
			e.getMessage();
		}
		return -1;
	}

	public int generateRandomInteger(int maxRange) {
		int num = -1;
		try {
			num = maxRange;
			return new Double((Math.floor(Math.random() * maxRange))).intValue();
		} catch (Exception e) {
			e.getMessage();
		}
		return -1;
	}

}
