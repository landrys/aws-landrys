package com.landry.aws.lambda.dynamo.manager;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.landry.aws.lambda.common.util.MyConstants;

public class DynamoDBManager
{

	private static volatile DynamoDBManager instance;

	private DynamoDBMapper mapper;

	private DynamoDBManager()
	{
		/*
		 * Test configuration
		 */
		if (MyConstants.TESTING)
		{
			EndpointConfiguration endpointConfiguration = new EndpointConfiguration("http://localhost:8000",
					"us-east-1");
			AWSCredentials awsCreds = new BasicAWSCredentials("AKIAITXA4Q4J3CJTYP6Q", "1234");
			AWSCredentialsProvider credentialsProvider = new AWSStaticCredentialsProvider(awsCreds);
			AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
					.withEndpointConfiguration(endpointConfiguration).withCredentials(credentialsProvider).build();
			mapper = new DynamoDBMapper(client);
		}
		else
		{
			/*
			 * Production configuration
			 */
			AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
			mapper = new DynamoDBMapper(client);
		}
	}

	public static DynamoDBManager instance()
	{

		if (instance == null)
		{
			synchronized (DynamoDBManager.class)
			{
				if (instance == null)
					instance = new DynamoDBManager();
			}
		}

		return instance;
	}

	public static DynamoDBMapper mapper()
	{
		DynamoDBManager manager = instance();
		return manager.mapper;
	}

}
