package de.playground.playingwithtracks;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.playground.playingwithtracks.prototype.container.Entity;
import de.playground.playingwithtracks.requests.CreateEntityRequest;
import de.playground.playingwithtracks.requests.JSONRequest;
import de.playground.playingwithtracks.responses.types.ResponseObject;

public class TracksExample {
	private static final Logger log = LoggerFactory
			.getLogger(TracksExample.class);

	public static void main(String[] args) {
		Entity peugeot406 = new Entity("Peugeot 406", "AUTOMOBILE");
		Entity boeing777 = new Entity("Boeing 777", "AIRPLANE");

		List<Entity> entityList = new ArrayList<Entity>();
		entityList.add(peugeot406);
		entityList.add(boeing777);

		JSONRequest request = new CreateEntityRequest(entityList);

		TracksConnectionHandler connectionHandler = new TracksConnectionHandler();
		ResponseObject responseObject = connectionHandler
				.sendJSONRequest(request);

		if (responseObject != null) {
			log.debug("RESPONSE: {}", responseObject.toString());
		}
	}
}
