package de.playground.playingwithtracks.responses;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.playground.playingwithtracks.prototype.container.TracksError;
import de.playground.playingwithtracks.responses.types.ErrorObject;

public class ErrorResponse implements JSONResponse<ErrorObject> {

	private static final Logger log = LoggerFactory
			.getLogger(ErrorResponse.class);

	@Override
	public ErrorObject constructResponse(JSONObject jsonObject) {
		ErrorObject errorMessage = buildErrorResponse(jsonObject);
		return errorMessage;
	}

	private ErrorObject buildErrorResponse(JSONObject jsonObject) {
		try {
			JSONObject errorObject = jsonObject.getJSONObject("error");

			int errorCode = errorObject.getInt("code");
			String errorMessage = errorObject.getString("message");

			List<TracksError> errorList = new ArrayList<TracksError>();

			JSONArray errorArray = errorObject.getJSONArray("errors");

			for (int i = 0; i < errorArray.length(); i++) {
				JSONObject error = errorArray.getJSONObject(i);
				String domain = error.getString("domain");
				String reason = error.getString("reason");
				String message = error.getString("message");
				errorList.add(new TracksError(domain, reason, message));
			}

			return new ErrorObject(errorList, errorCode, errorMessage);
		} catch (JSONException e) {
			log.error(e.toString());
			return null;
		}
	}
}
