package Spring.Project.pizzeria;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component("pizza")
public class Pizza extends Item{

    private List<Toppings> ingredienti;

    @Override
    public String toString() {
        return "Pizza{" + super.toString() +
                "ingredienti=" + ingredienti +
                '}';
    }
}
