package com.example.paymentservice.payment.application.port.`in`

//CheckoutRequest와 비슷하지만, 멱등성을 보장하기 위한 키를 내부 필드로 가진다.
//같은 멱등성 키를 가진 Command는 오직 한 번만 처리된다.
data class CheckoutCommand (
    val cartId: Long,
    val buyerId: Long,
    val productIds: List<Long>,
    val idempotencyKey: String
)