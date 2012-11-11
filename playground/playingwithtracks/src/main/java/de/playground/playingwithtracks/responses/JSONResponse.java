package de.playground.playingwithtracks.responses;

import org.json.JSONObject;

public interface JSONResponse<T> {

	public T constructResponse(JSONObject jsonObject);

}
