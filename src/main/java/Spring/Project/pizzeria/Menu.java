package Spring.Project.pizzeria;

import lombok.Data;

import java.util.List;

@Data
public class Menu {

    private List<Toppings> ingredienti;
    private List<Pizza> pizze;
    private List<Drinks> bibite;


    public void stampaMenu() {
        ingredienti.stream().forEach(toppings -> System.out.println("Ingrediente: " +toppings));
        pizze.stream().forEach(pizza -> System.out.println("Pizza: "+pizza));
        bibite.stream().forEach(b -> System.out.println("Bevanda: "+b));
    }
}
