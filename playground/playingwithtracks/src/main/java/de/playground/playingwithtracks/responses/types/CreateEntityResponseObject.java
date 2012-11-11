package de.playground.playingwithtracks.responses.types;

import java.util.List;

public class CreateEntityResponseObject {

	private List<String> entityIds;

	public CreateEntityResponseObject(List<String> entityIds) {
		this.entityIds = entityIds;
	}

	public List<String> getEntityIds() {
		return entityIds;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String id : entityIds) {
			sb.append("\nID == ");
			sb.append(id);
		}
		return sb.toString();
	}

}
