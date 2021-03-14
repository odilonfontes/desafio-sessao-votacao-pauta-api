package br.com.odilonfontes.desafio.sessaovotacaoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.odilonfontes.desafio.sessaovotacaoapi.domain.Pauta;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long> {  }
