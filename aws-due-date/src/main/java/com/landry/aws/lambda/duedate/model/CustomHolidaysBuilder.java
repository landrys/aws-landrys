package com.landry.aws.lambda.duedate.model;

import java.util.Set;
import java.util.HashSet;
import org.joda.time.LocalDate;


import com.landry.aws.lambda.dynamo.dao.DynamoVendorShipTimeSupportDAO;
import com.landry.aws.lambda.dynamo.domain.VendorShipTimeSupport;


public class CustomHolidaysBuilder
{

	private static final DynamoVendorShipTimeSupportDAO vstsDao = DynamoVendorShipTimeSupportDAO.instance();

	private Set<String> customHolidays;

	public CustomHolidaysBuilder()
	{
		super();
		customHolidays = new HashSet<String>();
	}


	public synchronized Set<String> getCustomHolidays() throws Exception
	{
		loadCustomHolidays();
		return customHolidays;
	}


	private void loadCustomHolidays()
	{
		VendorShipTimeSupport vendorShipTimeSupport = vstsDao.findBySupport(VendorShipTimeSupport.CUSTOM_FUTURE_HOLIDAYS_SUPPORT);

		if (vendorShipTimeSupport != null)
			customHolidays = vendorShipTimeSupport.getFutureHolidays();

	}

}
