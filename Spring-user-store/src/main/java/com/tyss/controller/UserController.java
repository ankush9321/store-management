package com.tyss.controller;

import java.util.List;

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
import com.tyss.repository.UserRepository;
import com.tyss.service.UserService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;

	@PostMapping("/save")
	public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveData(userDto));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<UserDto>> getMethodName() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("user deleted successfully");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> update(@PathVariable long id, @RequestBody UserDto userDto) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.update(userDto, id));
	}
	
}
