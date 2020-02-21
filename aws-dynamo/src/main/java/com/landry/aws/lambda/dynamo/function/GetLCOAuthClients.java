package com.landry.aws.lambda.dynamo.function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.landry.aws.lambda.common.util.LambdaFunctions;
import com.landry.aws.lambda.dynamo.dao.DynamoLCOAuthClientDAO;
import com.landry.aws.lambda.dynamo.domain.LCOAuthClient;

/**
 * Lambda function that returns all vendor ship time entries.
 */
public class GetLCOAuthClients implements RequestHandler<String, List<LCOAuthClient>>
{

	private static final DynamoLCOAuthClientDAO vstDao = DynamoLCOAuthClientDAO.instance();

	@Override
	public List<LCOAuthClient> handleRequest( String input, Context context )
	{
		System.out.println(LambdaFunctions.GET_LC_OAUTH_CLIENTS);
		if ( input==null )
			return null;
		List<LCOAuthClient> data = vstDao.findAll();
		List<LCOAuthClient> newList = new ArrayList<LCOAuthClient>(data);


		Collections.sort(newList, new Comparator<LCOAuthClient>(){
			  public int compare(LCOAuthClient p1, LCOAuthClient p2){
			    return p1.getBucketLevel().compareTo(p2.getBucketLevel());
			  }
			});

		return newList;
	}
}