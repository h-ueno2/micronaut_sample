package example.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller()
class HelloController {

    @Get("/")
    fun index(): String {
        return "HelloWorld"
    }
}