package com.vadim.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.vadim")
public class ApplicationConfig {
}

/*
2.	Error logging/handling
1. Добавить валидацию входных параметров с возвращением 400 ошибки
2. Добавить обработку внутренних unchecked ошибок с возвратом 500 ошибки
3. Добавить логирование действий и ошибок
4. Написать unit test

 */