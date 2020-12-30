package web.demo.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import web.demo.rest.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
     
    public Product findByName(String name);
}
