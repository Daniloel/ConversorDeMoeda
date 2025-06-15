package br.com.danilo.conversordemoeda;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaApiMoedas {

    public Moedas buscarDadosMoedas (){
        URI endereco =  URI.create("https://v6.exchangerate-api.com/v6/d3bfe101c9b154a155bdd0b8/latest/USD");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moedas.class);
        } catch (IOException | InterruptedException  e) {
            throw new RuntimeException(e);
        }

    }



}
