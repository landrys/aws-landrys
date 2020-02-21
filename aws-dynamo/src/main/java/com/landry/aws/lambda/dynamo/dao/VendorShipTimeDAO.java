package com.landry.aws.lambda.dynamo.dao;

import java.util.List;

import com.landry.aws.lambda.dynamo.domain.VendorShipTime;

public interface VendorShipTimeDAO
{
	List<VendorShipTime> findAll();
	List<VendorShipTime> findByVendorId( Integer vendorId);
	VendorShipTime findById( Integer id);
	void write(VendorShipTime vst);
	void delete(VendorShipTime vst);

}
