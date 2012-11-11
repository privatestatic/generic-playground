package de.playground.playingwithtracks.responses;

import org.json.JSONObject;

import de.playground.playingwithtracks.responses.types.ErrorObject;
import de.playground.playingwithtracks.responses.types.ResponseObject;

public abstract class EntityResponse<T extends ResponseObject> implements
		JSONResponse<T> {

	private ErrorObject errorObject = null;

	@Override
	public T constructResponse(JSONObject jsonObject) {
		T responseObject;
		if (hasError()) {
			responseObject = buildResponse();
			responseObject.setErrorObject(getErrorObject());
		} else {
			responseObject = buildResponse(jsonObject);
		}
		return responseObject;
	}

	public abstract T buildResponse(JSONObject jsonObject);

	public abstract T buildResponse();

	public void addErrorObject(ErrorObject errorObject) {
		this.errorObject = errorObject;
	}

	public boolean hasError() {
		if (errorObject != null) {
			return true;
		} else {
			return false;
		}
	}

	public ErrorObject getErrorObject() {
		return errorObject;
	}

}
