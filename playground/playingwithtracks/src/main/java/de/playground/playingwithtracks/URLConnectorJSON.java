package de.playground.playingwithtracks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class URLConnectorJSON {

	private boolean m_isPost = true;

	public URLConnectorJSON(boolean isPost) {
		m_isPost = isPost;
	}

	public String send(String request) {

		BufferedReader in = null;

		try {

			// TODO: isPost unterscheiden
			URL url = new URL(request);

			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();

			connection.setRequestMethod("POST");
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setUseCaches(false);

			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));

		} catch (Exception e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "");
		}

		String inputLine;

		StringBuilder sb = new StringBuilder();

		try {
			while ((inputLine = in.readLine()) != null) {
				sb.append(inputLine);
			}
		} catch (IOException e) {

		} finally {
			try {
				in.close();
			} catch (IOException e) {
				// weiter
			}
		}

		return sb.toString();
	}
}
