package de.playground.playingwithtracks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;
import java.security.cert.Certificate;

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

			URLConnection connection = sendRequest(request);
			BufferedReader inputReader = createReader(connection);
			responseString = readDocument(inputReader);
		} catch (IOException e) {
			log.error(e.toString());
		}

		return responseString;
	}

	private URLConnection sendRequest(JSONRequest request) throws IOException {

		log.debug("Sending request body: {}", request.getRequestBody());

		HttpURLConnection connection = createHttpsConnection(request);

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

	private BufferedReader createReader(URLConnection connection)
			throws IOException {
		BufferedReader inputReader = null;

		InputStream inputStream = connection.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

		inputReader = new BufferedReader(inputStreamReader);

		return inputReader;
	}

	private HttpsURLConnection createHttpsConnection(JSONRequest request)
			throws IOException {
		HttpsURLConnection connection = (HttpsURLConnection) request
				.getRequestURL().openConnection();
		configureConnection(connection, request.getHttpMethod());

		// log.debug("Https certificate information are: {}",
		// getHttpsCertificateInformation(connection));

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

	private void sendBody(String body, URLConnection connection)
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

	private String getHttpsCertificateInformation(HttpsURLConnection con) {
		if (con != null) {
			StringBuilder sb = new StringBuilder();
			try {
				sb.append("\nResponse Code : ");
				sb.append(con.getResponseCode());
				sb.append("\nCipher Suite : ");
				sb.append(con.getCipherSuite());
				sb.append("\n");

				Certificate[] certs = con.getServerCertificates();
				for (Certificate cert : certs) {
					sb.append("\nCert Type : ");
					sb.append(cert.getType());
					sb.append("\nCert Hash Code : ");
					sb.append(cert.hashCode());
					sb.append("\nCert Public Key Algorithm : ");
					sb.append(cert.getPublicKey().getAlgorithm());
					sb.append("\nCert Public Key Format : ");
					sb.append(cert.getPublicKey().getFormat());
					sb.append("\n");
				}

			} catch (IOException e) {
				return "Error while retrieving certificate information: "
						+ e.getMessage();
			}

			return sb.toString();

		}
		return "Given connection was null!";
	}
}
