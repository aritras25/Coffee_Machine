package machine.main.impl;
/* Author: Aritra Saha */

import machine.main.model.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class BreverageIngredientUsage {
    public void populateBreverageIngredientMap(CoffeeMachine coffeeMachine, HashMap<String, HashMap<String, Long>> breverageIngredientMap ){
        populateHotTeaIngredientMap(coffeeMachine.getMachine().getBeverages().getHot_tea(), breverageIngredientMap);
        populateHotCoffeeIngredientMap(coffeeMachine.getMachine().getBeverages().getHot_coffee(), breverageIngredientMap);
        populateBlackTeaIngredientMap(coffeeMachine.getMachine().getBeverages().getBlack_tea(), breverageIngredientMap);
        populateGreenTeaIngredientMap(coffeeMachine.getMachine().getBeverages().getGreen_tea(), breverageIngredientMap);

    }

    public void populateHotTeaIngredientMap(HotTea hotTea, HashMap<String, HashMap<String, Long>> breverageIngredientMap){
        HashMap<String, Long> hmap = new HashMap<>();
        hmap.put(Ingredient.hot_water.name(), hotTea.getHot_water());
        hmap.put(Ingredient.hot_milk.name(), hotTea.getHot_milk());
        hmap.put(Ingredient.ginger_syrup.name(), hotTea.getGinger_syrup());
        hmap.put(Ingredient.sugar_syrup.name(), hotTea.getSugar_syrup());
        hmap.put(Ingredient.tea_leaves_syrup.name(),hotTea.getTea_leaves_syrup());
        breverageIngredientMap.put("hot_tea", hmap);
    }

    public void populateHotCoffeeIngredientMap(HotCoffee hotCoffee, HashMap<String, HashMap<String, Long>> breverageIngredientMap){
        HashMap<String, Long> hmap = new HashMap<>();
        hmap.put(Ingredient.hot_water.name(), hotCoffee.getHot_water());
        hmap.put(Ingredient.hot_milk.name(), hotCoffee.getHot_milk());
        hmap.put(Ingredient.ginger_syrup.name(), hotCoffee.getGinger_syrup());
        hmap.put(Ingredient.sugar_syrup.name(), hotCoffee.getSugar_syrup());
        hmap.put(Ingredient.tea_leaves_syrup.name(),hotCoffee.getTea_leaves_syrup());
        breverageIngredientMap.put("hot_coffee", hmap);
    }

    public void populateBlackTeaIngredientMap(BlackTea blackTea, HashMap<String, HashMap<String, Long>> breverageIngredientMap){
        HashMap<String, Long> hmap = new HashMap<>();
        hmap.put(Ingredient.hot_water.name(), blackTea.getHot_water());
        hmap.put(Ingredient.ginger_syrup.name(), blackTea.getGinger_syrup());
        hmap.put(Ingredient.sugar_syrup.name(), blackTea.getSugar_syrup());
        hmap.put(Ingredient.tea_leaves_syrup.name(),blackTea.getTea_leaves_syrup());
        breverageIngredientMap.put("black_tea", hmap);
    }

    public void populateGreenTeaIngredientMap(GreenTea greenTea, HashMap<String, HashMap<String, Long>> breverageIngredientMap){
        HashMap<String, Long> hmap = new HashMap<>();
        hmap.put(Ingredient.hot_water.name(), greenTea.getHot_water());
        hmap.put(Ingredient.ginger_syrup.name(), greenTea.getGinger_syrup());
        hmap.put(Ingredient.sugar_syrup.name(), greenTea.getSugar_syrup());
        hmap.put(Ingredient.green_mixture.name(),greenTea.getGreen_mixture());
        breverageIngredientMap.put("green_tea", hmap);
    }
}
