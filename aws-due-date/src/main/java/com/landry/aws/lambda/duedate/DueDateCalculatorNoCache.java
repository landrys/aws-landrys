package com.landry.aws.lambda.duedate;

import java.util.Set;
import org.joda.time.DateTime;

import com.landry.aws.lambda.businessday.BusinessDayService;
import com.landry.aws.lambda.common.util.MyDateUtil;
import com.landry.aws.lambda.duedate.model.VendorShipTimeDataBean;
import com.landry.aws.lambda.duedate.model.VendorShipTimeDataBeanBuilder2;
import com.landry.aws.lambda.duedate.model.CustomHolidaysBuilder;


public class DueDateCalculatorNoCache
{
	private DateTime arrivalDate;
	private DateTime startDate;
	private Integer vendorShipTimeId;
	private VendorShipTimeDataBean vendorShipTime;
	private String store;
	private Set<String> customHolidays;

	public DateTime getArrivalDate2() throws Exception
	{
		loadVendorShipTime();
		loadCustomHolidays();
		calculateArrivalDate();
		return arrivalDate;
	}

	private void loadCustomHolidays() throws Exception
	{
		CustomHolidaysBuilder chb = new CustomHolidaysBuilder();
		customHolidays = chb.getCustomHolidays();
	}


	private void loadVendorShipTime() throws Exception
	{
		VendorShipTimeDataBeanBuilder2 vstb2 = new VendorShipTimeDataBeanBuilder2(vendorShipTimeId);
		vendorShipTime = vstb2.getVendorShipTime();
		// DEBUG
		System.out.println(vendorShipTime);
	}

	private void calculateArrivalDate()
	{
		if (vendorShipTime.isWeeklyOrder()) {
			startDate = getStartDateForWeeklyOrder();
		} else {
			// This can be a weekend day or holiday. The ArrivalDate stuff
			// will take care of moving it to a business day.
			startDate = getStartDateForRegularOrder();
		}

		arrivalDate = BusinessDayService.moveForward(vendorShipTime.getShippingDays(), startDate, customHolidays);


		if (!store.equalsIgnoreCase("Natick") && !vendorShipTime.isDropShipToStore())
			arrivalDate = BusinessDayService.moveForward(1, arrivalDate, customHolidays);

                if (vendorShipTime.isBike()) {
                    arrivalDate = BusinessDayService.moveForward(1, arrivalDate, customHolidays);
                    // Below add per Jen request add a day for bikes going to natick as well.
                    if (store.equalsIgnoreCase("Natick"))
                        arrivalDate = BusinessDayService.moveForward(1, arrivalDate, customHolidays);
                }
	}

	private DateTime getStartDateForWeeklyOrder()
	{
		WeeklyOrderStartDateCalculator wosdc = new WeeklyOrderStartDateCalculator.Builder()
				.vendorShipTime(vendorShipTime).startDate(DateTime.now()).customHolidays(customHolidays).build();
		return wosdc.getStartDate();
	}

	private DateTime getStartDateForRegularOrder()
	{
		return BusinessDayService.moveForward(vendorShipTime.getBusinessDays(),
				MyDateUtil.addDayToNowIfPastCutOffTime(vendorShipTime.getCutOffTime()), customHolidays);
	}

	public DateTime getStartDate()
	{
		return startDate;
	}

	public static class Builder
	{
		private Integer vendorShipTimeId;
		private String store;

		public Builder vendorShipTimeId( Integer vendorShipTimeId )
		{
			this.vendorShipTimeId = vendorShipTimeId;
			return this;
		}

		public Builder store( String store )
		{
			this.store = store;
			return this;
		}

		public DueDateCalculatorNoCache build()
		{
			return new DueDateCalculatorNoCache(this);
		}
	}

	private DueDateCalculatorNoCache(Builder builder)
	{
		this.vendorShipTimeId = builder.vendorShipTimeId;
		this.store = builder.store;
	}
}
