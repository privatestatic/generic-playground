package de.playground.playingwithtracks;

import de.playground.playingwithtracks.URLConnectorJSON.Method;

public class ListEntityRequest extends GoogleTracksJSONRequest {

	private final static String URL_METHOD = "entities/list";

	@Override
	public String getRequestTarget() {
		return URL_METHOD;
	}

	@Override
	public String getRequestBody() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Method getHttpMethod() {
		return Method.GET;
	}

}
