package de.playground.playingwithtracks;

public class JSONFactory {

	private JSONRequest m_jsonRequest = null;

	private boolean m_isPost = true;

	private static final String GOOGLE_TRACKS_URL = "https://www.googleapis.com/tracks/v1/";

	public JSONFactory(JSONRequest jsonRequest, boolean isPost) {
		m_jsonRequest = jsonRequest;
		m_isPost = isPost;
	}

	public JSONResponse sendJSONRequest() {

		String request = toJSON();

		URLConnectorJSON connector = new URLConnectorJSON(m_isPost);

		String response = connector.send(request);

		return null;
	}

	private String toJSON() {

		return m_jsonRequest.constructRequest();
	}

	private String getUrl() {
		return GOOGLE_TRACKS_URL + m_jsonRequest.getPathToMethod();
	}
}
