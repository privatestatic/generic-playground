package de.playground.playingwithtracks.responses;

import java.util.Map;

import junit.framework.Assert;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.playground.playingwithtracks.prototype.container.Entity;
import de.playground.playingwithtracks.responses.types.ListEntityResponseObject;

public class ListEntityResponseTest {

	private static final Logger log = LoggerFactory
			.getLogger(ListEntityResponseTest.class);

	private static final String ID_0 = "1ff3a55f94e954ee";
	private static final String ID_0_NAME = "Chevrolet Volt 001";
	private static final String ID_0_TYPE = "AUTOMOBILE";
	private static final String ID_1 = "ec6053f142ade5c9";
	private static final String ID_1_NAME = "Ford Fiesta 001";
	private static final String ID_1_TYPE = "AUTOMOBILE";
	private static final String LIST_ENTITY_RESPONSE_STRING = "{\"entities\": ["
			+ "{\"id\": \""
			+ ID_0
			+ "\",\"name\": \""
			+ ID_0_NAME
			+ "\",\"type\": \""
			+ ID_0_TYPE
			+ "\"},"
			+ "{\"id\": \""
			+ ID_1
			+ "\",\"name\": \""
			+ ID_1_NAME
			+ "\",\"type\": \""
			+ ID_1_TYPE
			+ "\"}" + "]}";

	private ListEntityResponse underTest = new ListEntityResponse();
	JSONObject jsonObject;

	@Test
	public void constructResponse() {
		try {
			jsonObject = new JSONObject(LIST_ENTITY_RESPONSE_STRING);
		} catch (JSONException e) {
			log.error(e.toString());
		}
		ListEntityResponseObject listEntityResponseObject = underTest
				.constructResponse(jsonObject);
		Map<String, Entity> entityMap = listEntityResponseObject.getEntityMap();
		Assert.assertEquals(ID_0_NAME, entityMap.get(ID_0).getName());
		Assert.assertEquals(ID_0_TYPE, entityMap.get(ID_0).getType());
		Assert.assertEquals(ID_1_NAME, entityMap.get(ID_1).getName());
		Assert.assertEquals(ID_1_TYPE, entityMap.get(ID_1).getType());
	}

	@Test
	public void constructResponseSomeAreWrong() {
		try {
			jsonObject = new JSONObject(LIST_ENTITY_RESPONSE_STRING);
		} catch (JSONException e) {
			log.error(e.toString());
		}
		ListEntityResponseObject listEntityResponseObject = underTest
				.constructResponse(jsonObject);
		Map<String, Entity> entityMap = listEntityResponseObject.getEntityMap();
		Assert.assertNotSame(ID_1_NAME, entityMap.get(ID_0).getName());
		Assert.assertNotSame(ID_1_TYPE, entityMap.get(ID_0).getType());
		Assert.assertNotSame(ID_0_NAME, entityMap.get(ID_1).getName());
		Assert.assertNotSame(ID_0_TYPE, entityMap.get(ID_1).getType());
	}
}
