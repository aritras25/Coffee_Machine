package machine.main.impl;
/* Author: Aritra Saha */

import com.fasterxml.jackson.databind.ObjectMapper;
import machine.main.Constants.Constants;
import machine.main.model.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class CoffeeMachineImplementation {

    private static Logger logger = Logger.getLogger(CoffeeMachineImplementation.class);

    @Autowired
    private CoffeeMachine coffeeMachine;

    @Autowired
    private BreverageIngredientUsage breverageIngredientUsage;

    @Autowired
    private BreverageRecipeImplementation breverageRecipeImplementation;

    public void useCoffeeMachine(String json){
        ObjectMapper mapper = new ObjectMapper();
        try {
            coffeeMachine = mapper.readValue(json, CoffeeMachine.class);
            HashMap<String, Long> hMap = new HashMap<>();
            populateItemQuantity(coffeeMachine, hMap);
            int noOfDispensers = coffeeMachine.getMachine().getOutlets().getCount_n();
            HashMap<String, HashMap<String, Long>> breverageIngredientMap = new HashMap<>();
            breverageIngredientUsage.populateBreverageIngredientMap(coffeeMachine, breverageIngredientMap);
            breverageRecipeImplementation.makeDrink(hMap, breverageIngredientMap, noOfDispensers);
        } catch (IOException e) {
            logger.error(e.getStackTrace());
        }
    }

    public void populateItemQuantity( CoffeeMachine coffeeMachine, HashMap<String, Long> hMap){
        hMap.put("hot_water",coffeeMachine.getMachine().getTotalItemQuantity().getHot_water());
        hMap.put("hot_milk",coffeeMachine.getMachine().getTotalItemQuantity().getHot_milk());
        hMap.put("sugar_syrup",coffeeMachine.getMachine().getTotalItemQuantity().getSugar_syrup());
        hMap.put("ginger_syrup",coffeeMachine.getMachine().getTotalItemQuantity().getGinger_syrup());
        hMap.put("tea_leaves_syrup",coffeeMachine.getMachine().getTotalItemQuantity().getTea_leaves_syrup());
    }

}
