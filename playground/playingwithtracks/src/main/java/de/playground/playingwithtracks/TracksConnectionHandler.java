package de.playground.playingwithtracks;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.playground.playingwithtracks.requests.JSONRequest;
import de.playground.playingwithtracks.responses.EntityResponse;
import de.playground.playingwithtracks.responses.ErrorResponse;
import de.playground.playingwithtracks.responses.JSONResponse;
import de.playground.playingwithtracks.responses.types.ErrorObject;
import de.playground.playingwithtracks.responses.types.ResponseObject;

public class TracksConnectionHandler {

	private static final Logger log = LoggerFactory
			.getLogger(TracksConnectionHandler.class);

	public ResponseObject sendJSONRequest(JSONRequest jsonRequest) {
		ResponseObject responseObject;
		URLConnectorJSON connector = new URLConnectorJSON();
		String responseString = connector.castRequest(jsonRequest);

		JSONObject jsonObject = parseJSON(responseString);
		if (jsonObject != null) {
			EntityResponse<?> jsonResponse = jsonRequest
					.getInstanceOfResponse();

			if (jsonObject.has("error")) {
				JSONResponse<ErrorObject> jsonErrorResponse = new ErrorResponse();
				ErrorObject errorObject = jsonErrorResponse
						.constructResponse(jsonObject);
				jsonResponse.addErrorObject(errorObject);
			}
			responseObject = jsonResponse.constructResponse(jsonObject);
			return responseObject;
		}
		return null;
	}

	private JSONObject parseJSON(String responseString) {
		if (responseString == null) {
			log.error("Received response is null!");
			return null;
		}
		if (responseString.equals("")) {
			log.error("Received an empty response string!");
			return null;
		}
		try {
			JSONObject jsonObject = new JSONObject(responseString);
			return jsonObject;
		} catch (JSONException e) {
			log.error(e.toString());
			return null;
		}

	}

}
