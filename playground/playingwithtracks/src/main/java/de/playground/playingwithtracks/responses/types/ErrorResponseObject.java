package de.playground.playingwithtracks.responses.types;

import java.util.List;

import de.playground.playingwithtracks.prototype.container.TracksError;

public class ErrorResponseObject {
	private List<TracksError> errors;
	private int code;
	private String message;

	public ErrorResponseObject(List<TracksError> errors, int code, String message) {
		this.errors = errors;
		this.code = code;
		this.message = message;
	}

	public List<TracksError> getErrors() {
		return errors;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nCODE == ");
		sb.append(code);
		sb.append("\nMESSAGE == ");
		sb.append(message);

		sb.append("\nCONTAINED ERRORS == ");
		for (TracksError error : errors) {
			sb.append(error.toString());
		}
		return sb.toString();
	}

}
