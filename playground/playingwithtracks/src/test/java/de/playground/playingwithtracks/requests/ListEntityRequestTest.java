package de.playground.playingwithtracks.requests;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import de.playground.playingwithtracks.URLConnectorJSON.Method;
import de.playground.playingwithtracks.prototype.container.EntityLister;

public class ListEntityRequestTest {

	private static final String ENTITYID_0 = "ec6053f142ade5c9";
	private static final String ENTITYID_1 = "1ff3a55f94e954ee";
	private static final String ENTITYID_2 = "fb061e749fec1627";
	private static final String MINID = "1ff3a55f94e954ee";
	private static final String EXPECTED_RESULT_STRING_MINID = "{\"minId\":\""
			+ MINID + "\"}";
	private static final String EXPECTED_RESULT_STRING_ENTITYIDS = "{\"entityIds\":[\""
			+ ENTITYID_0 + "\",\"" + ENTITYID_1 + "\",\"" + ENTITYID_2 + "\"]}";

	private static final String EXPECTED_REQUEST_URL = "https://www.googleapis.com/tracks/v1/entities/list";
	private static final Method EXPECTED_METHOD = Method.GET;

	private ListEntityRequest underTest;

	@Test
	public void constructRequestBodyMinId() {
		EntityLister entityLister = new EntityLister(MINID);
		underTest = new ListEntityRequest(entityLister);
		String result = underTest.getRequestBody();
		Assert.assertEquals(EXPECTED_RESULT_STRING_MINID, result);
	}

	@Test
	public void constructRequestBodyEntityIds() {
		List<String> entityIds = new ArrayList<String>();
		entityIds.add(ENTITYID_0);
		entityIds.add(ENTITYID_1);
		entityIds.add(ENTITYID_2);
		EntityLister entityLister = new EntityLister(entityIds);
		underTest = new ListEntityRequest(entityLister);
		String result = underTest.getRequestBody();
		Assert.assertEquals(EXPECTED_RESULT_STRING_ENTITYIDS, result);
	}

	@Test
	public void getRequestURL() {
		EntityLister entityLister = new EntityLister(MINID);
		underTest = new ListEntityRequest(entityLister);
		URL requestUrl = underTest.getRequestURL();
		Assert.assertEquals(EXPECTED_REQUEST_URL, requestUrl.toString());
	}

	@Test
	public void getHttpMethod() {
		EntityLister entityLister = new EntityLister(MINID);
		underTest = new ListEntityRequest(entityLister);
		Method method = underTest.getHttpMethod();
		Assert.assertEquals(EXPECTED_METHOD, method);
	}
}
