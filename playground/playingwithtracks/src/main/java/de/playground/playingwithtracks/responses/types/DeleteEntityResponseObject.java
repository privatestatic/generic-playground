package de.playground.playingwithtracks.responses.types;

public class DeleteEntityResponseObject extends ResponseObject {
	private boolean successfull = false;

	public DeleteEntityResponseObject() {
	}

	public DeleteEntityResponseObject(boolean successfull) {
		this.successfull = successfull;
	}

	public boolean successfullyRemoved() {
		return successfull;
	}

	@Override
	public String toString() {
		if (successfull) {
			return "\nThe delete entity request was successfull! Entities should be removed!";
		} else {
			return "\nThe delete entity request was NOT successfull!";
		}
	}
}
