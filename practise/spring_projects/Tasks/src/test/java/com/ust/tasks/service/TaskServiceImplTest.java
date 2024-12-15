//package com.ust.tasks.service;
//
//import com.ust.tasks.Exceptions.RecordNotFound;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//@SpringBootTest
//class TaskServiceImplTest {
//
//    @Autowired
//    TaskServiceImpl taskService;
//
//    @Test
//    void getTaskById() {
//
//        var id = 1;
//
//        Assertions.assertDoesNotThrow(()->taskService.searchbyid(id));
//
////        Assertions.assertThrows(RecordNotFound.class,()->taskService.searchbyid(100));
//
//
//    }
//
//}