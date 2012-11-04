package de.playground.playingwithtracks.prototype.container;

public class Entity {
	private String name;
	private String type;

	public Entity(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}
}
