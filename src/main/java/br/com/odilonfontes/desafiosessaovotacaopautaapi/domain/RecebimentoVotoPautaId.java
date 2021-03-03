package br.com.odilonfontes.desafiosessaovotacaopautaapi.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RecebimentoVotoPautaId implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_receb_voto_pauta__sessao"))
    public SessaoVotacao sessaoVotacao;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_receb_voto_pauta__associado"))
    public Associado associado;

    public RecebimentoVotoPautaId() { }

    public RecebimentoVotoPautaId(SessaoVotacao sessaoVotacao, Associado associado) {
        this.sessaoVotacao = sessaoVotacao;
        this.associado = associado;
    }

    public SessaoVotacao getSessaoVotacao() {
        return sessaoVotacao;
    }

    public void setSessaoVotacao(SessaoVotacao sessaoVotacao) {
        this.sessaoVotacao = sessaoVotacao;
    }

    public Associado getAssociado() {
        return associado;
    }

    public void setAssociado(Associado associado) {
        this.associado = associado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecebimentoVotoPautaId that = (RecebimentoVotoPautaId) o;
        return Objects.equals(sessaoVotacao, that.sessaoVotacao) &&
                Objects.equals(associado, that.associado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessaoVotacao, associado);
    }

}
