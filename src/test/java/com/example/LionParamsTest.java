package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(Parameterized.class)
public class LionParamsTest {

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
        lion = new Lion( male, new Feline());
    }

    //Есть ли грива у льва?
    @Test
    public void testDoesHaveMane() throws Exception {
        Assert.assertEquals(lion.doesHaveMane(),expected);
    }
}
