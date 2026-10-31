package diego.com.herramientas.controller

import diego.com.herramientas.model.Product
import diego.com.herramientas.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/product")
open class ProductController {

    @Autowired
    private lateinit var productService: ProductService

    @GetMapping
    open fun listar(): List<Product> {
        return productService.listar()
    }

    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    open fun guardar(@RequestBody product: Product): Product {
        println("Llegó: description=${product.description}, price=${product.price}, stock=${product.stock}")
        return productService.save(product)
    }

    @PutMapping("/{id}")
    open fun update(@PathVariable id: Int, @RequestBody product: Product): Product {
        return productService.update(id, product)
    }

    @DeleteMapping("/{id}")
    open fun deleteById(@PathVariable id: Int): ResponseEntity<Void> {
        return if (productService.deleteById(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
