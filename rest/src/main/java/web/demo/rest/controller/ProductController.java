package web.demo.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.demo.rest.exception.ResourceNotFoundException;
import web.demo.rest.model.Product;
import web.demo.rest.repo.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	ProductRepository productRepo;
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return productRepo.findAll();
	}
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable(value="id") int productId){
		return productRepo.findById(productId)
				.orElseThrow( () -> new ResourceNotFoundException("Prodcut", "id", productId));
	}

	@PostMapping("/products")
	public Product addProduct(@Valid @RequestBody Product product) {
		return productRepo.save(product);
	}

    @PutMapping("/notes/{id}")
    public Product updateNote(@PathVariable(value = "id") int productId,
                                           @Valid @RequestBody Product productDetails) {

    	Product product = productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", productId));

    	product.setName(productDetails.getName());
    	product.setPrice(productDetails.getPrice());

        Product updatedProduct = productRepo.save(product);
        return updatedProduct;
    }
	
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") int productId) {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", productId));

        productRepo.delete(product);

        return ResponseEntity.ok().build();
    }
}
