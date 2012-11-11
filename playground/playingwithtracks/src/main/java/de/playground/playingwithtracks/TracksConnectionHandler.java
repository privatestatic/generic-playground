package de.playground.playingwithtracks;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.playground.playingwithtracks.requests.JSONRequest;
import de.playground.playingwithtracks.responses.ErrorResponse;
import de.playground.playingwithtracks.responses.JSONResponse;
import de.playground.playingwithtracks.responses.types.ErrorResponseObject;

public class TracksConnectionHandler {

	private static final Logger log = LoggerFactory
			.getLogger(TracksConnectionHandler.class);

	public Object sendJSONRequest(JSONRequest jsonRequest) {
		URLConnectorJSON connector = new URLConnectorJSON();
		String responseString = connector.castRequest(jsonRequest);

		JSONObject jsonObject = parseJSON(responseString);
		if (jsonObject != null) {
			if (jsonObject.has("error")) {
				JSONResponse<ErrorResponseObject> jsonResponse = new ErrorResponse();
				return jsonResponse.constructResponse(jsonObject);
			} else {
				JSONResponse<?> jsonResponse = jsonRequest
						.getInstanceOfResponse();
				return jsonResponse.constructResponse(jsonObject);
			}
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
