package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class WebApiController {

	/**
	 * http://localhost:8080/api/helloでログインできる
	 * 		⇒表示される内容：SpringBoot!
	 * @return
	 */

	@RequestMapping("hello")
	private String hello() {
		return "SpringBoot!";
	}

	public static class HogeMogeBean {
		private String hoge;
		private int moge;
		// prpperty と ctor は省略
	}

	@RequestMapping("hogemoge")
	public HogeMogeBean hogemoge() {
		return new HogeMogeBean("ほげ", 1234);
	}

}
