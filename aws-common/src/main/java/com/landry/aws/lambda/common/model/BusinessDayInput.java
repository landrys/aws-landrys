package com.landry.aws.lambda.common.model;

public class BusinessDayInput
{
    private String date;
    private Integer businessDays;
    private Boolean ping;

	public String getDate()
	{
		return date;
	}
	public void setDate( String date )
	{
		this.date = date;
	}
	public Integer getBusinessDays()
	{
		return businessDays;
	}
	public void setBusinessDays( Integer businessDays )
	{
		this.businessDays = businessDays;
	}
	public Boolean getPing()
	{
		return ping;
	}
	public void setPing( Boolean ping )
	{
		this.ping = ping;
	}
	@Override
	public String toString()
	{
		return "BusinessDayInput [date=" + date + ", businessDays=" + businessDays + ", ping=" + ping + "]";
	}

}