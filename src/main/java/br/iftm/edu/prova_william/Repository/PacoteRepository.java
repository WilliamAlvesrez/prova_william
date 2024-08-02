package br.iftm.edu.prova_william.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.iftm.edu.prova_william.Model.Pacote;

public class PacoteRepository {

    public interface PacoteRepositoryInterface extends JpaRepository<Pacote, String> {
}
    
}
