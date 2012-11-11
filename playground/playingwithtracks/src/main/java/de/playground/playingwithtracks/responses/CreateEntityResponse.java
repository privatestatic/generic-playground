package de.playground.playingwithtracks.responses;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.playground.playingwithtracks.responses.types.CreateEntityResponseObject;

public class CreateEntityResponse implements
		JSONResponse<CreateEntityResponseObject> {

	private static final Logger log = LoggerFactory
			.getLogger(CreateEntityResponse.class);

	@Override
	public CreateEntityResponseObject constructResponse(JSONObject jsonObject) {
		CreateEntityResponseObject createEntityResponseObject = buildCreateEntityResponse(jsonObject);
		return createEntityResponseObject;
	}

	private CreateEntityResponseObject buildCreateEntityResponse(
			JSONObject jsonObject) {
		try {
			JSONArray entityIdsArray = jsonObject.getJSONArray("entityIds");
			List<String> entityIdList = new ArrayList<String>();
			for (int i = 0; i < entityIdsArray.length(); i++) {
				entityIdList.add(entityIdsArray.getString(i));
			}
			return new CreateEntityResponseObject(entityIdList);
		} catch (JSONException e) {
			log.error(e.toString());
			return null;
		}
	}

}
