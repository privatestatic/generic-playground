package de.playground.playingwithtracks.requests;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.playground.playingwithtracks.URLConnectorJSON.Method;
import de.playground.playingwithtracks.responses.DeleteEntityResponse;
import de.playground.playingwithtracks.responses.EntityResponse;
import de.playground.playingwithtracks.responses.types.DeleteEntityResponseObject;

public class DeleteEntityRequest extends GoogleTracksJSONRequest {

	private static final Logger log = LoggerFactory
			.getLogger(DeleteEntityRequest.class);

	private final static String URL_METHOD = "entities/delete";

	protected List<String> m_idList;

	public DeleteEntityRequest(List<String> idList) {
		m_idList = idList;
	}

	private String constructRequestBody(List<String> idList) {

		JSONArray jsonArray;
		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject();
			jsonArray = new JSONArray();
			for (String id : idList) {
				jsonArray.put(id);
			}
			jsonObject.put("entityIds", jsonArray);
		} catch (JSONException e) {
			log.error(e.toString());
			return "";
		}
		return jsonObject.toString();
	}

	@Override
	public String getRequestTarget() {
		return URL_METHOD;
	}

	@Override
	public String getRequestBody() {
		return constructRequestBody(m_idList);
	}

	@Override
	public Method getHttpMethod() {
		return Method.POST;
	}

	@Override
	public EntityResponse<DeleteEntityResponseObject> getInstanceOfResponse() {
		return new DeleteEntityResponse();
	}

}
