package br.com.danilo.conversordemoeda;

import java.util.Map;

public record Moedas(String base_code , Map<String,Double> conversion_rates) {
}
