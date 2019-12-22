package com.bank.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.bank.demo")
//@Import({ MessagingConfiguration.class })
public class AppConfig
{

    // Put Other Application configuration here.
}
