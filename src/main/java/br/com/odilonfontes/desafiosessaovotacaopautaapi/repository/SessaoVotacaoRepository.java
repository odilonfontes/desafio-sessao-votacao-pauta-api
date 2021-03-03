package br.com.odilonfontes.desafiosessaovotacaopautaapi.repository;

import br.com.odilonfontes.desafiosessaovotacaopautaapi.domain.SessaoVotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoVotacaoRepository extends JpaRepository<SessaoVotacao, Long> { }
