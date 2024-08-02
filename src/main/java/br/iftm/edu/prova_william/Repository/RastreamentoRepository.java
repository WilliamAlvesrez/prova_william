package br.iftm.edu.prova_william.Repository;

import br.iftm.edu.prova_william.Model.Rastreamento;
import org.springframework.data.jpa.repository.JpaRepository;

public class RastreamentoRepository {
    public interface RastreamentoRepositoryInterface extends JpaRepository<Rastreamento, Long> {

    }

}
