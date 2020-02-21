package com.landry.aws.lambda.common.invoker;

import com.amazonaws.services.lambda.invoke.LambdaFunction;
import com.landry.aws.lambda.common.model.BusinessDayInput;
import com.landry.aws.lambda.common.model.BusinessDayOutput;
import com.landry.aws.lambda.common.util.LambdaFunctions;

public interface DateBusinessDaysOut
{
  @LambdaFunction(functionName=LambdaFunctions.DATE_BUSINESS_DAYS_OUT)
  BusinessDayOutput dateBusinessDaysOut(BusinessDayInput input);
}