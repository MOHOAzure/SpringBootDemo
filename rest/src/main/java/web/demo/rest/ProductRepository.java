package web.demo.rest;

import org.springframework.data.repository.CrudRepository;

import web.demo.rest.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
     
    public Product findByName(String name);
}
