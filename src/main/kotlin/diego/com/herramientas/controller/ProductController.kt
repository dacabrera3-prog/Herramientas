package diego.com.herramientas.controller

import diego.com.herramientas.service.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(
    private val productService: ProductService
) {
    @GetMapping("/hola")
    fun saludo(): String = "Hola mundo"

    @GetMapping("/adios")
    fun despedida(): String = "Adios mundo"

    @GetMapping("/saludoService")
    fun saludoService(): String = productService.saludoService()
}
