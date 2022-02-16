package com.vadim.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.vadim")
public class ApplicationConfig {


    /*
    4.	Concurrency
1. Добавить сервис для подсчёта обращений к основному сервису.
Счётчик должен быть реализован в виде отдельного класса, доступ к которому должен быть синхронизирован.
2. Используя jmeter/postman или любые другие средвста сконфигурировать нагрузочный тест и убедиться,
 что счётчик обращений работает правильно при большой нагрузке.

     */
}