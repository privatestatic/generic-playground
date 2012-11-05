package de.playground.playingwithtracks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.playground.playingwithtracks.requests.JSONRequest;
import de.playground.playingwithtracks.responses.CreateEntityResponse;
import de.playground.playingwithtracks.responses.JSONResponse;

public class JSONFactory {

	private static final Logger log = LoggerFactory
			.getLogger(JSONFactory.class);

	private JSONRequest m_jsonRequest = null;

	public JSONFactory(JSONRequest jsonRequest) {
		m_jsonRequest = jsonRequest;
	}

	public JSONResponse sendJSONRequest() {
		URLConnectorJSON connector = new URLConnectorJSON();

		String responseString = connector.castRequest(m_jsonRequest);

		JSONResponse jsonResponse = new CreateEntityResponse();
		// jsonResponse.constructResponse(responseString);

		return jsonResponse;
	}
}
