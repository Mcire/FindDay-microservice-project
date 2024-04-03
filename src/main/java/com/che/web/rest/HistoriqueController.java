package com.che.web.rest;

import com.che.domain.Historique;
import com.che.repository.HistoriqueRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/historique")
public class HistoriqueController {

    @Autowired
    private HistoriqueRepository historiqueRepository;

    @GetMapping("/all")
    public List<Historique> getAllHistorique() {
        return historiqueRepository.findAll();
    }
}
