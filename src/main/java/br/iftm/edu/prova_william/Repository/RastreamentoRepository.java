package br.iftm.edu.prova_william.Repository;

import br.iftm.edu.prova_william.Model.Rastreamento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RastreamentoRepository extends JpaRepository<Rastreamento, Long> {
    List<Rastreamento> findByPacoteId(String pacoteId);
}
