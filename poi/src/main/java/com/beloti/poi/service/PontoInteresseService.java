package com.beloti.poi.service;

import com.beloti.poi.entity.PontoInteresse;
import com.beloti.poi.repository.PontoInteresseRepository;
import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PontoInteresseService {

    @Autowired
    private PontoInteresseRepository repository;

    public List<PontoInteresse> listPoiNear(Long x, Long y, Long dmax) {
        var xMin = x - dmax;
        var xMax = x + dmax;
        var yMin = y - dmax;
        var yMax = y + dmax;

        var body = repository.findNearMe(xMin, xMax, yMin, yMax)
                .stream()
                .filter(p -> distanciaDoisPontos(x, y, p.getX(), p.getY()) <= dmax)
                .toList();

        return body;
    }

    public Double distanciaDoisPontos(Long x1, Long y1, Long x2, Long y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) +Math.pow(y2 - y1, 2));
    }

    public PontoInteresse atualizaPoi(PontoInteresse body) {
        body.setTipo(body.getTipo());
        body.setY(body.getY());
        body.setX(body.getX());
        body.setNome(body.getNome());
        body.setFuncionamento(body.getFuncionamento());

        repository.save(body);
        return body;
    }

}
