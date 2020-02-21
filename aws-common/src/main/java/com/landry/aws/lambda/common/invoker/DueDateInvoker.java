package com.landry.aws.lambda.common.invoker;

import com.amazonaws.services.lambda.invoke.LambdaFunction;
import com.landry.aws.lambda.common.model.DueDateInput;
import com.landry.aws.lambda.common.model.DueDateOutput;
import com.landry.aws.lambda.common.util.LambdaFunctions;

public interface DueDateInvoker
{
	@LambdaFunction(functionName = LambdaFunctions.DUE_DATE)
	DueDateOutput dueDate( DueDateInput input );
}