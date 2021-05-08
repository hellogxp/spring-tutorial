package com.chopin.springrocketmq.producer;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @Author chopin
 * @Date 2021/4/18 8:37 PM
 * @Version 1.0
 */
@SpringBootApplication
public class AsyncProducer {
    public static void main(String[] args) {
        final Logger LOGGER = LoggerFactory.getLogger(AsyncProducer.class);
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer("Group_Producer_Daily");
        defaultMQProducer.setNamesrvAddr("localhost:9876");
//        defaultMQProducer.setVipChannelEnabled(false);
        defaultMQProducer.setSendMsgTimeout(15000);
        try {
            defaultMQProducer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        defaultMQProducer.setRetryTimesWhenSendAsyncFailed(0);

        int messageCount = 3;
        final CountDownLatch countDownLatch = new CountDownLatch(messageCount);
        for (int i = 0; i < messageCount; i++) {
            final int index = i;
            try {
                Message message = new Message("TopicAsyncProducer","TagAsyncProducer", "KeyAsyncProducer",
                        ("\"This is message body\"" + index).getBytes(RemotingHelper.DEFAULT_CHARSET));
                defaultMQProducer.send(message, new SendCallback() {
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        countDownLatch.countDown();
                        System.out.printf("%-10d %s OK %s %n", index, Thread.currentThread().getName(), sendResult.getMsgId());
                    }

                    @Override
                    public void onException(Throwable e) {
                        countDownLatch.countDown();
                        System.out.printf("%-10d Exception %s %n", index, e);
                    }
                });
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (RemotingException e) {
                e.printStackTrace();
            } catch (MQClientException e) {
                e.printStackTrace();
            }
        }
        try {
            countDownLatch.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        defaultMQProducer.shutdown();
    }
}