package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.JWTManager;

@RestController
@RequestMapping("/jwt")
public class AppController {

	@Autowired
	JWTManager JM;
	
	@GetMapping("/generate/{uname}")
	public String generate(@PathVariable("uname") String username)
	{
		return JM.generateToken(username);
	}
	
	@GetMapping("/validate/{jwttoken}")
	public String validate(@PathVariable("jwttoken") String token)
	{
		return JM.validateToken(token).toString();
	}
}
