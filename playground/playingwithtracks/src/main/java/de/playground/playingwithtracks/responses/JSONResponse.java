package de.playground.playingwithtracks.responses;

import org.json.JSONObject;

public interface JSONResponse {

	public Object constructResponse(JSONObject jsonObject);
}
