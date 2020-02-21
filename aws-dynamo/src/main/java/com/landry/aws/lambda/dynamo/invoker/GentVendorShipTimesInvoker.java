package com.landry.aws.lambda.dynamo.invoker;

import java.util.Set;

import com.amazonaws.services.lambda.invoke.LambdaFunction;
import com.landry.aws.lambda.common.util.LambdaFunctions;
import com.landry.aws.lambda.dynamo.domain.VendorShipTime;

public interface GentVendorShipTimesInvoker
{
	@LambdaFunction(functionName = LambdaFunctions.GET_VENDOR_SHIP_TIMES)
	Set<VendorShipTime> getVendorShipTimes( String input );
}