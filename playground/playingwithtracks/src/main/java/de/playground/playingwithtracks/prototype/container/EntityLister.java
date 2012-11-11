package de.playground.playingwithtracks.prototype.container;

import java.util.List;

public class EntityLister {

	private String minId = null;
	private List<String> entityIds = null;

	public EntityLister(String minId) {
		this.minId = minId;
	}

	public EntityLister(List<String> entityIds) {
		this.entityIds = entityIds;
	}

	public String getMinId() {
		return minId;
	}

	public List<String> getEntityIds() {
		return entityIds;
	}
}
