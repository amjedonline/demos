package de.zalando.zims.services;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.zalando.zims.domain.CustomerIdentity;

@Path("/identity")
public class IdentityService {

	final static Map<String, CustomerIdentity> identities;

	static {
		identities = new HashMap<String, CustomerIdentity>();
		final CustomerIdentity identity = new CustomerIdentity();
		identity.setCustomerId("12345");
		identity.setIdentityType(CustomerIdentity.IDENTITY_TYPE.SOFT_LOGIN);
		identity.setName("mustermann");
		identities.put("12345", identity);
	}

	@GET
	@Path("/bySessionId/{sessionId}")
	@Produces(MediaType.APPLICATION_JSON)
	public CustomerIdentity bySessionId(
			@PathParam("sessionId") final String sessionId) {
		return identities.get(sessionId);
	}

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateIdentity(CustomerIdentity identity) {

		identities.put(identity.getSessionId(), identity);
		return Response.status(200).entity("success").build();
	}
	
}
