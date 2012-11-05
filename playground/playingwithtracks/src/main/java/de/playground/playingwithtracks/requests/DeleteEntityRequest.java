package de.playground.playingwithtracks.requests;

import de.playground.playingwithtracks.URLConnectorJSON.Method;

public class DeleteEntityRequest extends GoogleTracksJSONRequest {

	private final static String URL_METHOD = "entities/delete";

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
		return Method.POST;
	}

}
