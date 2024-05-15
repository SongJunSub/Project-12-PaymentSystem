package com.example.paymentservice.payment.adapter.`in`.web.view

import com.example.paymentservice.common.WebAdapter
import com.example.paymentservice.payment.adapter.`in`.web.request.CheckoutRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import reactor.core.publisher.Mono

@Controller
@WebAdapter
class CheckOutController {

    @GetMapping("/")
    fun checkOutPage(checkoutRequest: CheckoutRequest): Mono<String> {
        return Mono.just("checkout")
    }

}