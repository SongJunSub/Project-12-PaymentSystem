package com.example.paymentservice.payment.adapter.out.web.executor

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
//실제로 외부로 API 요청을 보내는 Toss Payments Executor
class TossPaymentExecutor(
    private val tossPaymentWebClient: WebClient,
    private val uri: String = "/v1/payments/confirm"
) {

    //실제 결제 승인 API를 호출하는 로직
    fun execute(paymentKey: String, orderId: String, amount: String): Mono<String> {
        return tossPaymentWebClient.post()
            .uri(uri)
            .bodyValue("""
                {
                    "paymentKey": "${paymentKey}",
                    "orderId": "${orderId}",
                    "amount": $amount
                }
            """.trimIndent())
            .retrieve()
            .bodyToMono(String::class.java)
    }

}