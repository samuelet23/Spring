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
        System.out.println("Menu Pizzeria");
        Menu menu = ctx.getBean("menu", Menu.class);
//        menu.stampaMenu();

        Ordine ordine1 = ctx.getBean("ordine", Ordine.class);
        Tavolo tavolo1 = ctx.getBean("tavolo", Tavolo.class);

        try{
        infoLogger.info(String.valueOf(ordine1));
        tavolo1.setStato(StatoTavolo.OCCUPATO);
        }catch (Exception e){
            errorLogger.error(e.getMessage());
        }

            ordine1.setStatoOrdine(StatoOrdine.PRONTO);
            infoLogger.info("L'ordine è pronto");

            ordine1.setStatoOrdine(StatoOrdine.SERVITO);
            infoLogger.info("L'ordine è stato servito");

            tavolo1.setStato(StatoTavolo.LIBERO);
            infoLogger.info("IL tavolo è libero");


    }





}
