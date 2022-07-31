package ru.tirika.core.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.tirika.core.domain.event.DomainEvent;
import ru.tirika.core.shared.event.EventManager;
import ru.tirika.core.shared.event.Listener;

@Configuration
public class EventsConfig {

    @Bean
    public EventManager eventManager() {
        return new EventManager() {

            @Override
            public <T extends DomainEvent> void subscribe(Listener<T> listener) {
                // TODO Auto-generated method stub

            }

            @Override
            public <T extends DomainEvent> void notify(T event) {
                // TODO Auto-generated method stub

            }
        };
    }

}
