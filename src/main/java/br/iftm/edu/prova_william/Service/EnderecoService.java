package br.iftm.edu.prova_william.Service;

import br.iftm.edu.prova_william.Model.Endereco;
import br.iftm.edu.prova_william.Repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco criarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Optional<Endereco> obterEnderecoPorId(Long id) {
        return enderecoRepository.findById(id);
    }

    public List<Endereco> obterTodosEnderecos() {
        return enderecoRepository.findAll();
    }

    public Endereco atualizarEndereco(Long id, Endereco enderecoAtualizado) {
        Optional<Endereco> enderecoEntrega = enderecoRepository.findById(id);
        if (enderecoEntrega.isPresent()) {
            Endereco endereco = enderecoEntrega.get();
            endereco.setRua(enderecoAtualizado.getRua());
            endereco.setNumero(enderecoAtualizado.getNumero());
            endereco.setCep(enderecoAtualizado.getCep());
            endereco.setCidade(enderecoAtualizado.getCidade());
            endereco.setEstado(enderecoAtualizado.getEstado());
            return enderecoRepository.save(endereco);
        }
        return null;
    }

    public void deletarEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }
}
