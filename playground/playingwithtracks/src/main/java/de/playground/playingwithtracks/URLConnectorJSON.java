package de.playground.playingwithtracks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class URLConnectorJSON {

	private static final Logger log = LoggerFactory
			.getLogger(URLConnectorJSON.class);

	public static enum Method {
		GET, POST
	}

	private Method m_method = Method.POST;

	public URLConnectorJSON(Method method) {
		m_method = method;
	}

	public String castRequest(JSONRequest request) {
		String responseString = "";
		try {
			BufferedReader inputReader = createReader(request.getRequestURL(),
					request.getRequestBody());
			responseString = readDocument(inputReader);
		} catch (IOException e) {
			log.error(e.toString());
		}

		return responseString;
	}

	private BufferedReader createReader(URL requestURL, String body)
			throws IOException {
		BufferedReader inputReader = null;

		if (log.isDebugEnabled()) {
			log.debug("Sending request body: " + body);
		}

		HttpURLConnection connection = connectToURL(requestURL, body);
		sendBody(body, connection);

		InputStream inputStream = connection.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

		inputReader = new BufferedReader(inputStreamReader);

		return inputReader;
	}

	private HttpURLConnection connectToURL(URL url, String body)
			throws IOException {
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod(m_method.toString());
		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setUseCaches(false);
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setRequestProperty("charset", "utf-8");
		connection.setRequestProperty("Content-Length", String.valueOf(body));

		return connection;
	}

	private void sendBody(String body, HttpURLConnection connection)
			throws IOException {
		OutputStreamWriter writer = null;
		try {
			writer = new OutputStreamWriter(connection.getOutputStream());
			writer.write(body);
			writer.flush();
		} finally {
			writer.close();
		}
	}

	private String readDocument(BufferedReader inputReader) throws IOException {
		if (inputReader != null) {
			String inputLine;

			StringBuilder sb = new StringBuilder();

			try {
				while ((inputLine = inputReader.readLine()) != null) {
					sb.append(inputLine);
				}
			} finally {
				inputReader.close();
			}

			return sb.toString();
		} else {
			return "";
		}
	}
}
