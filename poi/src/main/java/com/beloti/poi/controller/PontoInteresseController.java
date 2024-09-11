package com.beloti.poi.controller;

import com.beloti.poi.dto.RequestPontoInteresseDTO;
import com.beloti.poi.entity.PontoInteresse;
import com.beloti.poi.repository.PontoInteresseRepository;
import com.beloti.poi.service.PontoInteresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PontoInteresseController {

    @Autowired
    private PontoInteresseRepository repository;

    @Autowired
    private PontoInteresseService service;

    @PostMapping("/pontos-de-interesses")
    public ResponseEntity<Void> createPoi(@RequestBody RequestPontoInteresseDTO body){
        repository.save(new PontoInteresse(body.nome(), body.tipo(), body.funcionamento(), body.x(), body.y()));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/pontos-de-interesses")
    public ResponseEntity<Page<PontoInteresse>> listPoi(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                        @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize){
        var body = repository.findAll(PageRequest.of(page, pageSize));
        return ResponseEntity.ok(body);
    }

    @GetMapping("/proximo")
    public ResponseEntity<List<PontoInteresse>> listPoi(@RequestParam("x") Long x,
                                                        @RequestParam("y") Long y,
                                                        @RequestParam("dmax") Long dmax){
        var body = service.listPoiNear(x, y, dmax);
        return ResponseEntity.ok(body);
    }

    @GetMapping("/tipo")
    public List<PontoInteresse> listPoiType(@RequestParam String tipo){
        var body = repository.findByTipo(tipo);
        return body;
    }

    @PutMapping("/atualiza-poi")
    public ResponseEntity<PontoInteresse> attPoi(@RequestBody PontoInteresse body){
        service.atualizaPoi(body);
        return ResponseEntity.ok(body);
    }
}
