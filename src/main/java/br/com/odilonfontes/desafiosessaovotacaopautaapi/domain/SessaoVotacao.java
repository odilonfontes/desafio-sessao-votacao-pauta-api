package br.com.odilonfontes.desafiosessaovotacaopautaapi.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class SessaoVotacao implements Serializable {

    private static final long serialVersionUID = 1L;

    public SessaoVotacao() {
        abertura = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime abertura;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_sessao_votacao__pauta"))
    private Pauta pauta;

    @NotNull
    private LocalDateTime termino;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getAbertura() {
        return abertura;
    }

    public void setAbertura(LocalDateTime abertura) {
        this.abertura = abertura;
    }

    public Pauta getPauta() {
        return pauta;
    }

    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }

    public LocalDateTime getTermino() {
        return termino;
    }

    public void setTermino(LocalDateTime termino) {
        this.termino = termino;
    }

    public void setDuracao(Integer duracao) {
        this.termino = (abertura != null && duracao != null) ? abertura.plusMinutes(duracao) : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessaoVotacao that = (SessaoVotacao) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(abertura, that.abertura) &&
                Objects.equals(pauta, that.pauta) &&
                Objects.equals(termino, that.termino);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, abertura, pauta, termino);
    }

}
