package machine.main.model;
/* Author: Aritra Saha */

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Component
public class Machine {
    private Outlets outlets;
    @JsonProperty("total_items_quantity")
    private TotalItemQuantity total_items_quantity;
    private Beverages beverages;

    public Outlets getOutlets() {
        return outlets;
    }

    public void setOutlets(Outlets outlets) {
        this.outlets = outlets;
    }

    public TotalItemQuantity getTotalItemQuantity() {
        return total_items_quantity;
    }

    public void setTotalItemQuantity(TotalItemQuantity totalItemQuantity) {
        this.total_items_quantity = totalItemQuantity;
    }

    public Beverages getBeverages() {
        return beverages;
    }

    public void setBeverages(Beverages beverages) {
        this.beverages = beverages;
    }
}
