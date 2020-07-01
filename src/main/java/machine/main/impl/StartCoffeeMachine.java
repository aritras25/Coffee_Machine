package machine.main.impl;
/* Author: Aritra Saha */

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.log4j.Logger;


@Component
public class StartCoffeeMachine {
    private static Logger logger = Logger.getLogger(StartCoffeeMachine.class);

    @Autowired
    private CoffeeMachineImplementation coffeeMachineImplementation;

    @PostConstruct
    public void jsonReader(){
        try {
            InputStream inputStream = this.getClass().getResourceAsStream("/Input3.json");
            String json = readFromInputStream(inputStream);
            coffeeMachineImplementation.useCoffeeMachine(json);
        }catch(IOException e){
            logger.error(e.getStackTrace());
        }
    }
    private String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
}
