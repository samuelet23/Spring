package Spring.Project.pizzeria;

import lombok.Data;

@Data
public class Item {

    private String nome;
    private double informazioniNutrizionali;
    private double prezzo;


    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", informazioniNutrizionali=" + informazioniNutrizionali +
                ", prezzo=" + prezzo +
                '}';
    }
}
