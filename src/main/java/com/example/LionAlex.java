package com.example;
import java.util.ArrayList;
import java.util.List;

public class LionAlex extends Lion {

    private static final Feline feline = new Feline();

    public LionAlex() throws Exception {
        super("Самец", feline);
    }

    @Override
    public int getKittens() {
        return 0;
    }

    public List<String> getFriends() {
        return List.of("Марти", "Глории", "Мелман");
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

}


