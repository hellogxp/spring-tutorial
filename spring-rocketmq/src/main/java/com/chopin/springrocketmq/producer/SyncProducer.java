package com.chopin.springrocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: TODO
 * @Author chopin
 * @Date 2021/4/22 11:46 PM
 * @Version 1.0
 */
@SpringBootApplication
public class SyncProducer {
    public static void main(String[] args) throws Exception {
        //Instantiate with a producer group name.
        DefaultMQProducer producer = new
                DefaultMQProducer("Group_Producer_Daily");
        // Specify name server addresses.
        producer.setNamesrvAddr("localhost:9876");
        producer.setSendMsgTimeout(15000);
        //Launch the instance.
        producer.start();
        int messageCount = 3;
        for (int i = 0; i < messageCount; i++) {
            //Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("TopicSyncProducer", "TagSyncProducer",
                    ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET)
            );
            //Call send message to deliver message to one of brokers.
            SendResult sendResult = producer.send(msg);
            System.out.printf("Thread: %s, sendResult: %s %n", Thread.currentThread().getContextClassLoader(), sendResult);
        }
        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
    }
}