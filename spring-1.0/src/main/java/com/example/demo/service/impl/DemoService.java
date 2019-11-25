package com.example.demo.service.impl;


import com.example.demo.service.IDemoService;
import com.example.spring.annotation.Service;

@Service
public class DemoService implements IDemoService {

	public String get(String name) {
		return "My name is " + name;
	}

}
