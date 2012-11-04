package de.playground.playingwithtracks;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.playground.playingwithtracks.URLConnectorJSON.Method;
import de.playground.playingwithtracks.prototype.container.Entity;

public class CreateEntityRequest extends GoogleTracksJSONRequest {

	private static final Logger log = LoggerFactory
			.getLogger(CreateEntityRequest.class);

	private final static String URL_METHOD = "entities/create";

	protected List<Entity> m_entityList;

	public CreateEntityRequest(List<Entity> entityList) {
		m_entityList = entityList;
	}

	private String constructRequestBody(List<Entity> entityList) {

		JSONObject entities = new JSONObject();
		List<JSONObject> listEntities = new ArrayList<JSONObject>();

		try {
			for (Entity entity : entityList) {
				listEntities.add(createJSONObject(entity));
			}
			entities.put("entities", listEntities);
		} catch (JSONException e) {
			log.error(e.toString());
			return "";
		}

		return entities.toString();
	}

	private JSONObject createJSONObject(Entity entity) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", entity.getName());
		jsonObject.put("type", entity.getType());
		return jsonObject;
	}

	@Override
	public String getRequestTarget() {
		return URL_METHOD;
	}

	@Override
	public String getRequestBody() {
		return constructRequestBody(m_entityList);
	}

	@Override
	public Method getHttpMethod() {
		return Method.POST;
	}

}
