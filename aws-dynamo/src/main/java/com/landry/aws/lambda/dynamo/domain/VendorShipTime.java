package com.landry.aws.lambda.dynamo.domain;

import java.io.Serializable;
import java.util.Set;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel.DynamoDBAttributeType;

@DynamoDBTable(tableName = "VendorShipTime")
public class VendorShipTime implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3179136743372025607L;
	public static final String VENDOR_ID_INDEX = "vendorId-index";

	@DynamoDBIgnore
	private String selectName;

	@DynamoDBHashKey
	private Long id;

	@DynamoDBAttribute
	private String name;

	@DynamoDBTyped(DynamoDBAttributeType.BOOL)
	private Boolean dropShipToStore;

	@DynamoDBAttribute
	private Integer leadBusinessDays;

	@DynamoDBTyped(DynamoDBAttributeType.BOOL)
	private Boolean isBike;

	@DynamoDBIndexHashKey(globalSecondaryIndexName = VENDOR_ID_INDEX)
	private Integer vendorId;

	@DynamoDBTyped(DynamoDBAttributeType.BOOL)
	private Boolean weeklyOrder;

	@DynamoDBAttribute
	private Integer shippingDays;

	@DynamoDBAttribute
	private String warehouse;

	@DynamoDBAttribute
	private String cutOffTime;

	@DynamoDBAttribute
	private Set<Integer> regularOrderDays;

	@DynamoDBAttribute
	private String shippingCarrier;

	public Long getId()
	{
		return id;
	}

	public void setId( Long id )
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	public Boolean getDropShipToStore()
	{
		return dropShipToStore;
	}

	public void setDropShipToStore( Boolean dropShipToStore )
	{
		this.dropShipToStore = dropShipToStore;
	}

	public Boolean getIsBike()
	{
		return isBike;
	}

	public void setIsBike( Boolean isBike )
	{
		this.isBike = isBike;
	}

	public Integer getVendorId()
	{
		return vendorId;
	}

	public void setVendorId( Integer vendorId )
	{
		this.vendorId = vendorId;
	}

	public Boolean getWeeklyOrder()
	{
		return weeklyOrder;
	}

	public void setWeeklyOrder( Boolean weeklyOrder )
	{
		this.weeklyOrder = weeklyOrder;
	}

	public Integer getShippingDays()
	{
		return shippingDays;
	}

	public void setShippingDays( Integer shippingDays )
	{
		this.shippingDays = shippingDays;
	}

	public String getWarehouse()
	{
		return warehouse;
	}

	public void setWarehouse( String warehouse )
	{
		this.warehouse = warehouse;
	}

	public String getCutOffTime()
	{
		return cutOffTime;
	}

	public void setCutOffTime( String cutOffTime )
	{
		this.cutOffTime = cutOffTime;
	}

	public Set<Integer> getRegularOrderDays()
	{
		return regularOrderDays;
	}

	public void setRegularOrderDays( Set<Integer> regularOrderDays )
	{
		this.regularOrderDays = regularOrderDays;
	}

	public String getShippingCarrier()
	{
		return shippingCarrier;
	}

	public void setShippingCarrier( String shippingCarrier )
	{
		this.shippingCarrier = shippingCarrier;
	}

	public Integer getLeadBusinessDays()
	{
		return leadBusinessDays;
	}

	public void setLeadBusinessDays( Integer leadBusinessDays )
	{
		this.leadBusinessDays = leadBusinessDays;
	}

	@Override
	public String toString()
	{
		return "VendorShipTime [selectName=" + selectName + ", id=" + id + ", name=" + name + ", dropShipToStore="
				+ dropShipToStore + ", leadBusinessDays=" + leadBusinessDays + ", isBike=" + isBike + ", vendorId="
				+ vendorId + ", weeklyOrder=" + weeklyOrder + ", shippingDays=" + shippingDays + ", warehouse="
				+ warehouse + ", cutOffTime=" + cutOffTime + ", regularOrderDays=" + regularOrderDays
				+ ", shippingCarrier=" + shippingCarrier + "]";
	}

	public String getSelectName()
	{
		return selectName;
	}

	public void setSelectName( String selectName )
	{
		this.selectName = selectName;
	}

}
