package com.example;

import java.util.Optional; // from JDK 1.8


class VegFood {
    private String name;

    public VegFood(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class FoodFactory {
    public Optional<VegFood> getVegFood(String type) {
        if (type.equals("veg"))
            return Optional.of(new VegFood("rice"));
        else
            return Optional.empty();
    }
}

public class Ex5_Optional_Type {

    public static void main(String[] args) {

        FoodFactory foodFactory = new FoodFactory();
        Optional<VegFood> optionalVegFood = foodFactory.getVegFood("veg");

        VegFood vegFood = optionalVegFood
                .orElseThrow(() -> new IllegalStateException("im veg."));

    }
}
