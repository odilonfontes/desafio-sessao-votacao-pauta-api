package br.com.odilonfontes.desafiosessaovotacaopautaapi.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Associado implements Serializable {

    @Id
    private Long id;

    @Size(max = 11)
    @NotNull @NotBlank
    private String cpf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Associado associado = (Associado) o;
        return Objects.equals(id, associado.id) &&
                Objects.equals(cpf, associado.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf);
    }
}
