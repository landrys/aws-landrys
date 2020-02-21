package com.landry.aws.lambda.dynamo.function;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.landry.aws.lambda.dynamo.dao.DynamoVendorShipTimeSupportDAO;
import com.landry.aws.lambda.dynamo.domain.VendorShipTimeSupport;

/**
 * Lambda function that returns all vendor ship time entries.
 */
public class GetVendorShipTimeSupports implements RequestHandler<String, List<VendorShipTimeSupport>>
{

	private static final DynamoVendorShipTimeSupportDAO vstDao = DynamoVendorShipTimeSupportDAO.instance();

	@Override
	public List<VendorShipTimeSupport> handleRequest( String input, Context context )
	{

		List<VendorShipTimeSupport> data = vstDao.findAll();
		return data;

	}
}