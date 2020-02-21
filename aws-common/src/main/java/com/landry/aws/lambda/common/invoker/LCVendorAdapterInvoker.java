package com.landry.aws.lambda.common.invoker;

import com.amazonaws.services.lambda.invoke.LambdaFunction;
import com.landry.aws.lambda.common.model.LCVendorAdapterInput;
import com.landry.aws.lambda.common.util.LambdaFunctions;

public interface LCVendorAdapterInvoker
{
	@LambdaFunction(functionName = LambdaFunctions.LC_VENDOR_ADAPTER)
	String lcVendorAdapter( LCVendorAdapterInput input );
}