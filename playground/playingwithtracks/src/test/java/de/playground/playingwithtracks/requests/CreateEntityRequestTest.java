package de.playground.playingwithtracks.requests;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import de.playground.playingwithtracks.URLConnectorJSON.Method;
import de.playground.playingwithtracks.prototype.container.Entity;

public class CreateEntityRequestTest {

	private static final String NAME_0 = "Ford Fiesta 001";
	private static final String TYPE_0 = "AUTOMOBILE";
	private static final String NAME_1 = "Chevrolet Volt 001";
	private static final String TYPE_1 = "AUTOMOBILE";
	private static final String NAME_2 = "Chevrolet Volt 002";
	private static final List<Entity> ENTITY_LIST;
	static {
		ENTITY_LIST = new ArrayList<Entity>();
		ENTITY_LIST.add(new Entity(NAME_0, TYPE_0));
		ENTITY_LIST.add(new Entity(NAME_1, TYPE_1));
		ENTITY_LIST.add(new Entity(NAME_2));
	}

	private static final String EXPECTED_REQUEST_URL = "https://www.googleapis.com/tracks/v1/entities/create";
	private static final String EXPECTED_RESULT_STRING = "{\"entities\":[{\"name\":\""
			+ NAME_0
			+ "\",\"type\":\""
			+ TYPE_0
			+ "\"},{\"name\":\""
			+ NAME_1
			+ "\",\"type\":\"" + TYPE_1 + "\"},{\"name\":\"" + NAME_2 + "\"}]}";
	private static final Method EXPECTED_METHOD = Method.POST;

	private CreateEntityRequest underTest;

	@Before
	public void setUp() {
		underTest = new CreateEntityRequest(ENTITY_LIST);
	}

	@Test
	public void constructRequestBody() {
		String result = underTest.getRequestBody();
		Assert.assertEquals(EXPECTED_RESULT_STRING, result);
	}

	@Test
	public void getRequestURL() {
		URL requestUrl = underTest.getRequestURL();
		Assert.assertEquals(EXPECTED_REQUEST_URL, requestUrl.toString());
	}

	@Test
	public void getHttpMethod() {
		Method method = underTest.getHttpMethod();
		Assert.assertEquals(EXPECTED_METHOD, method);
	}
}
