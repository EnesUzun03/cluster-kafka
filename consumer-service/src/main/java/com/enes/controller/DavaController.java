package com.enes.controller;

import com.enes.dto.Dava;
import com.enes.service.DavaConsumerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/davalar")
public class DavaController {

    @Inject
    DavaConsumerService davaConsumerService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dava> alinanDavalar() {
        return davaConsumerService.alinanDavalar();
    }
}
