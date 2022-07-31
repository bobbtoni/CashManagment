package ru.tirika.core.infrastructure.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.tirika.core.infrastructure.port.input.rest")
public class RestConfig {
}
