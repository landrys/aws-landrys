package com.landry.aws.lambda.dynamo.domain;

import java.io.Serializable;
import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "LCOAuthClient")
public class LCOAuthClient implements Serializable
{

	private static final long serialVersionUID = -1522201263396681946L;

	@DynamoDBHashKey
	private String clientId;

	@DynamoDBAttribute
	private String refreshToken;

	@DynamoDBAttribute
	private String token;

	@DynamoDBAttribute
	private Integer bucketLevel;

	public String getClientId()
	{
		return clientId;
	}

	public void setClientId( String clientId )
	{
		this.clientId = clientId;
	}

	public String getRefreshToken()
	{
		return refreshToken;
	}

	public void setRefreshToken( String refreshToken )
	{
		this.refreshToken = refreshToken;
	}

	public String getToken()
	{
		return token;
	}

	public void setToken( String token )
	{
		this.token = token;
	}

	public Integer getBucketLevel()
	{
		return bucketLevel;
	}

	public void setBucketLevel( Integer bucketLevel )
	{
		this.bucketLevel = bucketLevel;
	}

	@Override
	public String toString()
	{
		return "LCOAuthClient [clientId=" + clientId +   ", refreshToken=" + refreshToken + ", token=" + token + ", bucketLevel=" + bucketLevel + "]";
	}
}
