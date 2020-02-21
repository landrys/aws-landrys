package com.landry.aws.lambda.dynamo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverterFactory;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.landry.aws.lambda.dynamo.domain.VendorShipTime;
import com.landry.aws.lambda.dynamo.domain.VendorShipTimeSupport;
import com.landry.aws.lambda.dynamo.manager.DynamoDBManager;

public class DynamoVendorShipTimeDAO implements VendorShipTimeDAO
{

	private static final DynamoDBMapper mapper = DynamoDBManager.mapper();

	private static volatile DynamoVendorShipTimeDAO instance;

	private DynamoVendorShipTimeDAO()
	{
	}

	public static DynamoVendorShipTimeDAO instance()
	{

		if (instance == null)
		{
			synchronized (DynamoVendorShipTimeDAO.class)
			{
				if (instance == null)
					instance = new DynamoVendorShipTimeDAO();
			}
		}
		return instance;
	}

	@Override
	public List<VendorShipTime> findAll()
	{
		return mapper.scan(VendorShipTime.class, new DynamoDBScanExpression());
	}

	@Override
	public void write( VendorShipTime vst )
	{
		mapper.save(vst, DynamoDBMapperConfig.builder()
				.withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.UPDATE_SKIP_NULL_ATTRIBUTES).build());
				/*
				.withTypeConverterFactory(DynamoDBTypeConverterFactory.standard().override()
				.with(String.class, MyBoolean.class, new StringToMyBoolean())
				.build()));
				*/
	}

	@Override
	public List<VendorShipTime> findByVendorId( Integer vendorId )
	{

	        Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
	        eav.put(":val1", new AttributeValue().withN(vendorId.toString()));

	        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
	            .withFilterExpression("vendorId = :val1").withExpressionAttributeValues(eav);

	        List<VendorShipTime> scanResult = mapper.scan(VendorShipTime.class, scanExpression);

	        return scanResult;
	}

	@Override
	public VendorShipTime findById( Integer id )
	{

		Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
		eav.put(":val1", new AttributeValue().withN(id.toString()));

		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression().withFilterExpression("id = :val1")
				.withExpressionAttributeValues(eav);

		List<VendorShipTime> scanResult = mapper.scan(VendorShipTime.class, scanExpression);

		if (scanResult == null)
			return null;
		else
			return scanResult.get(0);
	}


	@Override
	public void delete( VendorShipTime vst )
	{
		mapper.delete(vst);
		System.out.println("Deleted Vendor Ship Time Entry: " + vst);
	}


}
