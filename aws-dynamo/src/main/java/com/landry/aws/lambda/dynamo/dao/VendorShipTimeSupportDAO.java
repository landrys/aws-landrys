package com.landry.aws.lambda.dynamo.dao;

import java.util.List;

import com.landry.aws.lambda.dynamo.domain.VendorShipTimeSupport;

public interface VendorShipTimeSupportDAO
{
	List<VendorShipTimeSupport> findAll();
	VendorShipTimeSupport findBySupport(String support);
	void write(VendorShipTimeSupport vsts);
	void delete(VendorShipTimeSupport vsts);
}
