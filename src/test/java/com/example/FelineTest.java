package com.example;

import org.jetbrains.annotations.TestOnly;
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
public class FelineTest {

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock Feline felineMok; //Новый, замокрированный экземпляр класса Feline для проверки внутренних методов
    Feline feline;


    //Создаем кошачье животное в начале каждого теста
    @Before
    public void setUp() throws Exception {
        feline = new Feline();
    }

    //К какому классу принадлежат
    @Test
    public void testGetFamily() {
        Assert.assertEquals(feline.getFamily(),"Кошачьи");
    }

    //Что едят кошачьи
    @Test
    public void testEatMeat() throws Exception {
        Assert.assertEquals(feline.eatMeat(),List.of("Животные", "Птицы", "Рыба"));
    }

    //Сколько котят "по умолчанию"
    @Test
    public void testGetKittens() {
        Assert.assertEquals(feline.getKittens(),1);
    }

    //Проверяем, что при вызове метода getKittens() без параметров, вызывается метод getKittens(1) с параметром "1"
    @Test
    public void testGetKittensParam() {
        felineMok.getKittens(1);
        Mockito.verify(felineMok, Mockito.times(1)).getKittens(1);
    }
}