package de.playground.playingwithtracks.responses;

import java.util.List;

import junit.framework.Assert;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.playground.playingwithtracks.prototype.container.TracksError;
import de.playground.playingwithtracks.responses.types.ErrorObject;

public class ErrorResponseTest {

	private static final Logger log = LoggerFactory
			.getLogger(ErrorResponseTest.class);

	private static final String ERROR_CODE = "400";
	private static final String ERROR_MESSAGE = "Parse Error";
	private static final String DOMAIN = "global";
	private static final String REASON = "parseError";
	private static final String MESSAGE = "Parse Error";
	private static final String ERROR_RESPONSE_STRING = "{\"error\": {\"errors\": [{\"domain\": \""
			+ DOMAIN
			+ "\",\"reason\": \""
			+ REASON
			+ "\",\"message\": \""
			+ MESSAGE
			+ "\",}],\"code\": "
			+ ERROR_CODE
			+ ",\"message\": \""
			+ ERROR_MESSAGE + "\"}}";

	private ErrorResponse underTest = new ErrorResponse();
	JSONObject jsonObject;

	@Test
	public void constructResponseSuccessfull() {
		try {
			jsonObject = new JSONObject(ERROR_RESPONSE_STRING);
		} catch (JSONException e) {
			log.error(e.toString());
		}
		ErrorObject errorResponseObject = underTest
				.constructResponse(jsonObject);
		int error_code = errorResponseObject.getCode();
		String error_message = errorResponseObject.getMessage();
		List<TracksError> errorList = errorResponseObject.getErrors();
		Assert.assertEquals(Integer.parseInt(ERROR_CODE), error_code);
		Assert.assertEquals(ERROR_MESSAGE, error_message);
		Assert.assertEquals(1, errorList.size());
		Assert.assertEquals(DOMAIN, errorList.get(0).getDomain());
		Assert.assertEquals(REASON, errorList.get(0).getReason());
		Assert.assertEquals(MESSAGE, errorList.get(0).getMessage());
	}
}
