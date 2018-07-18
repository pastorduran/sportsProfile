package repositories;

import javax.inject.Inject;

import akka.actor.ActorSystem;
import play.libs.concurrent.CustomExecutionContext;

public class ClientExecutionContext extends CustomExecutionContext {
	
	@Inject
	public ClientExecutionContext(ActorSystem actorSystem) {
		super(actorSystem, "client.repository");		
	}

}
