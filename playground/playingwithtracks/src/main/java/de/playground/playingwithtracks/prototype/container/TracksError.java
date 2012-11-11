package de.playground.playingwithtracks.prototype.container;

public class TracksError {
	private String domain;
	private String reason;
	private String message;

	public TracksError(String domain, String reason, String message) {
		this.domain = domain;
		this.reason = reason;
		this.message = message;
	}

	public String getDomain() {
		return domain;
	}

	public String getReason() {
		return reason;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nDOMAIN == ");
		sb.append(domain);
		sb.append("\nREASON == ");
		sb.append(reason);
		sb.append("\nMESSAGE == ");
		sb.append(message);
		return sb.toString();
	}
}
