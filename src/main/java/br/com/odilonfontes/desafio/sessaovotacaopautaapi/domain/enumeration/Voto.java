package br.com.odilonfontes.desafio.sessaovotacaopautaapi.domain.enumeration;

public enum Voto {

    SIM("Sim"),
    NAO("Não");

    public final String rotulo;

    Voto(String rotulo) {
        this.rotulo = rotulo;
    }

    @Override
    public String toString() {
        return rotulo;
    }

}
