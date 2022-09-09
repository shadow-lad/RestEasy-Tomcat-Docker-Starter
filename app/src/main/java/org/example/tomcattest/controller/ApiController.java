package org.example.tomcattest.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.NonNull;
import lombok.val;
import org.example.tomcattest.model.Message;
import org.example.tomcattest.util.JsonUtil;

@Path("/api")
public class ApiController {

    private final JsonUtil jsonUtil;

    @Inject
    public ApiController(@NonNull JsonUtil jsonUtil) {
        this.jsonUtil = jsonUtil;
    }

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMessage() {
        val message = Message.builder().message("hello world!").build();
        return Response.ok(this.jsonUtil.convertObjectToJson(message)).build();
    }

    @GET
    @Path("/{name}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMessage(@PathParam("name") String name) {
        val message = Message.builder().message(String.format("hello %s!", name)).build();
        return Response.ok(this.jsonUtil.convertObjectToJson(message)).build();
    }

}
