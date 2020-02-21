package com.landry.aws.lambda.dynamo.dao;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.landry.aws.lambda.dynamo.domain.LCOAuthClient;
import com.landry.aws.lambda.dynamo.manager.DynamoDBManager;

public class DynamoLCOAuthClientDAO implements LCOAuthClientDAO
{

	private static final DynamoDBMapper mapper = DynamoDBManager.mapper();

	private static volatile DynamoLCOAuthClientDAO instance;

	private DynamoLCOAuthClientDAO()
	{
	}

	public static DynamoLCOAuthClientDAO instance()
	{

		if (instance == null)
		{
			synchronized (DynamoLCOAuthClientDAO.class)
			{
				if (instance == null)
					instance = new DynamoLCOAuthClientDAO();
			}
		}
		return instance;
	}

	@Override
	public List<LCOAuthClient> findAll()
	{
		return mapper.scan(LCOAuthClient.class, new DynamoDBScanExpression());
	}

	@Override
	public void write( LCOAuthClient vsts )
	{
		mapper.save(vsts, DynamoDBMapperConfig.builder()
				.withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.UPDATE_SKIP_NULL_ATTRIBUTES).build());

	}

	@Override
	public void delete( LCOAuthClient vsts )
	{
		mapper.delete(vsts);
	}

}
