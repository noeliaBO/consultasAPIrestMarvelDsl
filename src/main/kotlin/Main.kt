package org.example

import kotlinx.serialization.json.Json
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun main() {
    val publicKey ="42e8ae5bd71cfea8529932caf8ded0b1"
    val hash="fb84cb4393dd9eef1e4e8d977fa9d98f"
    val ts =1000
    val gateway ="https://gateway.marvel.com/v1/public/characters?"
    val nombre="&nameStartsWith=" + "H"
    val url="${gateway}apikey=$publicKey&hash=$hash&ts=$ts"
    val client = HttpClient.newHttpClient()


    val request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .GET()
        .build()


    val response = client.send(request, HttpResponse.BodyHandlers.ofString())


    val jsonBody = response.body()


    val marvelRespose: MarvelCharacterResponse = Json.decodeFromString(jsonBody)
    val listaPersonajes=marvelRespose.data.results
    for (personaje in listaPersonajes){
        println("Heroe: "+personaje.name)
        println("Series donde aparece: ")
        for (serie in personaje.series.items){

         println("       "+ serie.name)
        }
        println("________________________________")
    }
}