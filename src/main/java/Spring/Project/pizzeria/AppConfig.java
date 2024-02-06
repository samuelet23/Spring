package Spring.Project.pizzeria;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.image.PixelGrabber;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean("prosciutto")
    public Toppings prosciutto(){
        return genereteToppings("Prosciutto", 10.5, 2.0);
    }
    @Bean("salsiccia")
    public Toppings salsiccia(){
        return genereteToppings("Salsiccia", 40.2, 3.5);
    }
    @Bean("patate")
    public Toppings patate(){
        return  genereteToppings("patate", 38.2, 3.0);
    }
    @Bean("pomodoro")
    public Toppings pomodoro(){
       return genereteToppings("pomodoro", 30.2, 2.0);
    }
    @Bean("mozzarella")
    public Toppings mozzarella(){
        return  genereteToppings("mozzarella", 20.3, 2.0);
    }
    @Bean("margherita")
    public Pizza margherita(){
        Pizza margherita = generatePizza("margherita", 5.2, 100.2);
        margherita.setIngredienti(List.of(mozzarella(), pomodoro()));
        return margherita;
    }

    @Bean("montagna")
    public Pizza montagna(){
        Pizza montagna = generatePizza("Montagna", 8.7, 180.2);
        montagna.setIngredienti(List.of(salsiccia(), patate()));
        return  montagna;
    }


    @Bean("acqua")
    public Drinks acqua(){
        return generateDrinks("Acqua", 0.0, 2.5);
    }

    @Bean("CocaCola")
    public Drinks coca(){
        return generateDrinks("CocaCola", 20.3, 3.5);
    }


    @Bean("menu")
    public Menu menu(){
        Menu menu = new Menu();
        menu.setPizze(List.of(margherita(), montagna()));
        menu.setBibite(List.of(acqua(), coca()));
        menu.setIngredienti(List.of(mozzarella(), pomodoro(), patate(), salsiccia(), prosciutto()));
        return menu;
    }





    private Drinks generateDrinks(String nome, double informazioni, double prezzo){
        Drinks drinks = new Drinks();
        drinks.setNome(nome);
        drinks.setInformazioniNutrizionali(informazioni);
        drinks.setPrezzo(prezzo);
        return drinks;
    }

    private Pizza generatePizza(String nomePizza, double prezzo, double informazioni){
        Pizza pizza = new Pizza();
        pizza.setNome(nomePizza);
        pizza.setPrezzo(prezzo);
        pizza.setInformazioniNutrizionali(informazioni);
        return pizza;
    }
    private Toppings genereteToppings(String ingrediente, double informazioni, Double prezzo){
        Toppings toppings = new Toppings();
        toppings.setNome(ingrediente);
        toppings.setInformazioniNutrizionali(informazioni);
        toppings.setPrezzo(prezzo);
        return toppings;
    }


}
