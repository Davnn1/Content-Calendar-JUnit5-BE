package com.davnn.contentcalendar;

import com.davnn.contentcalendar.model.Content;
import com.davnn.contentcalendar.model.Status;
import com.davnn.contentcalendar.model.Type;
import com.davnn.contentcalendar.repository.ContentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ContentCalendarApplicationTests {

//	Content content;
	@Mock
	ContentRepository repository;


//	@BeforeEach
//	void setup() {
//		content = new Content(null, "The Article Of Money", "This Article Gonna Change What You think About Money Before", Status.IN_PROGRESS, Type.ARTICLE, LocalDateTime.now(),null,"davnn.com");
//		System.out.println("Setup was called");
//	}
//
//	@AfterEach
//	void cleanup() {
//		content = null;
//		System.out.println("Cleanup was called");
//	}

	@Test
	void addContentApiTest() {

	}
}
