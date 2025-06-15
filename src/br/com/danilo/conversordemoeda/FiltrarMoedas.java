package br.com.danilo.conversordemoeda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FiltrarMoedas {


    public Map<String, Double> fitrarMoedasPais (Moedas moedas){

        ArrayList<String> moedasFiltradas = new ArrayList<>();
        moedasFiltradas.add("ARS");
        moedasFiltradas.add("BOB");
        moedasFiltradas.add("BRL");
        moedasFiltradas.add("CLP");
        moedasFiltradas.add("COP");
        moedasFiltradas.add("USD");

        Map<String, Double> taxas = moedas.conversion_rates();
        Map<String , Double> resultado = new HashMap<>();



       for (String codigo : moedasFiltradas){

           Double valor = taxas.get(codigo);

           if (valor != null){

               resultado.put(codigo,valor);
           }
       }


       return resultado;
    }
}
