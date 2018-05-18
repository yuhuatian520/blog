package com.mlkj.blog;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mlkj.blog.bean.UserInfo;
import com.mlkj.blog.service.UserInfoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Blog1ApplicationTests {
	@Autowired
	private UserInfoService userInfoService;
	
	
	
	@Test
	public void testLoad() {
		System.out.println(userInfoService);
		
		UserInfo user=new UserInfo();
		user.setUserId(1);
		System.out.println(userInfoService.getUserInfo(user));//user 是null
		
	}
	
	@Test
	public void testJMS() throws JMSException {
	        ConnectionFactory connectionFactory = null;
	        Connection connection = null;
	        Session session = null;
	        Destination destination;
	        MessageProducer producer = null;
	        MessageConsumer consumer;
	        Message message;
	        boolean useTransaction = false;
	        try {
	                Context ctx = null;
					try {
						ctx = new InitialContext();
					} catch (NamingException e) {
						e.printStackTrace();
					}
	                try {
						connectionFactory = (ConnectionFactory) ctx.lookup("ConnectionFactoryName");
					} catch (NamingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                //使用ActiveMQ时：connectionFactory = new ActiveMQConnectionFactory(user, password, getOptimizeBrokerUrl(broker));
	                connection = connectionFactory.createConnection();
	                connection.start();
	                session = connection.createSession(useTransaction, Session.AUTO_ACKNOWLEDGE);
	                destination = session.createQueue("TEST.QUEUE");
	                //生产者发送消息
	                producer = session.createProducer(destination);
	                message = session.createTextMessage("this is a test");
	 
	                //消费者同步接收
	                consumer = session.createConsumer(destination);
	                message = (TextMessage) consumer.receive(1000);
	                System.out.println("Received message: " + message);
	                //消费者异步接收
	                consumer.setMessageListener(new MessageListener() {
	                        @Override
	                        public void onMessage(Message message) {
	                                if (message != null) {
	                                        doMessageEvent(message);
	                                }
	                        }

							private void doMessageEvent(Message message) {
								// TODO Auto-generated method stub
								
							}
	                });
	        } catch (JMSException e) {
	               
	        } finally {
	                producer.close();
	                session.close();
	                connection.close();
	        
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
