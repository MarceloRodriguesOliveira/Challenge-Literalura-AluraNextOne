package com.alura.literalura.connection;

import com.alura.literalura.dto.RequestDto;
import com.alura.literalura.dto.ResponseDto;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class ApiConnection {

    String buildUrl(RequestDto request){
        return String.format("https://gutendex.com/books?search=%s", URLEncoder.encode(request.title(), StandardCharsets.UTF_8));
    }

    public ResponseDto response(RequestDto request) throws IOException, InterruptedException {
        try{
            String address = buildUrl(request);
            HttpClient client = HttpClient.newBuilder()
                    .followRedirects(HttpClient.Redirect.ALWAYS)
                    .build();
            HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(address)).header("User-Agent", "Java HttpClient").GET().build();
            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() != 200){
                System.out.println("Erro na API. Status: "+response.statusCode());
                return null;
            }
            String jsonData = response.body();

            if(jsonData == null | jsonData.isEmpty()){
                System.out.println("Requisição vazia");
                return null;
            }

            Gson gson = new Gson();
            return gson.fromJson(jsonData, ResponseDto.class);

        }catch (IOException e) {
            System.out.println("Erro de conexão com a API.");
            e.printStackTrace();

        } catch (InterruptedException e) {
            System.out.println("Requisição interrompida.");
            e.printStackTrace();

        } catch (Exception e) {
            System.out.println("Erro ao converter JSON.");
            e.printStackTrace();
        }
        return null;
    }
}
