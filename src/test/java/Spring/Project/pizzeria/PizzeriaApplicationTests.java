package Spring.Project.pizzeria;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Array;
import java.util.List;

@SpringBootTest
class PizzeriaApplicationTests {
	static AnnotationConfigApplicationContext ctx;

	@BeforeAll
	static void avviaContext() {
		ctx = new AnnotationConfigApplicationContext(PizzeriaApplication.class);
	}

	@Test
	void checkNumeroCoperti() {

		Ordine ordine = ctx.getBean("ordine", Ordine.class);
		Tavolo tavolo = ctx.getBean("tavolo", Tavolo.class);
		Assertions.assertTrue(ordine.getNumeroCoperti() <= tavolo.getNumeroCopertiMassimo()&&ordine.getNumeroCoperti()>= 0);
	}
	@Test
	void checkPomodoroIsNotNull(){
		Toppings pomodoro = ctx.getBean("pomodoro", Toppings.class);
		Assertions.assertNotNull(pomodoro);
	}
	@Test
	void checkMozzarellaIsNotNull(){
		Toppings mozzarella = ctx.getBean("mozzarella", Toppings.class);
		Assertions.assertNotNull(mozzarella);
	}
	@Test
	void checkPizzaMargherita(){
		Pizza margherita = ctx.getBean("margherita", Pizza.class);
	Toppings pomodoro = ctx.getBean("pomodoro", Toppings.class);
	Toppings mozzarella = ctx.getBean("mozzarella", Toppings.class);
		margherita.getIngredienti().toArray();
	List<Toppings> listaToppings = List.of(mozzarella, pomodoro);
		Assertions.assertArrayEquals(listaToppings.toArray() ,margherita.getIngredienti().toArray());
}


	@ParameterizedTest
	@CsvSource({"Acqua, 0.0","CocaCola, 20.0", "Salsiccia, 40.2"})
	void checkNomeCalorie(String nome, double calorie) {
		Item elemento = null;

		if (nome.equals("Acqua")) {
			elemento = ctx.getBean("acqua", Drinks.class);
		} else if (nome.equals("CocaCola")) {
			elemento = ctx.getBean("CocaCola", Drinks.class);
		}else if (nome.equals("Salsiccia")) {
			elemento =ctx.getBean("salsiccia",Toppings.class);
		}

		Assertions.assertNotNull(elemento);
		Assertions.assertEquals(calorie, elemento.getInformazioniNutrizionali());

		Assertions.assertEquals(calorie, elemento.getInformazioniNutrizionali());
	}




@AfterAll
	static void chiudiContext() {
		ctx.close();
	}
}