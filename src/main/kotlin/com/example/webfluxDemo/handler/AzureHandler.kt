package com.example.webfluxDemo.handler

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Component
class AzureHandler {
    var notFound = ServerResponse.notFound().build()

    fun getTest1(serverRequest: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok()
               // .contentType(MediaType.APPLICATION_JSON)
                .body(
                        "Hello Test1! ", String::class.java
                )
    }

    fun getTest2(serverRequest: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(
                        Flux.just(1, 2, 3, 4,5, 6)
                                .log(), Int::class.java
                )
    }
    fun getTest3(serverRequest: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok()
                // .contentType(MediaType.APPLICATION_JSON)
                .body(
                        Flux.just(1, 2, 3, 4)
                                .log(), Int::class.java
                )
    }

//    fun getMetaData(serverRequest: ServerRequest): Mono<ServerResponse?>? {
//
//        val sslContext = SslContextBuilder
//                .forClient()
//                .trustManager(InsecureTrustManagerFactory.INSTANCE)
//                .build()
//        val tcpClient = TcpClient.create().secure { sslProviderBuilder -> sslProviderBuilder.sslContext(sslContext) }
//        val httpClient = HttpClient.from(tcpClient)
//
//        val exchangeStrategies = ExchangeStrategies.builder()
//                .codecs { configurer: ClientCodecConfigurer -> configurer.defaultCodecs().maxInMemorySize(1024 * 1000) }.build()
//
//        var tmp : ResponseEntity<String>? = webClientBuilder
//                .clientConnector(ReactorClientHttpConnector(httpClient))
//                .exchangeStrategies(exchangeStrategies)
//                .build()
//                .get()
//                .uri("https://azure-api-endpoint-demo1.azurehealthcareapis.com/metadata")
//                //.exchange().block()
//                .retrieve()
//                .toEntity(String::class.java)
//                .block()
//
//        return ServerResponse.ok()
//                .contentType(MediaType.APPLICATION_JSON)
//                .body("", String::class.java)
//               // .body(tmp)
//               // .body(fromObject(tmp))
//                .switchIfEmpty(notFound)
//
//
//    }
}