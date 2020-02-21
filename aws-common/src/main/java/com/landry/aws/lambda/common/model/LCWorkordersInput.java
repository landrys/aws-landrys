package com.landry.aws.lambda.common.model;

public class LCWorkordersInput
{
	public LCWorkordersInput()
	{
		super();
	}

	String query;

	public static class Builder
	{
		private String query;

		public Builder query( String query )
		{
			this.query = query;
			return this;
		}

		public LCWorkordersInput build()
		{
			return new LCWorkordersInput(this);
		}
	}

	private LCWorkordersInput(Builder builder)
	{
		this.query = builder.query;
	}

	public String getQuery()
	{
		return query;
	}

	public void setQuery( String query )
	{
		this.query = query;
	}

}
