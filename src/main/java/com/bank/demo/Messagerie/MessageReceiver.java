//package com.bank.demo.Messagerie;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.jms.support.converter.MessageConverter;
//import org.springframework.stereotype.Component;
//
//import javax.jms.Message;
//
//@Component
//public class MessageReceiver {
//
//    @Autowired
//    JmsTemplate jmsTemplate;
//    @Autowired
//    MessageConverter messageConverter;
//
//    public String receiveMessage()
//    {
//        try
//        {
//            /*
//             * Here we receive the message.
//             */
//            Message message = jmsTemplate.receive();
//            String chaine= (String) messageConverter.fromMessage(message);
//            return chaine;
//
//        }
//        catch (Exception exe)
//        {
//            exe.printStackTrace();
//        }
//
//        return null;
//    }
//}
