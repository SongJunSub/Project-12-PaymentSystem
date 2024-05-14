package com.example.paymentservice.payment.adapter.`in`.web.view

import com.example.paymentservice.common.WebAdapter
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import reactor.core.publisher.Mono

@Controller
@WebAdapter
class CheckOutController {

    @GetMapping("/")
    fun checkOutPage(): Mono<String> {
        return Mono.just("checkout")
    }

}