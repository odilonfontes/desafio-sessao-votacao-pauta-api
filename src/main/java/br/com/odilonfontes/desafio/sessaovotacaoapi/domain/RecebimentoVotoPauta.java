package br.com.odilonfontes.desafio.sessaovotacaoapi.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import br.com.odilonfontes.desafio.sessaovotacaoapi.domain.enumeration.Voto;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class RecebimentoVotoPauta implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private RecebimentoVotoPautaId recebimentoVotoPautaId;

    @NotNull
    private Voto voto;

    public RecebimentoVotoPauta() { }

    public RecebimentoVotoPauta(SessaoVotacao sessaoVotacao, Associado associado) {
        this.recebimentoVotoPautaId = new RecebimentoVotoPautaId(sessaoVotacao, associado);
    }

    public RecebimentoVotoPautaId getRecebimentoVotoPautaId() {
        return recebimentoVotoPautaId;
    }

    public void setRecebimentoVotoPautaId(RecebimentoVotoPautaId recebimentoVotoPautaId) {
        this.recebimentoVotoPautaId = recebimentoVotoPautaId;
    }

    public Voto getVoto() {
        return voto;
    }

    public void setVoto(Voto voto) {
        this.voto = voto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecebimentoVotoPauta that = (RecebimentoVotoPauta) o;
        return Objects.equals(recebimentoVotoPautaId, that.recebimentoVotoPautaId) &&
                voto == that.voto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(recebimentoVotoPautaId, voto);
    }

}
