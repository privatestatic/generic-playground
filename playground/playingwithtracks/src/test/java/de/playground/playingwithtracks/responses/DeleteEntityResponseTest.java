package de.playground.playingwithtracks.responses;

import junit.framework.Assert;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.playground.playingwithtracks.responses.types.DeleteEntityResponseObject;

public class DeleteEntityResponseTest {

	private static final Logger log = LoggerFactory
			.getLogger(DeleteEntityResponseTest.class);

	private DeleteEntityResponse underTest = new DeleteEntityResponse();
	JSONObject jsonObject;

	@Test
	public void constructResponseSuccessfully() {
		jsonObject = new JSONObject();
		DeleteEntityResponseObject deleteEntityResponseObject = underTest
				.constructResponse(jsonObject);
		Assert.assertTrue(deleteEntityResponseObject.successfullyRemoved());
	}

	@Test
	public void constructResponseNotSuccessfully() {
		try {
			jsonObject = new JSONObject("{\"test\": \"1ff3a55f94e954ee\"}");
		} catch (JSONException e) {
			log.error(e.toString());
		}
		DeleteEntityResponseObject deleteEntityResponseObject = underTest
				.constructResponse(jsonObject);
		Assert.assertFalse(deleteEntityResponseObject.successfullyRemoved());
	}
}
