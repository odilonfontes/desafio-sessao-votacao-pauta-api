package br.com.odilonfontes.desafiosessaovotacaopautaapi.repository;

import br.com.odilonfontes.desafiosessaovotacaopautaapi.domain.SessaoVotacaoPauta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoVotacaoPautaRepository extends JpaRepository<SessaoVotacaoPauta, Long> { }
