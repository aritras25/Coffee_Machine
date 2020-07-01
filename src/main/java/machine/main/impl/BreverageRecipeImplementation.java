package machine.main.impl;
/* Author: Aritra Saha */

import machine.main.Constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class BreverageRecipeImplementation {
    @Autowired
    private IngredientRefill ingredientRefill;
    HashSet<String> refillItems = new HashSet<>();

    public void makeDrink(HashMap<String, Long> hMap, HashMap<String, HashMap<String, Long>> breverageIngredientMap, int noOfDispensers){
        ExecutorService executorService = Executors.newFixedThreadPool(noOfDispensers);
        Set<Callable<Boolean>> callables = new HashSet<Callable<Boolean>>();
        callables.add(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                boolean made = makeTea(hMap, breverageIngredientMap.get(Constants.HOT_TEA));
                if(made)
                    System.out.println("Hot_Tea is prepared");
                return made;
            }
        });

        callables.add(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                boolean made = makeCoffee(hMap, breverageIngredientMap.get(Constants.HOT_COFFEE));
                if(made)
                    System.out.println("Hot_Coffee is prepared");
                return made;
            }
        });

        callables.add(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                boolean made = makeBlackTea(hMap, breverageIngredientMap.get(Constants.BLACK_TEA));
                if(made)
                    System.out.println("Black_Tea is prepared");
                return made;
            }
        });

        callables.add(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                boolean made = makeGreenTea(hMap, breverageIngredientMap.get(Constants.GREEN_TEA));
                if(made)
                    System.out.println("Green_Tea is prepared");
                return made;
            }
        });

        try {
            executorService.invokeAll(callables);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        executorService.shutdown();
        ingredientRefill.refill(refillItems);
    }

    public boolean makeTea(HashMap<String, Long> hMap, HashMap<String, Long> hotTeaMap){
        for(Map.Entry<String, Long> map : hotTeaMap.entrySet()){
            String key = map.getKey();
            Long value = map.getValue();

            if(!hMap.containsKey(key.toLowerCase())){
                System.out.println("Hot Tea cannot be made as "+ key + " is not present");
                return false;
            }
            if(hMap.get(key) < value){
                System.out.println("Hot Tea cannot be prepared as "+ key +" Quantity is no sufficient");
                refillItems.add(key);
                return false;
            }else{
                hMap.put(key, hMap.get(key)- value);
            }
        }
        return true;
    }

    public boolean makeCoffee(HashMap<String, Long> hMap, HashMap<String, Long> hotTeaMap){
        for(Map.Entry<String, Long> map : hotTeaMap.entrySet()){
            String key = map.getKey();
            Long value = map.getValue();

            if(!hMap.containsKey(key.toLowerCase())){
                System.out.println("Hot Coffee cannot be made as "+ key + " is not present");
                return false;
            }
            if(hMap.get(key) < value){
                System.out.println("Hot Coffee cannot be prepared as "+ key +" Quantity is not sufficient");
                refillItems.add(key);
                return false;
            }else{
                hMap.put(key, hMap.get(key)- value);
            }
        }
        return true;
    }

    public boolean makeBlackTea(HashMap<String, Long> hMap, HashMap<String, Long> hotTeaMap){
        for(Map.Entry<String, Long> map : hotTeaMap.entrySet()){
            String key = map.getKey();
            Long value = map.getValue();

            if(!hMap.containsKey(key.toLowerCase())){
                System.out.println("Black Tea cannot be made as "+ key + " is not present");
                return false;
            }
            if(hMap.get(key) < value){
                System.out.println("Black Tea cannot be prepared as "+ key +" Quantity is not sufficient");
                refillItems.add(key);
                return false;
            }else{
                hMap.put(key, hMap.get(key)- value);
            }
        }
        return true;
    }

    public boolean makeGreenTea(HashMap<String, Long> hMap, HashMap<String, Long> hotTeaMap){
        for(Map.Entry<String, Long> map : hotTeaMap.entrySet()){
            String key = map.getKey();
            Long value = map.getValue();

            if(!hMap.containsKey(key.toLowerCase())){
                System.out.println("Green Tea cannot be made as "+ key + " is not present");
                return false;
            }
            if(hMap.get(key) < value){
                System.out.println("Green Tea cannot be prepared as "+ key +" Quantity is not sufficient");
                refillItems.add(key);
                return false;
            }else{
                hMap.put(key, hMap.get(key)- value);
            }
        }
        return true;
    }
}
