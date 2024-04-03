package com.che.service;

import com.che.domain.Historique;
import com.che.repository.HistoriqueRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HistoriqueService {

    @Autowired
    private HistoriqueRepository historiqueRepository;

    public void saveHistorique(String requestDate, String dayOfWeek) {
        Historique historique = new Historique();
        historique.setSearchDate(LocalDateTime.now());
        historique.setRequest(requestDate);
        historique.setResponseDate(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        historique.setResponseDay(dayOfWeek);

        historiqueRepository.save(historique);
    }
}
