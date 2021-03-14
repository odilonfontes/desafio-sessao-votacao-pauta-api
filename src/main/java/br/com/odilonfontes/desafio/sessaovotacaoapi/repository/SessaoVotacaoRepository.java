package br.com.odilonfontes.desafio.sessaovotacaoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.odilonfontes.desafio.sessaovotacaoapi.domain.SessaoVotacao;

@Repository
public interface SessaoVotacaoRepository extends JpaRepository<SessaoVotacao, Long> { }
