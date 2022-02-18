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
5.	Functional programming with Java 8
1. Преобразовать исходный сервис для работы со списком параметров для bulk операций используя Java 8 лямбда выражения.
2. Добавить POST метод для вызова bulk операции и передачи списка параметров в виде JSON


     */
}