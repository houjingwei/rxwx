package com.rxwx.service.mq.kafka;

public interface KafkaService {
	
	void sendMsg();
	
	void sendMsg(String ...strings );

}
