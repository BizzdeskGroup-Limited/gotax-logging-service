package com.bizzdesk.gotax.logging.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface LogChannel {

    @Input(value = "gotax-logs")
    SubscribableChannel input();
}
