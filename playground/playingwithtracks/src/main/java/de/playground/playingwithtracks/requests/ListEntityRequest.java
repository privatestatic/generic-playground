package de.playground.playingwithtracks.requests;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.playground.playingwithtracks.URLConnectorJSON.Method;
import de.playground.playingwithtracks.prototype.container.EntityLister;
import de.playground.playingwithtracks.responses.EntityResponse;
import de.playground.playingwithtracks.responses.ListEntityResponse;
import de.playground.playingwithtracks.responses.types.ListEntityResponseObject;

public class ListEntityRequest extends GoogleTracksJSONRequest {

	private static final Logger log = LoggerFactory
			.getLogger(ListEntityRequest.class);

	private final static String URL_METHOD = "entities/list";

	private EntityLister entityLister;

	public ListEntityRequest(EntityLister entityLister) {
		this.entityLister = entityLister;
	}

	private String constructRequestBody(EntityLister entityLister) {

		JSONObject jsonObject = new JSONObject();

		String minId = entityLister.getMinId();
		if (minId != null) {
			try {
				jsonObject.put("minId", minId);
			} catch (JSONException e) {
				log.error(e.toString());
				return "";
			}
		}

		List<String> entityIds = entityLister.getEntityIds();
		if (entityIds != null) {
			JSONArray jsonArray = new JSONArray();
			for (String id : entityIds) {
				jsonArray.put(id);
			}
			try {
				jsonObject.put("entityIds", jsonArray);
			} catch (JSONException e) {
				log.error(e.toString());
				return "";
			}
		}
		return jsonObject.toString();
	}

	@Override
	public String getRequestTarget() {
		return URL_METHOD;
	}

	@Override
	public String getRequestBody() {
		return constructRequestBody(entityLister);
	}

	@Override
	public Method getHttpMethod() {
		return Method.GET;
	}

	@Override
	public EntityResponse<ListEntityResponseObject> getInstanceOfResponse() {
		return new ListEntityResponse();
	}

}
