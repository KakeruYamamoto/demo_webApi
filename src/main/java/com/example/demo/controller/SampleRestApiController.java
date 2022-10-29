package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST API のサンプルコントローラ
 * 
 * <p>
 * {@code application.properties#sever.port = 8080} と設定していると仮定して、
 * {@code "localhost:8080/sample/api/test/*"} にアクセスする。
 * </p>
 */

@RestController
@RequestMapping("/sample/api")
public class SampleRestApiController {
	private static final Logger log = LoggerFactory.getLogger(SampleRestApiController.class);

	/**
	 * ～/test/"任意の文字列"  でアクセスできる
	 * @param param
	 * @return
	 */
	@RequestMapping("/test/{param}")
	private String testPathVariable(@PathVariable String param) {
		log.info(param);
		return "「/test/{param}」を使って、受け取ったパラメータ：" + param;
	}

	/**
	 * ~/test?param=xxxx でアクセスできる
	 * @param param
	 * @return
	 */
	@RequestMapping("/test")
	private String testRequestParam(@RequestParam String param) {
		log.info(param);
		return "「/test?param=xxxx」を使って、受け取ったパラメータ：" + param;
	}

	@RequestMapping(value = "/test", method = RequestMethod.POST)
	private String testRequestBody(@RequestBody String body) {
		log.info(body);
		return "受け取ったリクエストボディ：" + body;
	}

	/** 登録：CRUDでいう <b>C:CREATE</b> を行うAPI */
	@RequestMapping(value = "/resource", method = RequestMethod.POST)
	private String create(@RequestBody String data) {
		return "登録だよ";
	}

	/** 参照：CRUDでいう <b>R:READ</b> を行うAPI */
	@RequestMapping(value = "/resource/{id}", method = RequestMethod.GET)
	private String read(@PathVariable String id) {
		return "参照だよ";
	}

	/** 削除：CRUDでいう<b>D:DELETE</b>を行うAPI */
	@RequestMapping(value = "/resource/{id}", method = RequestMethod.DELETE)
	private String delote(@PathVariable String id) {
		return "削除だよ";
	}

	/** 更新：CRUDでいう <b>U:UPDATE</b> を行うAPI */
	@RequestMapping(value = "/resource/{id}", method = RequestMethod.PUT)
	private String update(@PathVariable String id, @RequestBody String data) {
		return "更新だよ";
	}

}
