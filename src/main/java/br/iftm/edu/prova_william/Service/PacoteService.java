package br.iftm.edu.prova_william.Service;

import br.iftm.edu.prova_william.Model.Pacote;
import br.iftm.edu.prova_william.Repository.PacoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacoteService {

    @Autowired
    private PacoteRepository pacoteRepository;

    public Pacote criarPacote(Pacote pacote) {
        return pacoteRepository.save(pacote);
    }

    public Optional<Pacote> obterPacotePorId(String id) {
        return pacoteRepository.findById(id);
    }

    public List<Pacote> obterTodosPacotes() {
        return pacoteRepository.findAll();
    }

    public Pacote atualizarStatus(String id, String status) {
        Optional<Pacote> pacoteEntrega = pacoteRepository.findById(id);
        if (pacoteEntrega.isPresent()) {
            Pacote pacote = pacoteEntrega.get();
            pacote.setStatus(status);
            return pacoteRepository.save(pacote);
        }
        return null;
    }

    public void deletarPacote(String id) {
        pacoteRepository.deleteById(id);
    }
}
