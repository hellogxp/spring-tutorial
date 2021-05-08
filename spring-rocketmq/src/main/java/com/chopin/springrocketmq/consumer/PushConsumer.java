package com.chopin.springrocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @Description: TODO
 * @Author chopin
 * @Date 2021/4/18 9:41 PM
 * @Version 1.0
 */
@SpringBootApplication
public class PushConsumer {
    public static void main(String[] args) {
        DefaultMQPushConsumer defaultMQPushConsumer = new DefaultMQPushConsumer("Group_Consumer_Daily");
        defaultMQPushConsumer.setNamesrvAddr("localhost:9876");
        try {
            defaultMQPushConsumer.subscribe("TopicAsyncProducer", "*");
            defaultMQPushConsumer.registerMessageListener(new MessageListenerConcurrently() {
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                    System.out.printf("%s Receive New Message: %s %n", Thread.currentThread().getName(), msgs);
                    msgs.stream().forEach(messageExt -> {
                        System.out.println(new String(messageExt.getBody(), StandardCharsets.UTF_8));
                    });
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
        } catch (MQClientException e) {
            System.out.println(e.getMessage());
        }
        try {
            defaultMQPushConsumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        System.out.println("Consumer Started");
    }
}