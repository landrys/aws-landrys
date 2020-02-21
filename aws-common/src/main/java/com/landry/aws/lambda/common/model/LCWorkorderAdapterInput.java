package com.landry.aws.lambda.common.model;

public class LCWorkorderAdapterInput
{
	String lastGet;
	Boolean ping;
	public String getLastGet()
	{
		return lastGet;
	}
	public void setLastGet( String lastGet )
	{
		this.lastGet = lastGet;
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
		return "LCVendorAdapterInput [lastGet=" + lastGet + ", ping=" + ping + "]";
	}

}
