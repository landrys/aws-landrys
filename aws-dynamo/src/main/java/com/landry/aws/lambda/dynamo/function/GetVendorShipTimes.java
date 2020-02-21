package com.landry.aws.lambda.dynamo.function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.landry.aws.lambda.common.util.LambdaFunctions;
import com.landry.aws.lambda.dynamo.dao.DynamoVendorShipTimeDAO;
import com.landry.aws.lambda.dynamo.domain.VendorShipTime;

/**
 * Lambda function that returns all vendor ship time entries.
 */
public class GetVendorShipTimes implements RequestHandler<String, List<VendorShipTime>>
{

	private static final DynamoVendorShipTimeDAO vstDao = DynamoVendorShipTimeDAO.instance();

	@Override
	public List<VendorShipTime> handleRequest( String input, Context context )
	{
		System.out.println(LambdaFunctions.GET_VENDOR_SHIP_TIMES);
		if ( input==null )
			return null;
		List<VendorShipTime> data = vstDao.findAll();
		for ( VendorShipTime bean : data ) {
			if ( bean.getWarehouse() == null )
				bean.setWarehouse(":");
			bean.setSelectName(bean.getName() + bean.getWarehouse());
		}
		
		List<VendorShipTime> newList = new ArrayList<VendorShipTime>(data);


		Collections.sort(newList, new Comparator<VendorShipTime>(){
			  public int compare(VendorShipTime p1, VendorShipTime p2){
			    return p1.getSelectName().compareTo(p2.getSelectName());
			  }
			});

		return newList;
	}
}