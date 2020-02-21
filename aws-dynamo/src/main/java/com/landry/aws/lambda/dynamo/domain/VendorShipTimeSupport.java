package com.landry.aws.lambda.dynamo.domain;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "VendorShipTimeSupport")
public class VendorShipTimeSupport implements Serializable
{

	private static final long serialVersionUID = 8504979766109920430L;

	// name of support where the row contains the defaults.
	public static final String DEFAULT_SUPPORT = "defaults";
	public static final String MAX_DATA_SUPPORT = "maxData";
	public static final String LAST_GET_SUPPORT = "lastGet";
	public static final String CUSTOM_FUTURE_HOLIDAYS_SUPPORT = "customFutureHolidays";

	@DynamoDBHashKey
	private String support;

	@DynamoDBAttribute
	private String cutOffTime;

	@DynamoDBAttribute
	private Integer id;

	@DynamoDBAttribute
	private Integer leadBusinessDays;

	@DynamoDBAttribute
	private Map<String, String> readMe;

	@DynamoDBAttribute
	private Integer vendorId;

	@DynamoDBAttribute
	private Integer shippingDays;

	@DynamoDBAttribute
	private String timestamp;

	@DynamoDBAttribute
	private Set<String> futureHolidays;

	public Integer getId()
	{
		return id;
	}

	public void setId( Integer id )
	{
		this.id = id;
	}

	public Integer getVendorId()
	{
		return vendorId;
	}

	public void setVendorId( Integer vendorId )
	{
		this.vendorId = vendorId;
	}

	public Integer getShippingDays()
	{
		return shippingDays;
	}

	public void setShippingDays( Integer shippingDays )
	{
		this.shippingDays = shippingDays;
	}

	public String getCutOffTime()
	{
		return cutOffTime;
	}

	public void setCutOffTime( String cutOffTime )
	{
		this.cutOffTime = cutOffTime;
	}

	public Integer getLeadBusinessDays()
	{
		return leadBusinessDays;
	}

	public void setLeadBusinessDays( Integer leadBusinessDays )
	{
		this.leadBusinessDays = leadBusinessDays;
	}

	public String getSupport()
	{
		return support;
	}

	public void setSupport( String support )
	{
		this.support = support;
	}

	public Map<String, String> getReadMe()
	{
		return readMe;
	}

	public void setReadMe( Map<String, String> readMe )
	{
		this.readMe = readMe;
	}

	public String getTimestamp()
	{
		return timestamp;
	}

	public void setTimestamp( String timestamp )
	{
		this.timestamp = timestamp;
	}

	public Set<String> getFutureHolidays()
	{
		return futureHolidays;
	}

	public void setFutureHolidays( Set<String> futureHolidays )
	{
		this.futureHolidays = futureHolidays;
	}



	@Override
	public String toString()
	{
		return "VendorShipTimeSupport [support=" + support + ", cutOffTime=" + cutOffTime + ", id=" + id
				+ ", leadBusinessDays=" + leadBusinessDays + ", readMe=" + readMe + ", vendorId=" + vendorId
				+ ", shippingDays=" + shippingDays + ", timestamp=" + timestamp + ", futureHolidays=" + futureHolidays + "]";
	}

}
