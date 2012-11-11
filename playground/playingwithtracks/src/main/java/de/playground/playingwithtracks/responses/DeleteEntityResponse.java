package de.playground.playingwithtracks.responses;

import org.json.JSONObject;
import de.playground.playingwithtracks.responses.types.DeleteEntityResponseObject;

public class DeleteEntityResponse implements
		JSONResponse<DeleteEntityResponseObject> {

	@Override
	public DeleteEntityResponseObject constructResponse(JSONObject jsonObject) {
		DeleteEntityResponseObject deleteEntityResponseObject = buildDeleteEntityResponse(jsonObject);
		return deleteEntityResponseObject;
	}

	private DeleteEntityResponseObject buildDeleteEntityResponse(
			JSONObject jsonObject) {
		if (jsonObject.length() == 0) {
			return new DeleteEntityResponseObject(true);
		} else {
			return new DeleteEntityResponseObject(false);
		}
	}

}
