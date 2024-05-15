package com.example.paymentservice.payment.adapter.`in`.web.request

import java.time.LocalDateTime

//Checkout API 호출은 사용자가 수동으로 하지 않고 자동으로 호출되도록 만들기 위해 기본 값을 임의로 설정한다.
data class CheckoutRequest (
    val cartId: Long = 1,
    val productIds: List<Long> = listOf(1, 2, 3),
    val buyerId: Long = 1,
    val seed: String = LocalDateTime.now().toString()
)