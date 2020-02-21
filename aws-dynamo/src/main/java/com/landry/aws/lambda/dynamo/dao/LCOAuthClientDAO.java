package com.landry.aws.lambda.dynamo.dao;

import java.util.List;

import com.landry.aws.lambda.dynamo.domain.LCOAuthClient;

public interface LCOAuthClientDAO
{
	List<LCOAuthClient> findAll();
	void write(LCOAuthClient vsts);
	void delete(LCOAuthClient vsts);
}
