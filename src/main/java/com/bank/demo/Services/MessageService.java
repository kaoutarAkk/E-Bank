//package com.bank.demo.Services;
//
//import com.bank.demo.Messagerie.MessageReceiver;
//import com.bank.demo.Repository.MessageRepository;
//import com.bank.demo.config.AppConfig;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.AbstractApplicationContext;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MessageService {
//    @Autowired
//    MessageRepository messageRepository;
//
//    public String recevoirMessage(){
//        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        MessageReceiver messageReceiver = (MessageReceiver) context.getBean("messageReceiver");
//        String s = messageReceiver.receiveMessage();
//        ((AbstractApplicationContext)context).close();
//         return s;
//    }
//
//}
