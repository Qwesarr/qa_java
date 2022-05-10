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

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock Feline feline; //Замаскируем класс кошачьих
    Lion lion;

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

        // Проверяем, что при запросе подходящей еды, вызывается метод getFood, с указанием "Хищник" класса "Кошачьи" feline
        @Test
        public void testGetFoodFeline() throws Exception {
            lion.getFood();
            Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
        }

        //Сколько у льва котят (львят)
        @Test
        public void testGetKittens() {
            Mockito.when(feline.getKittens()).thenReturn(1);  //Так как класс feline замокирован то определяем кол.во котят как 1
            Assert.assertEquals(lion.getKittens(),1);
        }

        // Проверяем, что при запросе кол.ва котят, вызывается метод getKittens() класса "Кошачьи" feline
        @Test
        public void testGetKittensFeline() {
            lion.getKittens();
            Mockito.verify(feline, Mockito.times(1)).getKittens();
        }

        //Проверка ошибки, при указании неверного пола льва
        @Test(expected = Exception.class)
        public void testDoesHaveMane() throws Exception {
            lion = new Lion("Котик", feline);
        }

    }