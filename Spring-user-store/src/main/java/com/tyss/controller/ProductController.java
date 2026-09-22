package com.tyss.controller;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.dto.UserDto;
import com.tyss.dto.ProductDto;
import com.tyss.repository.UserRepository;
import com.tyss.service.ProductService;
import com.tyss.service.UserService;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/product")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService;

	@GetMapping("/getall")
	public ResponseEntity<List<ProductDto>> getMethodName() {
		return ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
	}
	
	@GetMapping("/{pid}")
	public ResponseEntity<ProductDto> getproduct(@PathVariable long pid) {
		return ResponseEntity.status(HttpStatus.OK).body(productService.findByPid(pid));
	}
	
//	@PutMapping("/add-to-cart")
//	public ResponseEntity,List<ProductDto>> getByPid(@PathVariable long pid) {
//		return ResponseEntity.status(HttpStatus.OK).body(productService.findByPid(pid));
//	}
	
	
}
