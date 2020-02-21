package com.landry.aws.lambda.businessday;

import java.util.Set;
import java.util.HashSet;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.landry.aws.lambda.common.model.BusinessDayInput;
import com.landry.aws.lambda.common.model.BusinessDayOutput;
import com.landry.aws.lambda.common.util.LambdaFunctions;
import com.landry.aws.lambda.common.util.MyDateUtil;

public class LambdaFunctionHandler implements RequestHandler<BusinessDayInput, BusinessDayOutput> {

    @Override
    public BusinessDayOutput handleRequest(BusinessDayInput input, Context context) {
        context.getLogger().log("Input: " + input);
        context.getLogger().log("Function: " + LambdaFunctions.DATE_BUSINESS_DAYS_OUT);

        if ( input != null && input.getPing() != null )
        	return null;

        if (input.getBusinessDays() == null || input.getDate() == null )
			return new BusinessDayOutput.Builder().info("No valid business day or date given...").build();
		
	   return calculateDateBusinessDaysOut(input);

	}

	public BusinessDayOutput calculateDateBusinessDaysOut( BusinessDayInput input )
	{
		Set<String> dummySet = new HashSet<String>();
		DateTime date = BusinessDayService.moveForward(input.getBusinessDays(), MyDateUtil.toDateTime(input.getDate(), "MM-dd-yyyy"), dummySet);
		return new BusinessDayOutput.Builder().date(MyDateUtil.toStringDate(date, "MM-dd-yyyy")).build();
	}

}
