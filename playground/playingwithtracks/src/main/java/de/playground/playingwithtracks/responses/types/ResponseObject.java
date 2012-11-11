package de.playground.playingwithtracks.responses.types;

public abstract class ResponseObject {

	private ErrorObject errorResponseObject = null;

	public ErrorObject getErrorObject() {
		return errorResponseObject;
	}

	public void setErrorObject(ErrorObject errorResponseObject) {
		this.errorResponseObject = errorResponseObject;
	}
}
