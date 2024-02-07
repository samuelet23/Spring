package Spring.Project.pizzeria;

import lombok.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;


@Data
@Component("ordine")
public class Ordine {

    private List<Item> elementiMenu;

    private StatoOrdine statoOrdine;

    private int numeroOrdine;
    private int numeroCoperti;

    private LocalDate oraAcquisione;
    private double importoTotale;


    public Ordine(Tavolo tavolo){
        if (numeroCoperti <= tavolo.getNumeroCopertiMassimo()) {
            numeroCoperti = getNumeroCoperti();
        }else {
            System.out.println("errore: i coperti sono superiore al numero massimo presente nel tavolo");
        }
    }

    public double calcolaOrdine(double costoCoperto){
       double sommaMenu =
               elementiMenu
                .stream()
                .mapToDouble(item -> item.getPrezzo())
                .sum();
        return sommaMenu + (numeroCoperti * costoCoperto);
    }

    @Override
    public String toString() {
        return "Ordine{" +
                ", statoOrdine=" + statoOrdine +
                ", numeroOrdine=" + numeroOrdine +
                ", numeroCoperti=" + numeroCoperti +
                ", oraAcquisione=" + oraAcquisione +
                ", importoTotale=" + importoTotale +
                '}';
    }
}
