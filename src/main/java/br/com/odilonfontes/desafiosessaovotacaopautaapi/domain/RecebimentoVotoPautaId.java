package br.com.odilonfontes.desafiosessaovotacaopautaapi.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RecebimentoVotoPautaId implements Serializable {

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_receb_voto_pauta__sessao"))
    public SessaoVotacaoPauta sessaoVotacaoPauta;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_receb_voto_pauta__associado"))
    public Associado associado;

    public RecebimentoVotoPautaId() { }

    public RecebimentoVotoPautaId(SessaoVotacaoPauta sessaoVotacaoPauta, Associado associado) {
        this.sessaoVotacaoPauta = sessaoVotacaoPauta;
        this.associado = associado;
    }

    public SessaoVotacaoPauta getSessaoVotacaoPauta() {
        return sessaoVotacaoPauta;
    }

    public void setSessaoVotacaoPauta(SessaoVotacaoPauta sessaoVotacaoPauta) {
        this.sessaoVotacaoPauta = sessaoVotacaoPauta;
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
        return Objects.equals(sessaoVotacaoPauta, that.sessaoVotacaoPauta) &&
                Objects.equals(associado, that.associado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessaoVotacaoPauta, associado);
    }

}
