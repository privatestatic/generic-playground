package de.playground.playingwithtracks.requests;

import java.net.URL;
import de.playground.playingwithtracks.URLConnectorJSON.Method;

public interface JSONRequest {

	String getRequestTarget();

	URL getRequestURL();

	String getRequestBody();

	Method getHttpMethod();
}
