package com.rxwx.kafka.component;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class Worker implements Runnable {

    private ConsumerRecord<String, String> consumerRecord;

    public Worker(ConsumerRecord record) {
        this.consumerRecord = record;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " consumed " + consumerRecord.partition()
            + "th message with offset: " + consumerRecord.offset());
    }
}