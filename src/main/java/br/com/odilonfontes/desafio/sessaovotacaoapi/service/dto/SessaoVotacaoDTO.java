package br.com.odilonfontes.desafio.sessaovotacaoapi.service.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class SessaoVotacaoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private LocalDateTime abertura;
    private Long pautaId;
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

    public Long getPautaId() {
        return pautaId;
    }

    public void setPautaId(Long pautaId) {
        this.pautaId = pautaId;
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
        SessaoVotacaoDTO that = (SessaoVotacaoDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(abertura, that.abertura) &&
                Objects.equals(pautaId, that.pautaId) &&
                Objects.equals(termino, that.termino);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, abertura, pautaId, termino);
    }

}
