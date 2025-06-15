package br.com.danilo.conversordemoeda;

import java.util.Map;

public class ConversaoDeValores {

    private Map<String , Double> resultadoFiltro;

    public ConversaoDeValores(Map<String, Double> resultadoFiltro) {

        this.resultadoFiltro = resultadoFiltro;
    }

    public double converter(String origem, String destino, double valor) {
        if (!resultadoFiltro.containsKey(origem) || !resultadoFiltro.containsKey(destino)) {
            throw new IllegalArgumentException("Código de moeda inválido.");
        }
        double valorEmUSD = valor / resultadoFiltro.get(origem);
        return valorEmUSD * resultadoFiltro.get(destino);
    }

}




