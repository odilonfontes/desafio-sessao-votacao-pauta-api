package br.com.odilonfontes.desafiosessaovotacaopautaapi.service.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class PautaDTO implements Serializable {

    private Long id;

    @NotNull
    private String titulo;

    @NotNull
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PautaDTO pautaDTO = (PautaDTO) o;
        return Objects.equals(id, pautaDTO.id) &&
                Objects.equals(titulo, pautaDTO.titulo) &&
                Objects.equals(descricao, pautaDTO.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, descricao);
    }

}
