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

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    //Замаскируем класс кошачьих
    @Mock
    private Feline feline;

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
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(cat.getFood(), List.of("Животные", "Птицы", "Рыба"));
    }
}