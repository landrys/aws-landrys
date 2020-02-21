package com.landry.aws.lambda.dynamo.function;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.landry.aws.lambda.dynamo.dao.DynamoVendorShipTimeSupportDAO;
import com.landry.aws.lambda.dynamo.domain.VendorShipTimeSupport;

/**
 * Lambda function that returns all vendor ship time entries.
 */
public class WriteVendorShipTimeSupport implements RequestHandler<VendorShipTimeSupport, String>
{

	private static final DynamoVendorShipTimeSupportDAO vstDao = DynamoVendorShipTimeSupportDAO.instance();

	// I do not think I need this yet
	@Override
	public String handleRequest( VendorShipTimeSupport input, Context context )
	{

		// vstDao.write(input);
		vstDao.delete(input);
		return "done";

	}
}