package com.davnn.contentcalendar;

import com.davnn.contentcalendar.config.ContentCalendarProperties;
import com.davnn.contentcalendar.model.Content;
import com.davnn.contentcalendar.model.Status;
import com.davnn.contentcalendar.model.Type;
import com.davnn.contentcalendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
