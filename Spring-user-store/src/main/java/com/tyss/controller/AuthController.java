package com.tyss.controller;



import org.springframework.http.HttpStatus;
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
import com.tyss.service.UserService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AuthController {
	
	private final UserService userService;

	@PostMapping("/register")
	public ResponseEntity<UserDto> register(@RequestBody UserDto UserDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveData(UserDto));
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserDto> login(@RequestBody UserDto userDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.getByUserNameAndPassword(userDto.getUsername(),userDto.getPassword()));
	}
	
}
