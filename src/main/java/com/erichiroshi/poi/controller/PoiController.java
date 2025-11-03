package com.erichiroshi.poi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.erichiroshi.poi.entity.dto.PointDTO;
import com.erichiroshi.poi.entity.dto.PointNomeDTO;
import com.erichiroshi.poi.service.PoiService;

@RestController
@RequestMapping("/points")
public class PoiController {

    private final PoiService poiService;

    public PoiController(PoiService poiService) {
        this.poiService = poiService;
    }

    @GetMapping
    public ResponseEntity<List<PointDTO>> findall() {
        List<PointDTO> listDto = poiService.findAll();
        return ResponseEntity.ok(listDto);
    }
    
    @GetMapping("/near")
    public ResponseEntity<List<PointNomeDTO>> listarProximos(@RequestParam(defaultValue = "0") Long x,
                                                            @RequestParam(defaultValue = "0") Long y,
                                                            @RequestParam(defaultValue = "0") Long dMax) {
        List<PointNomeDTO> listDto = poiService.listarProximos(x, y, dMax);
        return ResponseEntity.ok(listDto);
    }

    @PostMapping
    public ResponseEntity<PointDTO> insert(@RequestBody PointDTO dto) {
        PointDTO saveDto = poiService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveDto.id()).toUri();
        return ResponseEntity.created(uri).body(saveDto);
    }

}