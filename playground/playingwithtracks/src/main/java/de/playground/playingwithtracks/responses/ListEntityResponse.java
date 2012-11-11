package de.playground.playingwithtracks.responses;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.playground.playingwithtracks.prototype.container.Entity;
import de.playground.playingwithtracks.responses.types.ListEntityResponseObject;

public class ListEntityResponse implements
		JSONResponse<ListEntityResponseObject> {

	private static final Logger log = LoggerFactory
			.getLogger(ListEntityResponse.class);

	@Override
	public ListEntityResponseObject constructResponse(JSONObject jsonObject) {
		ListEntityResponseObject listEntityResponseObject = buildListEntityResponse(jsonObject);
		return listEntityResponseObject;
	}

	private ListEntityResponseObject buildListEntityResponse(
			JSONObject jsonObject) {
		try {
			JSONArray entitiesArray = jsonObject.getJSONArray("entities");
			Map<String, Entity> entitiesMap = new HashMap<String, Entity>();

			for (int i = 0; i < entitiesArray.length(); i++) {
				JSONObject entityObject = entitiesArray.getJSONObject(i);
				String id = entityObject.getString("id");
				String name = entityObject.getString("name");
				String type = entityObject.getString("type");
				Entity entity = new Entity(name, type);
				entitiesMap.put(id, entity);
			}

			return new ListEntityResponseObject(entitiesMap);
		} catch (JSONException e) {
			log.error(e.toString());
			return null;
		}
	}
}
