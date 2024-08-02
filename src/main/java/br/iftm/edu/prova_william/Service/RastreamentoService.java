package br.iftm.edu.prova_william.Service;

import br.iftm.edu.prova_william.Model.Rastreamento;
import br.iftm.edu.prova_william.Repository.RastreamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RastreamentoService {

    @Autowired
    private RastreamentoRepository rastreamentoRepository;

    public Rastreamento criarRastreamento(Rastreamento rastreamento) {
        return rastreamentoRepository.save(rastreamento);
    }

    public Optional<Rastreamento> obterRastreamentoPorId(Long id) {
        return rastreamentoRepository.findById(id);
    }

    public List<Rastreamento> obterTodosRastreamentos() {
        return rastreamentoRepository.findAll();
    }

    public List<Rastreamento> obterRastreamentosPorPacoteId(String pacoteId) {
        return rastreamentoRepository.findByPacoteId(pacoteId);
    }

    public Rastreamento atualizarRastreamento(Long id, Rastreamento rastreamentoAtualizado) {
        Optional<Rastreamento> rastreamentoOpt = rastreamentoRepository.findById(id);
        if (rastreamentoOpt.isPresent()) {
            Rastreamento rastreamento = rastreamentoOpt.get();
            rastreamento.setDataHora(rastreamentoAtualizado.getDataHora());
            rastreamento.setLocalizacao(rastreamentoAtualizado.getLocalizacao());
            rastreamento.setStatus(rastreamentoAtualizado.getStatus());
            return rastreamentoRepository.save(rastreamento);
        }
        return null;
    }

    public void deletarRastreamento(Long id) {
        rastreamentoRepository.deleteById(id);
    }
}
