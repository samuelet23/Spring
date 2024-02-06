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

    private int numeroOrdine= generaNumero();
    private int numeroCoperti;

    private LocalDate oraAcquisione;
    private double importoTotale;

    private double costoCoperto;

//    public Ordine( ){
//
//    }

    public double calcolaOrdine(double costoCoperto){
       double sommaMenu =
               elementiMenu
                .stream()
                .mapToDouble(item -> item.getPrezzo())
                .sum();
        return sommaMenu + (numeroCoperti * costoCoperto);
    }


    private static int generaNumero(){
        int numero = 0;
        for (int i = 0; i < 100; i++) {
            numero = i++;
        }
        return numero;

    }
    @Override
    public String toString() {
        return "Ordine{" +
                ", statoOrdine=" + statoOrdine +
                ", numeroOrdine=" + numeroOrdine +
                ", numeroCoperti=" + numeroCoperti +
                ", oraAcquisione=" + oraAcquisione +
                ", importoTotale=" + importoTotale +
                ", costoCoperto=" + costoCoperto +
                '}';
    }
}
