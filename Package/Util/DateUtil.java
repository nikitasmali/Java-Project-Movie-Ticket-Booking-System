package com.moviebs.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil
{
	//parsing and printing the date-time objects
	static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	
	//obtains the current date-time from the system
    static LocalDateTime now = LocalDateTime.now();

    public static String getCurrentDateTime()
    {
        return now.format(format);
    }

}
