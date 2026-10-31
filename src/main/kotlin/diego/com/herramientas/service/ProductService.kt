package diego.com.herramientas.service

import diego.com.herramientas.model.Product
import diego.com.herramientas.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service

@Service
open class ProductService {
    @Autowired
    open lateinit var productRepository: ProductRepository

    open fun listar(): List<Product> {
        return productRepository.findAll()
    }

    open fun save(product: Product): Product = productRepository.save(product)

    open fun update(id: Int, product: Product): Product {
        val existingProduct = productRepository.findById(id).orElseThrow {
            EntityNotFoundException("Producto con id $id no encontrado")
        }
        existingProduct.description = product.description
        existingProduct.price = product.price
        existingProduct.stock = product.stock
        return productRepository.save(existingProduct)
    }

    open fun deleteById(id: Int): Boolean {
        val product = productRepository.findById(id).orElse(null) ?: return false
        productRepository.delete(product)
        return true
    }
}
