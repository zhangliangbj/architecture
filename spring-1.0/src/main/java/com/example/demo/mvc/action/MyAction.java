package com.example.demo.mvc.action;


import com.example.demo.service.IDemoService;
import com.example.spring.annotation.Autowried;
import com.example.spring.annotation.Controller;
import com.example.spring.annotation.RequestMapping;

@Controller
public class MyAction {

		@Autowried
		IDemoService demoService;
	
		@RequestMapping("/index.html")
		public void query(){

		}
	
}
