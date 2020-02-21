package com.landry.aws.lambda.dynamo.dao;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.landry.aws.lambda.dynamo.domain.VendorShipTimeSupport;
import com.landry.aws.lambda.dynamo.manager.DynamoDBManager;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

public class DynamoVendorShipTimeSupportDAO implements VendorShipTimeSupportDAO
{

	private static final DynamoDBMapper mapper = DynamoDBManager.mapper();

	private static volatile DynamoVendorShipTimeSupportDAO instance;

	private DynamoVendorShipTimeSupportDAO()
	{
	}

	public static DynamoVendorShipTimeSupportDAO instance()
	{

		if (instance == null)
		{
			synchronized (DynamoVendorShipTimeSupportDAO.class)
			{
				if (instance == null)
					instance = new DynamoVendorShipTimeSupportDAO();
			}
		}
		return instance;
	}

	@Override
	public List<VendorShipTimeSupport> findAll()
	{
		return mapper.scan(VendorShipTimeSupport.class, new DynamoDBScanExpression());
	}

	@Override
	public VendorShipTimeSupport findBySupport( String support )
	{

		Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
		eav.put(":val1", new AttributeValue().withS(support));


		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression().withFilterExpression("support = :val1")
				.withExpressionAttributeValues(eav);

		List<VendorShipTimeSupport> scanResult = mapper.scan(VendorShipTimeSupport.class, scanExpression);

		if (scanResult == null || scanResult.isEmpty() )
			return null;
		else
			return scanResult.get(0);
	}


	@Override
	public void write( VendorShipTimeSupport vsts )
	{
		mapper.save(vsts, DynamoDBMapperConfig.builder()
				.withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.UPDATE_SKIP_NULL_ATTRIBUTES).build());

	}

	@Override
	public void delete( VendorShipTimeSupport vsts )
	{
		mapper.delete(vsts);
	}

}
