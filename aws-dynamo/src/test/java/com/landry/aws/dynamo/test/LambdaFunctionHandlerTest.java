package com.landry.aws.dynamo.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.landry.aws.lambda.common.model.LCProxyInput;
import com.landry.aws.lambda.dynamo.dao.DynamoLCOAuthClientDAO;
import com.landry.aws.lambda.dynamo.dao.LCOAuthClientDAO;
import com.landry.aws.lambda.dynamo.dao.DynamoVendorShipTimeSupportDAO;
import com.landry.aws.lambda.dynamo.dao.VendorShipTimeSupportDAO;
import com.landry.aws.lambda.dynamo.domain.LCOAuthClient;
import com.landry.aws.lambda.dynamo.domain.VendorShipTimeSupport;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class LambdaFunctionHandlerTest {

    private ObjectMapper objectMapper = new ObjectMapper();
	private static final LCOAuthClientDAO dao = DynamoLCOAuthClientDAO.instance();
	private static final VendorShipTimeSupportDAO vstsDao = DynamoVendorShipTimeSupportDAO.instance();

    @BeforeClass
    public static void createString() throws IOException {
    }

    private Context createContext() {
        TestContext ctx = new TestContext();
        ctx.setFunctionName("Your Function Name");
        return ctx;
    }

	@Test
	public void testLCOAuthClient() throws Exception {
		List<LCOAuthClient> out = dao.findAll();
		for ( LCOAuthClient model : out )
			System.out.println(model);
	}

	@Test
	public void testVSTS() throws Exception {
		List<VendorShipTimeSupport> out = vstsDao.findAll();
		for ( VendorShipTimeSupport model : out )
			System.out.println(model);
	}

	@Test
	public void testVSTSFindBySupport() throws Exception {
		VendorShipTimeSupport out = vstsDao.findBySupport(VendorShipTimeSupport.CUSTOM_FUTURE_HOLIDAYS_SUPPORT);
		System.out.println(out);
	}




	@Test
	public void outputJson() throws Exception {
		VendorShipTimeSupport vsts = new VendorShipTimeSupport();
		System.out.println(objectMapper.writeValueAsString(vsts));
	}

}
