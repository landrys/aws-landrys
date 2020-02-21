package com.landry.aws.lambda.common.util;

public interface LambdaFunctions
{

	public static final String DATE_BUSINESS_DAYS_OUT = "dateBusinessDaysOut:PROD";
	public static final String DUE_DATE = "dueDate:PROD";
	public static final String LC_VENDOR_ADAPTER = "lcVendorAdapter:PROD";
	public static final String GET_VENDOR_SHIP_TIMES = "getVendorShipTimes:PROD";
	public static final String LC_PROXY = "lCProxy:PROD";
	public static final String GET_LC_OAUTH_CLIENTS = "getLCOAuthClients:PROD";
	public static final String LC_BUCKET_LEVEL_CHECKER = "checkLCBucketLevels:PROD";
	public static final String LC_WORKORDERS = "getWorkordersFromLC:PROD";
	public static final String LC_WORKORDER_STATUSES = "getAllWorkorderStatusesFromLC:PROD";

}
