package com.bizzdesk.gotax.logging;

import com.bizzdesk.gotax.logging.kafka.LogChannel;
import com.bizzdesk.gotax.logging.repository.GoTaxLogsRepository;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackageClasses = {GoTaxLogsRepository.class})
@EnableBinding(LogChannel.class)
public class GotaxLoggingServiceConfiguration {

}
