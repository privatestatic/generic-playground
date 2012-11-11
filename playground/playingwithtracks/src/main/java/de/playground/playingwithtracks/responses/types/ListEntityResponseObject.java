package de.playground.playingwithtracks.responses.types;

import java.util.Map;
import java.util.Map.Entry;

import de.playground.playingwithtracks.prototype.container.Entity;

public class ListEntityResponseObject {
	private Map<String, Entity> entityMap;

	public ListEntityResponseObject(Map<String, Entity> entityMap) {
		this.entityMap = entityMap;
	}

	public Map<String, Entity> getEntityMap() {
		return entityMap;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Entry<String, Entity> entry : entityMap.entrySet()) {
			sb.append("\nID == ");
			sb.append(entry.getKey());
			sb.append("\nENTITY:");
			sb.append(entry.getValue().toString());
			sb.append("\n");
		}
		return sb.toString();
	}

}
