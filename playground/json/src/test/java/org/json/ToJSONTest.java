package org.json;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ToJSONTest {

	private static final Logger log = LoggerFactory.getLogger(ToJSONTest.class);
	private final static String EXPECTED_RESULT = "{\"entities\":[{\"name\":\"Ford Fiesta 001\",\"type\":\"AUTOMOBILE\"},{\"name\":\"Chevrolet Volt 001\",\"type\":\"AUTOMOBILE\"}]}";

	@Test
	public void jsonTest() throws JSONException {

		JSONObject entities = new JSONObject();
		List<JSONObject> listEntities = new ArrayList<JSONObject>();

		JSONObject ford = new JSONObject();
		ford.put("name", "Ford Fiesta 001");
		ford.put("type", "AUTOMOBILE");

		JSONObject chevrolet = new JSONObject();
		chevrolet.put("name", "Chevrolet Volt 001");
		chevrolet.put("type", "AUTOMOBILE");

		listEntities.add(ford);
		listEntities.add(chevrolet);

		entities.put("entities", listEntities);

		log.info(entities.toString());

		Assert.assertEquals(EXPECTED_RESULT, entities.toString());
	}
}
