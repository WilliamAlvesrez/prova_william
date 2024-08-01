package br.iftm.edu.prova_william.Model;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;

import java.util.Date;

public class Rastreamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataHora;
    private String status;
    private String localizacao;

    @ManyToOne
    
    private Pacote pacote;

    public Rastreamento() {}

    public Rastreamento(Date dataHora, String status, String localizacao, Pacote pacote) {
        this.dataHora = dataHora;
        this.status = status;
        this.localizacao = localizacao;
        this.pacote = pacote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Pacote getPacote() {
        return pacote;
    }

    public void setPacote(Pacote pacote) {
        this.pacote = pacote;
    }

    public String getResumo() {
        return "Data/Hora: " + dataHora + ", Status: " + status + ", Localização: " + (localizacao != null ? localizacao : "N/A");
    }
}
    

