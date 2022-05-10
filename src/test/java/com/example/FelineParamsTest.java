package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FelineParamsTest {

    Feline feline;
    @Parameterized.Parameter(0) public int kittensCount;

    //Список значений для проверки возможного кол.ва котят
    @Parameterized.Parameters
    public static Object[] getKittens() {
        return new Object[][]{
                {-10}
                ,{0}
                ,{10}
        };
    }

    //Создаем кошачье животное в начале каждого теста
    @Before
    public void setUp() throws Exception {
        feline = new Feline();
    }

    //Сколько может быть котят
    @Test
    public void testGetKittens() {
        Assert.assertEquals(feline.getKittens(kittensCount),kittensCount);
    }
}
