package com.rxwx.kafka.component;

import org.apache.log4j.Logger;
import org.apache.zookeeper.server.quorum.QuorumCnxManager.Message;
import org.springframework.beans.factory.annotation.Autowired;
import com.rxwx.service.mq.kafka.KafkaService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service(value = "kafkaService")
public class KafkaServiceImpl implements KafkaService {

	private final static Logger logger = Logger.getLogger(KafkaServiceImpl.class);
	
	@Autowired
	KafkaTemplate<Integer, String> kafkaTemplate;
	
	public void send(String topic, String data) {
		// TODO Auto-generated method stub
		kafkaTemplate.send(topic, data);
	}

	public void send(String topic, int partition, String data) {
		// TODO Auto-generated method stub
		kafkaTemplate.send(topic, partition, data);
	}
	
	public void sendDefault(String data) {
		// TODO Auto-generated method stub
		kafkaTemplate.sendDefault(data);
		
	}

	public void sendDefault(int key, String data) {
		// TODO Auto-generated method stub
		kafkaTemplate.sendDefault(key, data);
		
	}

	public void sendDefault(int partition, int key, String data) {
		// TODO Auto-generated method stub
		kafkaTemplate.sendDefault(partition, key, data);
	}

	public void send(String topic, int partition, int key, String data) {
		// TODO Auto-generated method stub
		kafkaTemplate.send(topic, partition, key, data);
	}

	public void consumerMsg(String... strings) {
//		 String brokerList = "192.168.30.33:9092,192.168.30.34:9093,192.168.30.35:9094";
//	        String groupId = "group3";
//	        String topic = "TEST-TOPIC1";
//	        int workerNum = 5;
//
//	        ConsumerHandler consumers = new ConsumerHandler(brokerList, groupId, topic);
//	        consumers.execute(workerNum);
//	        consumers.shutdown();
	}
}
