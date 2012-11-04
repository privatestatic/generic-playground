package de.playground.playingwithtracks;

import java.net.URL;
import java.util.List;

import de.playground.playingwithtracks.URLConnectorJSON.Method;
import de.playground.playingwithtracks.prototype.container.Entity;

public interface JSONRequest {

	String getRequestTarget();

	URL getRequestURL();

	String getRequestBody();

	Method getHttpMethod();
}
