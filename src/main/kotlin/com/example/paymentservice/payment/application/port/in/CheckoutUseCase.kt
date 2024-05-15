package com.example.paymentservice.payment.application.port.`in`

import com.example.paymentservice.payment.domain.CheckoutResult
import reactor.core.publisher.Mono

//Checkout 처리를 담당한다.
interface CheckoutUseCase {

    fun checkout(command: CheckoutCommand): Mono<CheckoutResult>

}