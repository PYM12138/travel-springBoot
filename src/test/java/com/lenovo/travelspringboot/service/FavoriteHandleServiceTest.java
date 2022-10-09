package com.lenovo.travelspringboot.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FavoriteHandleServiceTest {
@Autowired
    FavoriteHandleService favoriteHandleService;
@Test
    void test1(){
    favoriteHandleService.insertFavoriteForUser(1, 55);
}


}