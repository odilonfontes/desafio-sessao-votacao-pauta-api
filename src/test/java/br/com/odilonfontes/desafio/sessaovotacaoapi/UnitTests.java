package br.com.odilonfontes.desafio.sessaovotacaoapi;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages({
        "br.com.odilonfontes.desafio.sessaovotacaoapi.domain",
        "br.com.odilonfontes.desafio.sessaovotacaoapi.service",
        "br.com.odilonfontes.desafio.sessaovotacaoapi.web.rest"
})
public class UnitTests { }
