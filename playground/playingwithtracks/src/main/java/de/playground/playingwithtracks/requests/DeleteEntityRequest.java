package de.playground.playingwithtracks.requests;

import de.playground.playingwithtracks.URLConnectorJSON.Method;
import de.playground.playingwithtracks.responses.DeleteEntityResponse;
import de.playground.playingwithtracks.responses.EntityResponse;
import de.playground.playingwithtracks.responses.types.DeleteEntityResponseObject;

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

	@Override
	public EntityResponse<DeleteEntityResponseObject> getInstanceOfResponse() {
		return new DeleteEntityResponse();
	}

}
