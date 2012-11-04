package de.playground.playingwithtracks;

import org.json.JSONObject;
import de.playground.playingwithtracks.prototype.container.Entity;

public class CreateEntityResponse implements JSONResponse {

	@Override
	public Object constructResponse(JSONObject jsonObject) {
		return new Entity();
	}

}
