package com.landry.aws.lambda.common.model;

public class LCProxyInput
{
	String apiCommand;
	Boolean ping;
	public String getApiCommand()
	{
		return apiCommand;
	}
	public void setApiCommand( String apiCommand )
	{
		this.apiCommand = apiCommand;
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
		return "LCVendorAdapterInput [apiCommand=" + apiCommand + ", ping=" + ping + "]";
	}

}
