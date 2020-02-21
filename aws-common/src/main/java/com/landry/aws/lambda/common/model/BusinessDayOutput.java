package com.landry.aws.lambda.common.model;

public class BusinessDayOutput
{
	public BusinessDayOutput()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	private String info;
	private String date;

	public String getInfo()
	{
		return info;
	}

	public void setInfo( String info )
	{
		this.info = info;
	}

	public String getDate()
	{
		return date;
	}

	public void setDate( String date )
	{
		this.date = date;
	}

	@Override
	public String toString()
	{
		return "BusinessDayOutput [info=" + info + ", date=" + date + "]";
	}

	public static class Builder
	{
		private String info;
		private String date;

		public Builder info( String info )
		{
			this.info = info;
			return this;
		}

		public Builder date( String date )
		{
			this.date = date;
			return this;
		}

		public BusinessDayOutput build()
		{
			return new BusinessDayOutput(this);
		}
	}

	private BusinessDayOutput(Builder builder)
	{
		this.info = builder.info;
		this.date = builder.date;
	}
}