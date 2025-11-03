package com.erichiroshi.poi.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.erichiroshi.poi.entity.dto.PointDTO;
import com.erichiroshi.poi.service.PoiService;

import lombok.extern.slf4j.Slf4j;

//@Profile("test")
@Slf4j
@Component
public class PointTest implements CommandLineRunner {

    private final PoiService pointService;

    public PointTest(PoiService poiService) {
        this.pointService = poiService;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Pontos de interesses: {}", pointService.findAll());

        log.info("Ponto de interesse salvo {}",
                pointService.insert(new PointDTO(null, "Lan House", 10L, 10L)).toString());

        log.info("Pontos de interesses próximos\n{}", pointService.listarProximos(20l, 10l, 10l));

    }
}