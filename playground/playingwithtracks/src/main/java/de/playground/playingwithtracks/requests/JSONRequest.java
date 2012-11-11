package de.playground.playingwithtracks.requests;

import java.net.URL;
import de.playground.playingwithtracks.URLConnectorJSON.Method;
import de.playground.playingwithtracks.responses.EntityResponse;
import de.playground.playingwithtracks.responses.types.ResponseObject;

public interface JSONRequest {

	EntityResponse<? extends ResponseObject> getInstanceOfResponse();

	String getRequestTarget();

	URL getRequestURL();

	String getRequestBody();

	Method getHttpMethod();
}
