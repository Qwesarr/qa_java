package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;


@RunWith(Parameterized.class)
public class LionParamsTest {

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock Feline feline; //Замаскируем класс кошачьих
    private Lion lion;
    private final String male;
    private final boolean expected;

    public LionParamsTest(String male, boolean expected) {
        this.male = male;
        this.expected = expected;
    }

    //Параметры определяющие пол льва
    @Parameterized.Parameters
    public static Object[][] getMale() {
        return new Object[][]{
                {"Самец", true}
                ,{"Самка", false}
        };
    }
    //Создаем льва перед каждым тестом
    @Before
    public void setUp() throws Exception {
        lion = new Lion(male, feline);
    }

    //Есть ли грива у льва?
    @Test
    public void testDoesHaveMane() throws Exception {
        Assert.assertEquals(lion.doesHaveMane(),expected);
    }
}
