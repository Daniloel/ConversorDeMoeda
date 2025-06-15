package br.com.danilo.conversordemoeda;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BuscaApiMoedas busca = new BuscaApiMoedas();
        Moedas moeda = busca.buscarDadosMoedas();

        FiltrarMoedas filtro = new FiltrarMoedas();

        Map<String, Double> resultadoFiltro = filtro.fitrarMoedasPais(moeda);

        ConversaoDeValores valoresConvertidos = new ConversaoDeValores(resultadoFiltro);

        Scanner leituta = new Scanner(System.in);
        System.out.print("Digite o código da moeda de origem (ex: BRL): ");
        String moedaOrigem = leituta.nextLine().toUpperCase();

        System.out.println("Digite o código da moeda de destino (ex: USD): ");
        String moedaDestino = leituta.nextLine().toUpperCase();

        System.out.println("Digite o valor que deseja converter: ");
        Double moedaValor = leituta.nextDouble();

        try {
            double valorConvertidoMoeda = valoresConvertidos.converter(moedaOrigem, moedaDestino, moedaValor);

            System.out.printf("%.2f %s equivale a %.2f %s%n", moedaValor, moedaOrigem, valorConvertidoMoeda, moedaDestino);

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }


    }
}