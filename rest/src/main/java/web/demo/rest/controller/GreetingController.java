package web.demo.rest.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import web.demo.rest.model.Greeting;

@RestController
public class GreetingController {
	private static final String template = "Hello, %s";
	private final AtomicLong counter = new AtomicLong();
	
	// /greeting?name=Ye
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@PostMapping("/hello")
	public String create() {
		return "You have sent POST";
	}
	
	@PutMapping("/hello")
	public String updateReplace() {
		return "You have sent PuT";
	}
	
	@DeleteMapping("/hello")
	public String delete() {
		return "You have sent Delete";
	}
}
