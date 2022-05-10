package com.example;
import java.util.ArrayList;
import java.util.List;

public class LionAlex extends Lion {

    private static final Feline feline = new Feline();

    //Конструктор по умолчанию
    public LionAlex() throws Exception {
        super("Самец", feline);
    }

    //Переопределяем метод, так как у Алекса нет котят (детей)
    @Override
    public int getKittens() {
        return 0;
    }

    //Список друзей
    public List<String> getFriends() {
        return List.of("Марти", "Глории", "Мелман");
    }

    //Место жительства
    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

}


