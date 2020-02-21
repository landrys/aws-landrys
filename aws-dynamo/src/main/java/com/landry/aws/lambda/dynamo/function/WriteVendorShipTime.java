package com.landry.aws.lambda.dynamo.function;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.landry.aws.lambda.dynamo.dao.DynamoVendorShipTimeDAO;
import com.landry.aws.lambda.dynamo.domain.VendorShipTime;

/**
 * Lambda function that returns all vendor ship time entries.
 */
public class WriteVendorShipTime implements RequestHandler<VendorShipTime, String>
{

	private static final DynamoVendorShipTimeDAO vstDao = DynamoVendorShipTimeDAO.instance();

	@Override
	public String handleRequest( VendorShipTime input, Context context )
	{
		vstDao.write(input);
		return "done";

	}
}