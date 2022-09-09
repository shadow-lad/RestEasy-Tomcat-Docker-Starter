package org.example.tomcattest.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.json.JSONObject;

@Path("/api")
public class ApiController {

	@GET
	@Path("/")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getMessage() {

		JSONObject object = new JSONObject();

		object.put("message", "hello world!");

		return Response.ok(object.toString()).build();

	}
	@GET
	@Path("/{name}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getMessage(@PathParam("name") String name) {

		JSONObject object = new JSONObject();

		object.put("message", "hello " + name + "!");

		return Response.ok(object.toString()).build();

	}

}
