package com.enes.service;

import com.enes.dto.Dava;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@ApplicationScoped
public class DavaConsumerService {

    private static final Logger LOG = Logger.getLogger(DavaConsumerService.class);

    private final List<Dava> alinanDavalar = new CopyOnWriteArrayList<>();

    @Inject
    ObjectMapper objectMapper;

    @Incoming("davalar")
    public void tuket(String mesaj) throws Exception {
        Dava dava = objectMapper.readValue(mesaj, Dava.class);
        alinanDavalar.add(dava);
        LOG.infof("Yeni dava alındı: id=%s, mahkeme=%s, konu=%s", dava.getId(), dava.getMahkeme(), dava.getKonu());
    }

    public List<Dava> alinanDavalar() {
        return List.copyOf(alinanDavalar);
    }
}
