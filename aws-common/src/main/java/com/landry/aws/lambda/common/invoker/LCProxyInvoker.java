package com.landry.aws.lambda.common.invoker;

import com.amazonaws.services.lambda.invoke.LambdaFunction;
import com.landry.aws.lambda.common.model.LCProxyInput;
import com.landry.aws.lambda.common.util.LambdaFunctions;

public interface LCProxyInvoker
{
	@LambdaFunction(functionName = LambdaFunctions.LC_PROXY)
	String lcProxy( LCProxyInput input );
}