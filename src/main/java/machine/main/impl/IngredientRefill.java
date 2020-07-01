package machine.main.impl;
/* Author: Aritra Saha */

import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class IngredientRefill {
    public void refill(HashSet<String> refillItems){
        refillItems.stream().forEach(x -> System.out.println("Refill needed for : "+ x));
    }
}
