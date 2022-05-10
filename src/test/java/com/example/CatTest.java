package com.example;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock Feline feline; //Замаскируем класс кошачьих
    Cat cat;

    //Создаем котика перед каждым тестом
    @Before
    public void setUp() throws Exception {
        cat = new Cat(feline);
    }

    //Проверяем какие звуки издает кошка
    @Test
    public void testGetSound() {
        Assert.assertEquals(cat.getSound(),"Мяу");
    }

    //Проверяем что кошка кушает
    @Test
    public void testGetFood() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));  //Так как класс замокирован, то передаем параметры при обращении к классу.
        Assert.assertEquals(cat.getFood(), List.of("Животные", "Птицы", "Рыба"));
    }

    // Проверяем, что при запросе подходящей еды, вызывается метод eatMeat класса "Кошачьи" feline
    @Test
    public void testGetFoodFeline() throws Exception {
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }

}