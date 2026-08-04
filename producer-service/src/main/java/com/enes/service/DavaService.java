package com.enes.service;

import com.enes.dto.Dava;
import com.enes.dto.DavaRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.smallrye.reactive.messaging.MutinyEmitter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;

import java.time.Instant;
import java.util.UUID;

@ApplicationScoped
public class DavaService {

    @Inject
    @Channel("davalar")
    MutinyEmitter<String> emitter;

    @Inject
    ObjectMapper objectMapper;

    public Dava davaOlusturVeYayinla(DavaRequest request) throws Exception {
        Dava dava = Dava.builder()
                .id(UUID.randomUUID().toString())
                .mahkeme(request.getMahkeme())
                .davaTuru(request.getDavaTuru())
                .davacilar(request.getDavacilar())
                .davalilar(request.getDavalilar())
                .konu(request.getKonu())
                .olaylar(request.getOlaylar())
                .talep(request.getTalep())
                .sonuc(null)
                .olusturmaTarihi(Instant.now())
                .build();

        emitter.sendAndAwait(objectMapper.writeValueAsString(dava));

        return dava;
    }
}
