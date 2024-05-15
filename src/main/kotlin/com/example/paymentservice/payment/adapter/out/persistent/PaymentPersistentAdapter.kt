package com.example.paymentservice.payment.adapter.out.persistent

import com.example.paymentservice.common.PersistentAdapter
import com.example.paymentservice.payment.application.port.out.SavePaymentPort
import com.example.paymentservice.payment.domain.PaymentEvent
import reactor.core.publisher.Mono

@PersistentAdapter
class PaymentPersistentAdapter : SavePaymentPort{

    override fun save(paymentEvent: PaymentEvent): Mono<Void> {
        TODO("Not yet implemented")
    }

}