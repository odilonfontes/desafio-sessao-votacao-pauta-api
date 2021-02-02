package br.com.odilonfontes.desafiosessaovotacaopautaapi;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages({
        "br.com.odilonfontes.desafiosessaovotacaopautaapi.domain",
        "br.com.odilonfontes.desafiosessaovotacaopautaapi.service"
})
public class UnitTests { }
