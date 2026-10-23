package diego.com.herramientas.repository

import diego.com.herramientas.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Int>
