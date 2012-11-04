package de.playground.playingwithtracks;

public class CreateEntityRequest implements JSONRequest {

	private final static String URL_METHOD = "entities/create";

	@Override
	public String constructRequest() {
		return null;
	}

	@Override
	public String getPathToMethod() {
		return URL_METHOD;
	}

}
