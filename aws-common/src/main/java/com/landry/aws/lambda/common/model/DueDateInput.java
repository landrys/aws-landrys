package com.landry.aws.lambda.common.model;

import java.util.List;

public class DueDateInput
{
	public DueDateInput()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	private List<Integer> vendorShipTimeIds;
	private String store;
	private Boolean reload;
	private Boolean ping;

	public List<Integer> getVendorShipTimeIds()
	{
		return vendorShipTimeIds;
	}

	public void setVendorShipTimeIds( List<Integer> vendorShipTimeIds )
	{
		this.vendorShipTimeIds = vendorShipTimeIds;
	}

	public String getStore()
	{
		return store;
	}

	public void setStore( String store )
	{
		this.store = store;
	}

	public Boolean getReload()
	{
		return reload;
	}

	public void setReload( Boolean reload )
	{
		this.reload = reload;
	}

	@Override
	public String toString()
	{
		return "DueDateInput [vendorShipTimeIds=" + vendorShipTimeIds + ", store=" + store + ", reload=" + reload
				+ ", ping=" + ping + "]";
	}

	public Boolean getPing()
	{
		return ping;
	}

	public void setPing( Boolean ping )
	{
		this.ping = ping;
	}

	public static class Builder
	{
		private List<Integer> vendorShipTimeIds;
		private String store;
		private Boolean reload;
		private Boolean ping;

		public Builder vendorShipTimeIds( List<Integer> vendorShipTimeIds )
		{
			this.vendorShipTimeIds = vendorShipTimeIds;
			return this;
		}

		public Builder store( String store )
		{
			this.store = store;
			return this;
		}

		public Builder reload( Boolean reload )
		{
			this.reload = reload;
			return this;
		}

		public Builder ping( Boolean ping )
		{
			this.ping = ping;
			return this;
		}

		public DueDateInput build()
		{
			return new DueDateInput(this);
		}
	}

	private DueDateInput(Builder builder)
	{
		this.vendorShipTimeIds = builder.vendorShipTimeIds;
		this.store = builder.store;
		this.reload = builder.reload;
		this.ping = builder.ping;
	}
}
