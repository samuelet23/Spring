package Spring.Project.pizzeria;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Data
@Component
public class Tavolo {

    private int numeroTavolo;
    private int numeroCopertiMassimo;
    private StatoTavolo stato;


}
