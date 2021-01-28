package br.com.odilonfontes.desafiosessaovotacaopautaapi.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class SessaoVotacaoPauta implements Serializable {

    @Id
    private Long id;

    @NotNull
    private LocalDateTime abertura;

    @NotNull
    @ManyToOne
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessaoVotacaoPauta that = (SessaoVotacaoPauta) o;
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
