package com.rxwx.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.rxwx.service.mq.kafka.KafkaService;

@Controller
@RequestMapping(value = "/kafka")
public class KafkaController extends BaseController {
	
	private final static Logger logger = Logger.getLogger(KafkaController.class);
	
	@Autowired  KafkaService kafkaService;

	@RequestMapping(value = "/sendMsg")
	
	public void sendMsg(HttpServletRequest  request) {
		
		logger.info("*******into sendMsg*******");
		
		kafkaService.sendDefault("我是测试数据");
		
		logger.info("*******into sendMsg*******");
	}
}
