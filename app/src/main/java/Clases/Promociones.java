package Clases;

import androidx.appcompat.app.AppCompatActivity;

public class Promociones extends AppCompatActivity {

    private int pizzasPromo;
    private int masterPizza;
    private int pizzaMax;

    public Promociones() {

        pizzasPromo = 5990;
        masterPizza = 12990;
        pizzaMax = 18500;
    }

    public int getPizzaPromo() {
        return pizzasPromo;
    }

    public int getMasterPizza() {
        return masterPizza;
    }

    public int getPizzaMax() {
        return pizzaMax;
    }
}
