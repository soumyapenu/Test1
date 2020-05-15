package com.deere.applicaionSpecific;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author ng58485
 * This class is a storage of all global static variables
 */
public class GlobalThings {
	public static final String gUserIDAdmin = "APCEC6T";
	public static final Map<String , String> testData = new HashMap<String , String>();
	public static final Map<Integer , String> transLogEntries = new HashMap<Integer , String>();
	public static final ArrayList<String> pgmDelete = new ArrayList<String>();
	public static String windowHandle = "";
	public static int microWait = 4;
	public static int minWait = 20;
	public static int midWait = 180;
	public static int maxWait = 200;
	public static int supermaxWait = 400;
	public static int longWait = 800;
	public static final String availabilityStatusPublished = "Published";
	public static final String availabilityStatusUnPublished = "Unpublished";
	public static final String availabilityStatusDealerOnly = "Dealer Only";
}