package web.demo.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import web.demo.rest.model.Product;

@RestController
public class ProductController {

	@PostMapping("/addproduct")
	public void addProduct(@RequestBody Product product) {
		System.out.println(product);
	}
	
	@GetMapping("/getproduct")
	public Product getProduct(){
		return new Product("Phone", 54.4f);
	}
	
	@GetMapping("/getproducts")
	public List<Product> getProducts(){
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("Phone", 50f));
		products.add(new Product("PS", 100f));
		return products;
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable int id){
		if (id==3) {
			Product p = new Product("Phone", 54.4f);
			HttpStatus status = HttpStatus.OK;
			return new ResponseEntity<Product>(p, status);
		} else {
			HttpStatus status = HttpStatus.NOT_FOUND;
			return new ResponseEntity<Product>(status);
		}
	}
}
