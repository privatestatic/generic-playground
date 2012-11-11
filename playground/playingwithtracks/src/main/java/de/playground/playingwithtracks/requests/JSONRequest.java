package de.playground.playingwithtracks.requests;

import java.net.URL;
import de.playground.playingwithtracks.URLConnectorJSON.Method;
import de.playground.playingwithtracks.responses.JSONResponse;

public interface JSONRequest {

	JSONResponse<?> getInstanceOfResponse();

	String getRequestTarget();

	URL getRequestURL();

	String getRequestBody();

	Method getHttpMethod();
}
