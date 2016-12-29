package com.rxwx.service.mq.kafka;

public interface KafkaService {
	void send(String topic ,String data);
	void send(String topic ,int partition,String data);
	void send(String topic ,int partition,int key,String data);

	void sendDefault(String data);
	void sendDefault(int key, String data);
	void sendDefault(int partition,int key,String data);
	
	
	
	void consumerMsg(String ...strings );


}
