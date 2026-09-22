package com.tyss.service;

import com.tyss.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//import com.tyss.dto.LoginUserDto;
import com.tyss.dto.UserDto;
import com.tyss.entity.User;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final ModelMapper modelMapper;
	private final UserRepository userRepository;
//	private final PasswordEncoder passwordEncoder;


	public UserDto saveData(UserDto userDto) {
		if(userDto.getEmail()==null || userDto.getEmail().isBlank()) {
			throw new IllegalArgumentException("Email cannot be empty");
		}
		if(userRepository.existsByEmail(userDto.getEmail())) {
			throw new IllegalArgumentException("Email already exist");
		}
		
		User user = modelMapper.map(userDto, User.class);
		user.setPassword(userDto.getPassword());
		userRepository.save(user);
		return modelMapper.map(user, UserDto.class);
	};
	
	public List<UserDto> getAll(){
		return userRepository.findAll().stream().map(user -> modelMapper.map(user, UserDto.class)).toList();
	}
	
	public UserDto getById(long id) {
		
		Optional<User> user = userRepository.findById(id);
		
		if(user.isEmpty()) {
			throw new IllegalArgumentException("user not Exist");
		}
			
		return modelMapper.map(user.get(), UserDto.class);
	}
	
	public UserDto getByUserNameAndPassword(String username,String password) {
		
		Optional<User> user = userRepository.findByUsernameAndPassword(username,password);
		
		if(user.isEmpty()) {
			throw new IllegalArgumentException("user not Exist");
		}
			
		return modelMapper.map(user.get(), UserDto.class);
	}
	
	public void delete(long id) {
		
	 	if(userRepository.existsById(id)) {
	 		userRepository.deleteById(id);
	 	}else {
	 	throw new IllegalArgumentException("user not exists with give id");
	 	}
	}

	public UserDto update(UserDto userDto,Long id) {
		
		User user = userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("user not found with given id"));
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setUsername(userDto.getUsername());
		userRepository.save(user);
		return modelMapper.map(user, UserDto.class);
	}

}
