package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class WebApiController {

	/**
	 * http://localhost:8080/api/helloでログインできる
	 * @return
	 */

	@RequestMapping("hello")
	private String hello() {
		return "SpringBoot!";
	}
}
