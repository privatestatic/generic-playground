package de.playground.playingwithtracks.requests;

import de.playground.playingwithtracks.URLConnectorJSON.Method;
import de.playground.playingwithtracks.responses.EntityResponse;
import de.playground.playingwithtracks.responses.ListEntityResponse;
import de.playground.playingwithtracks.responses.types.ListEntityResponseObject;

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

	@Override
	public EntityResponse<ListEntityResponseObject> getInstanceOfResponse() {
		return new ListEntityResponse();
	}

}
