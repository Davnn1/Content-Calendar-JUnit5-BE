package com.davnn.contentcalendar.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

public record Content (
        @Id
        Integer id,
        String title,
        @Column(value = "description")
        String desc,
        Status status,
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url
){

        public Content() {
                this(
                        null,
                        "My First Blog Post",
                        "My First Blog",
                        Status.IDEA,
                        Type.ARTICLE,
                        LocalDateTime.now(),
                        null,
                        ""
                );
        }
}
