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
public class LionTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private Feline feline;
    private Lion lion;



        //Создаем льва перед каждым тестом
        @Before
        public void setUp() throws Exception {
            lion = new Lion("Самец", feline);

        }

        //Что же ест лев
        @Test
        public void testGetFood() throws Exception {
            Mockito.when(feline.getFood(Mockito.any())).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            Assert.assertEquals(lion.getFood(), List.of("Животные", "Птицы", "Рыба"));
        }

        //Сколько у льва котят (львят)
        @Test
        public void testGetKittens() {
            Assert.assertEquals(lion.getKittens(),1);
        }
    }