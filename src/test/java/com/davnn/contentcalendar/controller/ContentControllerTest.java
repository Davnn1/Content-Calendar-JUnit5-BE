package com.davnn.contentcalendar.controller;

import com.davnn.contentcalendar.model.Content;
import com.davnn.contentcalendar.model.Status;
import com.davnn.contentcalendar.model.Type;
import com.davnn.contentcalendar.repository.ContentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ContentControllerTest {
    @InjectMocks
    ContentController contentController;

    @Mock
    ContentRepository repository;

//    @BeforeEach
//    void setup() {
//        MockitoAnnotations.initMocks(this);
//    }
    @Tag("Find")
    @Test
    void findAllTest(){
        List<Content> contentList= new ArrayList<>();
        contentList.add(new Content());
        contentList.add(new Content());
        when(repository.findAll()).thenReturn(contentList);

        List<Content> rs = contentController.findAll();
        assertEquals(contentList,rs);
    }

    @Test
    void findByIdFoundTest(){
        when(repository.findById(anyInt())).thenReturn(Optional.of(new Content()));

        Content result= contentController.findById(anyInt());
        assertNotNull(result);
        assertEquals(null, result.id());
    }

    @Test
    void findByIdNotFoundTest(){
        ResponseStatusException responseStatusException = assertThrows(ResponseStatusException.class, () -> {
            contentController.findById(anyInt());
        });

        assertEquals(HttpStatus.NOT_FOUND, responseStatusException.getStatus() );
        assertEquals("Content not found!", responseStatusException.getReason() );
    }

    @Tag("Create")
    @Test
    void createContentTest(){
        Content content= new Content();
        contentController.create(content);
        verify(repository).save(content);
    }
    @Tag("Update")
    @Test
    void updatedNotFoundTest() {
        when(repository.existsById(anyInt())).thenReturn(false);

        ResponseStatusException responseStatusException = assertThrows(ResponseStatusException.class, () -> {
            contentController.update(new Content(), anyInt());
        });
        verify(repository).existsById(anyInt());
        verify(repository, never()).save(any(Content.class));

        assertEquals(HttpStatus.NOT_FOUND, responseStatusException.getStatus() );
        assertEquals("Content not found!", responseStatusException.getReason() );
    }

    @Test
    void updatedFoundTest(){
        when(repository.existsById(anyInt())).thenReturn(true);
        contentController.update(new Content(), 123);
        verify(repository).existsById(123);
        verify(repository).save(any(Content.class));
    }

    @Tag("Delete")
    @Test
    void deleteContentTest(){
        contentController.delete(anyInt());
        verify(repository).deleteById(anyInt());
    }

    @Tag("Filter")
    @Test
    void findByTitleTest(){
        List<Content> contentList= new ArrayList<>();
        contentList.add(new Content());
        when(repository.findAllByTitleContains(anyString())).thenReturn(contentList);
        List<Content> rs= contentController.findByTitle(anyString());
        assertNotNull(rs);
        assertEquals(contentList,rs);
    }
    @Test
    void findByStatusTest(){
        List<Content> contentList = new ArrayList<>();
        contentList.add(new Content());
        when(repository.listByStatus(Status.IDEA)).thenReturn(contentList);
        List<Content> rs = contentController.findByStatus(Status.IDEA);
        assertNotNull(rs);
        assertEquals(contentList,rs);
    }
}