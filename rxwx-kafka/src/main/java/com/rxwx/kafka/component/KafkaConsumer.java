package com.rxwx.kafka.component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.MessageListener;
  
public class KafkaConsumer implements MessageListener<Integer, String>{  
  
	private Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
  
    private int threadNum = 8;  
    private int maxQueueSize = 2000;  
    private ExecutorService executorService = new ThreadPoolExecutor(threadNum, threadNum, 0L, 
    		TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(maxQueueSize),
    		new ThreadPoolExecutor.CallerRunsPolicy());  
	
    public void onMessage(final ConsumerRecord<Integer, String> record) { 
    	 System.out.println("*****接收到消息*****");
    	 System.out.printf(Thread.currentThread().getName()+",offset = %d, key = %s, value = %s%n, topic = %s%n, partition = %s%n", 
           	     record.offset(),
           	     record.key(), 	
           	     record.value(),
           	     record.topic(),
            	 record.partition());
       /*  executorService.execute(new Runnable() {  
             @Override  
             public void run() {  
            	 System.out.printf(Thread.currentThread().getName()+",offset = %d, key = %s, value = %s%n, topic = %s%n, partition = %s%n", 
                   	     record.offset(),
                   	     record.key(), 	
                   	     record.value(),
                   	     record.topic(),
                    	 record.partition());
             }  
         });*/
    } 
}  