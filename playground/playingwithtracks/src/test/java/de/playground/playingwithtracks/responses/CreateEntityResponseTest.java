package de.playground.playingwithtracks.responses;

import java.util.List;

import junit.framework.Assert;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.playground.playingwithtracks.responses.types.CreateEntityResponseObject;

public class CreateEntityResponseTest {

	private static final Logger log = LoggerFactory
			.getLogger(CreateEntityResponseTest.class);

	private static final String ID_0 = "ec6053f142ade5c9";
	private static final String ID_1 = "1ff3a55f94e954ee";
	private static final String ID_2 = "fb061e749fec1627";
	private static final String CREATE_ENTITY_RESPONSE_STRING = "{\"entityIds\": [\""
			+ ID_0 + "\",\"" + ID_1 + "\",\"" + ID_2 + "\"]}";

	private CreateEntityResponse underTest = new CreateEntityResponse();
	JSONObject jsonObject;

	@Test
	public void constructResponseSuccessfull() {
		try {
			jsonObject = new JSONObject(CREATE_ENTITY_RESPONSE_STRING);
		} catch (JSONException e) {
			log.error(e.toString());
		}
		CreateEntityResponseObject createEntityResponseObject = underTest
				.constructResponse(jsonObject);
		List<String> entityIds = createEntityResponseObject.getEntityIds();
		Assert.assertEquals("ec6053f142ade5c9", entityIds.get(0));
		Assert.assertEquals("1ff3a55f94e954ee", entityIds.get(1));
		Assert.assertEquals("fb061e749fec1627", entityIds.get(2));
	}

	@Test
	public void constructResponseSomeAreWrong() {
		try {
			jsonObject = new JSONObject(CREATE_ENTITY_RESPONSE_STRING);
		} catch (JSONException e) {
			log.error(e.toString());
		}
		CreateEntityResponseObject createEntityResponseObject = underTest
				.constructResponse(jsonObject);
		List<String> entityIds = createEntityResponseObject.getEntityIds();
		Assert.assertNotSame("ec6053f142ade5c9", entityIds.get(2));
		Assert.assertEquals("1ff3a55f94e954ee", entityIds.get(1));
		Assert.assertNotSame("fb061e749fec1627", entityIds.get(0));
	}
}
