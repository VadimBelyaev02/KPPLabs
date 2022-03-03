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
6.	Functional filtering and mapping
1. Добавить аггрегирующий функционал (подсчёт макс, мин, средних значений)
для входных параметров и результатов с использованием Java 8 map/filters функций.
Расширить результат POST соотвественно.

     */
}