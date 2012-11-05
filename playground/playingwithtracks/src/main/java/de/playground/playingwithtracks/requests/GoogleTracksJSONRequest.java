package de.playground.playingwithtracks.requests;

import java.net.MalformedURLException;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class GoogleTracksJSONRequest implements JSONRequest {

	private static final Logger log = LoggerFactory
			.getLogger(GoogleTracksJSONRequest.class);

	private static final String GOOGLE_TRACKS_URL = "https://www.googleapis.com/tracks/v1/";

	@Override
	public URL getRequestURL() {
		URL url = null;
		try {
			url = new URL(GOOGLE_TRACKS_URL + getRequestTarget());
		} catch (MalformedURLException e) {
			log.error(e.toString());
		}
		return url;
	}

}
