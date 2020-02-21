package com.landry.aws.lambda.dynamo.function;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.landry.aws.lambda.dynamo.dao.DynamoVendorShipTimeDAO;
import com.landry.aws.lambda.dynamo.domain.VendorShipTime;

/**
 * Lambda function that returns all vendor ship time entries.
 */
public class GetVendorShipTimesByVendorId implements RequestHandler<Integer, List<VendorShipTime>>
{

	private static final DynamoVendorShipTimeDAO vstDao = DynamoVendorShipTimeDAO.instance();

	@Override
	public List<VendorShipTime> handleRequest(  Integer vendorId, Context context )
	{
		List<VendorShipTime> data = vstDao.findByVendorId(vendorId);
		return data;
	}
}