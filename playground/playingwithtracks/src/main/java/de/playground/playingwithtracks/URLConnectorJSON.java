package de.playground.playingwithtracks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.playground.playingwithtracks.requests.JSONRequest;

public class URLConnectorJSON {

	private static final Logger log = LoggerFactory
			.getLogger(URLConnectorJSON.class);

	public static enum Method {
		GET, POST
	}

	public String castRequest(JSONRequest request) {
		String responseString = "";
		try {

			// TODO Do the oauth2 authentication with the google server

			HttpURLConnection connection = sendRequest(request);
			BufferedReader inputReader = createReader(connection);
			responseString = readDocument(inputReader);
		} catch (IOException e) {
			log.error(e.toString());
		}

		return responseString;
	}

	private HttpURLConnection sendRequest(JSONRequest request)
			throws IOException {

		if (log.isDebugEnabled()) {
			log.debug("Sending request body: " + request.getRequestBody());
		}

		HttpURLConnection connection = createConnection(request);

		switch (request.getHttpMethod()) {
		case GET:
			// TODO Handle GET request
			break;
		case POST:
			prepareHttpPostHeader(connection, request);
			sendBody(request.getRequestBody(), connection);
			break;
		default:
			break;
		}

		return connection;
	}

	private BufferedReader createReader(HttpURLConnection connection)
			throws IOException {
		BufferedReader inputReader = null;

		InputStream inputStream = connection.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

		inputReader = new BufferedReader(inputStreamReader);

		return inputReader;
	}

	private HttpURLConnection createConnection(JSONRequest request)
			throws IOException {
		HttpURLConnection connection = (HttpURLConnection) request
				.getRequestURL().openConnection();
		configureConnection(connection, request.getHttpMethod());

		return connection;
	}

	private void configureConnection(HttpURLConnection connection, Method method)
			throws ProtocolException {
		connection.setRequestMethod(method.toString());
		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setUseCaches(false);
	}

	private void prepareHttpPostHeader(HttpURLConnection connection,
			JSONRequest request) {
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setRequestProperty("charset", "utf-8");
		connection.setRequestProperty("Content-Length",
				String.valueOf(request.getRequestBody()));
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
