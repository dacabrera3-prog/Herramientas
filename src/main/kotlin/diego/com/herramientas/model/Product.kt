package diego.com.herramientas.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "product")
class Product(
    @Id
    var id: Int = 0,

    @Column(length = 100)
    var description: String? = null,

    @Column(length = 100)
    var price: String? = null,

    var stock: Int? = null
)
