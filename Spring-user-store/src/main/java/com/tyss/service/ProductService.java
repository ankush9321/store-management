package com.tyss.service;

import com.tyss.repository.ProductRepository;
import com.tyss.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tyss.dto.ProductDto;
//import com.tyss.dto.LoginUserDto;
import com.tyss.dto.UserDto;
import com.tyss.entity.Product;
import com.tyss.entity.User;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final ModelMapper modelMapper;
	private final ProductRepository productRepository;


	public List<ProductDto> getAll(){
		return productRepository.findAll().stream().map(product -> modelMapper.map(product, ProductDto.class)).toList();
	}
	
	public ProductDto findByPid(long pid){
		Optional<Product> product = productRepository.findByPid(pid);
		return modelMapper.map(product, ProductDto.class);
	}

}
