package br.iftm.edu.prova_william.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.iftm.edu.prova_william.Model.Endereco;

public class EnderecoRepository {
    public interface EnderecoRepositoryInterface extends JpaRepository<Endereco, Long> {
}
    
}
