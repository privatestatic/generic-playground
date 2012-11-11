package de.playground.playingwithtracks.prototype.container;

public class Entity {
	private String name;
	private String type;

	public Entity(String name) {
		this.name = name;
		this.type = null;
	}

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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nNAME == ");
		sb.append(name);
		sb.append("\nTYPE == ");
		sb.append(type);
		return sb.toString();
	}
}
