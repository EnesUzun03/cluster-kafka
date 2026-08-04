package com.enes.controller;

import com.enes.dto.Dava;
import com.enes.dto.DavaRequest;
import com.enes.service.DavaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/davalar")
public class DavaController {

    @Inject
    DavaService davaService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response davaOlustur(DavaRequest request) throws Exception {
        Dava dava = davaService.davaOlusturVeYayinla(request);
        return Response.status(Response.Status.CREATED).entity(dava).build();
    }
}
