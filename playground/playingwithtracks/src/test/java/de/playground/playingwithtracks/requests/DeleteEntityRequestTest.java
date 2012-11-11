package de.playground.playingwithtracks.requests;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.playground.playingwithtracks.URLConnectorJSON.Method;

public class DeleteEntityRequestTest {

	private static final String ID_0 = "df512d2fcaa60840";
	private static final String ID_1 = "651d0085265a3a9f";
	private static final List<String> ID_LIST;
	static {
		ID_LIST = new ArrayList<String>();
		ID_LIST.add(ID_0);
		ID_LIST.add(ID_1);
	}

	private static final String EXPECTED_REQUEST_URL = "https://www.googleapis.com/tracks/v1/entities/delete";
	private static final String EXPECTED_RESULT_STRING = "{\"entityIds\":[\""
			+ ID_0 + "\",\"" + ID_1 + "\"]}";
	private static final Method EXPECTED_METHOD = Method.POST;

	private DeleteEntityRequest underTest;

	@Before
	public void setUp() {
		underTest = new DeleteEntityRequest(ID_LIST);
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
