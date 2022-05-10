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
public class FelineTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    //@Mock
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
        System.out.println(feline.eatMeat());
        Assert.assertEquals(feline.eatMeat(),List.of("Животные", "Птицы", "Рыба"));
    }

    //Сколько котят "по умолчанию"
    @Test
    public void testGetKittens() {
        Assert.assertEquals(feline.getKittens(),1);
      //  Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void testGetKittensa() {
        feline.getKittens(1);
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }
}