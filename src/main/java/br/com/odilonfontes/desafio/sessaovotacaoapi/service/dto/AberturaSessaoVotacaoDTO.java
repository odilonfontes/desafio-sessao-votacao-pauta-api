package br.com.odilonfontes.desafio.sessaovotacaoapi.service.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class AberturaSessaoVotacaoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    Long pautaId;

    Integer duracao;

    public Long getPautaId() {
        return pautaId;
    }

    public void setPautaId(Long pautaId) {
        this.pautaId = pautaId;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AberturaSessaoVotacaoDTO that = (AberturaSessaoVotacaoDTO) o;
        return Objects.equals(pautaId, that.pautaId) &&
                Objects.equals(duracao, that.duracao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pautaId, duracao);
    }

}
