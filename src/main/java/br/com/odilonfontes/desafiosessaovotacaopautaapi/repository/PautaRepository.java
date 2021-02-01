package br.com.odilonfontes.desafiosessaovotacaopautaapi.repository;

import br.com.odilonfontes.desafiosessaovotacaopautaapi.domain.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long> {
}
