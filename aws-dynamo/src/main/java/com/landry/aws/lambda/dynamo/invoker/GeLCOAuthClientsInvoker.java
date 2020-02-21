package com.landry.aws.lambda.dynamo.invoker;

import java.util.List;
import com.amazonaws.services.lambda.invoke.LambdaFunction;
import com.landry.aws.lambda.common.util.LambdaFunctions;
import com.landry.aws.lambda.dynamo.domain.LCOAuthClient;

public interface GeLCOAuthClientsInvoker
{
	@LambdaFunction(functionName = LambdaFunctions.GET_LC_OAUTH_CLIENTS)
	List<LCOAuthClient> getLCOAuthClients( String input );
}