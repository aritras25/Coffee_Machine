package machine.main.model;
/* Author: Aritra Saha */

import org.springframework.stereotype.Component;

@Component
public class CoffeeMachine {
    private Machine machine;

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }
}
