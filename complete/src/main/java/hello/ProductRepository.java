package hello;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long>{

	Product findByProductBarCode(Integer productBarCode);
}
