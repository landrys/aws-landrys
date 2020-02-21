package com.landry.aws.lambda.common.model;

public class DueDateOutput extends Output
{
	public DueDateOutput()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	private String arrivalDate;
	private String nextOrderDate;
	private int vendorShipTimeId;
	private DueDateInput dueDateInput;

	public String getArrivalDate()
	{
		return arrivalDate;
	}

	public void setArrivalDate( String arrivalDate )
	{
		this.arrivalDate = arrivalDate;
	}

	public String getNextOrderDate()
	{
		return nextOrderDate;
	}

	public void setNextOrderDate( String nextOrderDate )
	{
		this.nextOrderDate = nextOrderDate;
	}

	public int getVendorShipTimeId()
	{
		return vendorShipTimeId;
	}

	public void setVendorShipTimeId( int vendorShipTimeId )
	{
		this.vendorShipTimeId = vendorShipTimeId;
	}

	public static class Builder
	{
		private String info;
		private String arrivalDate;
		private String nextOrderDate;
		private int vendorShipTimeId;
		private DueDateInput dueDateInput;

		public Builder dueDateInput( DueDateInput dueDateInput )
		{
			this.dueDateInput = dueDateInput;
			return this;
		}

		public Builder info( String info )
		{
			this.info = info;
			return this;
		}

		public Builder arrivalDate( String arrivalDate )
		{
			this.arrivalDate = arrivalDate;
			return this;
		}

		public Builder nextOrderDate( String nextOrderDate )
		{
			this.nextOrderDate = nextOrderDate;
			return this;
		}

		public Builder vendorShipTimeId( int vendorShipTimeId )
		{
			this.vendorShipTimeId = vendorShipTimeId;
			return this;
		}

		public DueDateOutput build()
		{
			return new DueDateOutput(this);
		}
	}

	private DueDateOutput(Builder builder)
	{
		this.info = builder.info;
		this.arrivalDate = builder.arrivalDate;
		this.nextOrderDate = builder.nextOrderDate;
		this.vendorShipTimeId = builder.vendorShipTimeId;
		this.dueDateInput = builder.dueDateInput;
	}

	@Override
	public String toString()
	{
		return "DueDateOutput [arrivalDate=" + arrivalDate + ", nextOrderDate=" + nextOrderDate + ", vendorShipTimeId="
				+ vendorShipTimeId + ", info=" + info + ", dueDateInput=" + dueDateInput.toString() + "]";
	}

	public DueDateInput getDueDateInput()
	{
		return dueDateInput;
	}

	public void setDueDateInput( DueDateInput dueDateInput )
	{
		this.dueDateInput = dueDateInput;
	}
}
