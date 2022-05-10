package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AlexLionTest {

    LionAlex alex = new LionAlex();

    public AlexLionTest() throws Exception {
    }

    //Поверка сколько детей у Алекса
    @Test
    public void testGetKittens() throws Exception {
        Assert.assertEquals(alex.getKittens(),0);
    }

    //Проверка есть ли у Алекса грива (самец ли он)
    @Test
    public void testDoesHaveMane() {
        assertTrue(alex.doesHaveMane());
    }

    //Проверка списка друзей Алекса
    @Test
    public void testGetFriends() {
        Assert.assertEquals(alex.getFriends(),List.of("Марти", "Глории", "Мелман"));
    }

    //Проверка, где живет Алекс
    @Test
    public void testGetPlaceOfLiving() {
        Assert.assertEquals(alex.getPlaceOfLiving(),"Нью-Йоркский зоопарк");
    }
}