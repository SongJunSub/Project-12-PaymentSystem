package com.example.paymentservice.payment.adapter.out.web.toss.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.client.reactive.ClientHttpConnector
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.WebClient
import reactor.netty.http.client.HttpClient
import reactor.netty.resources.ConnectionProvider
import java.util.Base64

//Toss Payments로 결제 승인 요청을 전달해줄 웹 클라이언트를 Bean으로 만든다.
//웹 클라이언트는 Spring Web Flux에서 비동기적인 HTTP 요청을 생성해서 보낼 수 있는 클라이언트이며, 이것을 통해 네트워크 통신을 할 수 있다.
@Configuration
class TossWebClientConfiguration(
    //Toss Payments API URL과 Secret Key 정보를 Application.yml에서 가져온다.
    @Value("\${PSP.toss.url}") private val baseUrl: String,
    @Value("\${PSP.toss.secretKey}") private val secretKey: String
) {

    @Bean
    fun tossPaymentWebClient(): WebClient {
        //Toss Payments API를 호출하기 위해서는 인증 정보를 제공해줘야 되는데, 이걸 위해서 Secret Key를 인코딩하여 요청 헤더에 넣어준다.
        val encodedSecretKey = Base64.getEncoder().encodeToString((secretKey + ":").toByteArray())

        return WebClient.builder()
            .baseUrl(baseUrl)
            .defaultHeader(HttpHeaders.AUTHORIZATION, "Basic $encodedSecretKey")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
            .clientConnector(reactorClientHttpConnector())
            .codecs{it.defaultCodecs()}
            .build()
    }

    private fun reactorClientHttpConnector(): ClientHttpConnector {
        val provider = ConnectionProvider.builder("toss-payment").build()

        return ReactorClientHttpConnector(HttpClient.create(provider))
    }

}