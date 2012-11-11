package de.playground.playingwithtracks.responses;

import org.json.JSONObject;
import de.playground.playingwithtracks.responses.types.DeleteEntityResponseObject;

public class DeleteEntityResponse extends
		EntityResponse<DeleteEntityResponseObject> {

	@Override
	public DeleteEntityResponseObject buildResponse(JSONObject jsonObject) {
		if (jsonObject.length() == 0) {
			return new DeleteEntityResponseObject(true);
		} else {
			return new DeleteEntityResponseObject(false);
		}
	}

	@Override
	public DeleteEntityResponseObject buildResponse() {
		return new DeleteEntityResponseObject();
	}

}
