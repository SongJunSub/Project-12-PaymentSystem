package com.example.paymentservice.payment.adapter.`in`.web.view

import com.example.paymentservice.common.WebAdapter
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import reactor.core.publisher.Mono

@Controller
//외부의 웹 요청을 받아서 어플리케이션으로 요청을 전달하는 역할을 담당하는 웹 어댑터라는 것을 명확하게 나타내기 위해서 설정한다.
@WebAdapter
class PaymentController {

    @GetMapping("/success")
    fun successPage(): Mono<String> {
        return Mono.just("success")
    }

    @GetMapping("/fail")
    fun failPage(): Mono<String> {
        return Mono.just("fail")
    }

}