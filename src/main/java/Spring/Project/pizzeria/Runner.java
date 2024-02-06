package Spring.Project.pizzeria;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private static final Logger errorLogger =  LoggerFactory.getLogger("main_error");
    private static final Logger infoLogger =  LoggerFactory.getLogger("main_info");

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PizzeriaApplication.class);
        Tavolo tavolo1 = new Tavolo();
        System.out.println("Menu Pizzeria");
        Menu menu = ctx.getBean("menu", Menu.class);
//        menu.stampaMenu();


        try{
        Ordine ordine1 = ctx.getBean("ordine", Ordine.class);
        infoLogger.info(String.valueOf(ordine1));
        }catch (Exception e){
            errorLogger.error(e.getMessage());
        }
    }





}
