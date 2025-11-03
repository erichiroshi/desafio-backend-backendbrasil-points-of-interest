package com.erichiroshi.poi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
import com.erichiroshi.poi.service.PointService;

@RestController
@RequestMapping("/points")
public class PointController {

    private final PointService pointService;

    public PointController(PointService poiService) {
        this.pointService = poiService;
    }

    @GetMapping
    public ResponseEntity<Page<PointDTO>> findAll(@RequestParam(defaultValue = "0") Integer page,
                                                    @RequestParam(defaultValue = "10") Integer pageSize) {
        
        Page<PointDTO> listDto = pointService.findAll(PageRequest.of(page, pageSize));
        return ResponseEntity.ok(listDto);
    }

    @GetMapping("/near")
    public ResponseEntity<List<PointNomeDTO>> listarProximos(@RequestParam(defaultValue = "0") Long x,
                                                            @RequestParam(defaultValue = "0") Long y,
                                                            @RequestParam(defaultValue = "0") Long dMax) {
        
        List<PointNomeDTO> listDto = pointService.listarProximos(x, y, dMax);
        return ResponseEntity.ok(listDto);
    }

    @PostMapping
    public ResponseEntity<PointDTO> insert(@RequestBody PointDTO dto) {
        PointDTO saveDto = pointService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveDto.id()).toUri();
        return ResponseEntity.created(uri).body(saveDto);
    }

}