package br.iftm.edu.prova_william.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Pacote {
    
    @Id
    private String id;
    private String destinatario;

    @ManyToOne
    private Endereco endereco;

    private String status; // "pendente", "em trânsito", "entregue"

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacote")
    private List<Rastreamento> rastreamentos = new ArrayList<>();

    public Pacote() {}

    public Pacote(String id, String destinatario, Endereco endereco, String status) {
        this.id = id;
        this.destinatario = destinatario;
        this.endereco = endereco;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Rastreamento> getRastreamentos() {
        return rastreamentos;
    }

    public void setRastreamentos(List<Rastreamento> rastreamentos) {
        this.rastreamentos = rastreamentos;
    }

    public void atualizarStatus(String novoStatus, Date dataHora, String localizacao) {
        this.status = novoStatus;
        Rastreamento rastreamento = new Rastreamento(dataHora, novoStatus, localizacao, this);
        this.rastreamentos.add(rastreamento);
    }

    public String consultarInformacoes() {
        StringBuilder info = new StringBuilder("Pacote ID: " + id + "\nDestinatário: " + destinatario + "\nStatus: " + status + "\nEndereço: " + endereco.getEnderecoCompleto() + "\nRastreamentos:\n");
        for (Rastreamento rastreamento : rastreamentos) {
            info.append(rastreamento.getResumo()).append("\n");
        }
        return info.toString();
    }
}