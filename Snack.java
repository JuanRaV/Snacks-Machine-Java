package snacks_machine;

import java.io.Serializable;
import java.util.Objects;

public class Snack implements Serializable {
    private static int snackCount = 0;
    private int snackID;
    private String name;
    private double price;

    public Snack(){
        this.snackID = ++Snack.snackCount;
    }

    public Snack(String name, double price){
        this(); //Call empty constructor, MUST BE THE 1ST LINE
        this.name = name;
        this.price = price;
    }

    public static int getSnackCount() {
        return snackCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSnackID() {
        return snackID;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "snackID=" + snackID +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Snack snack = (Snack) o;
        return snackID == snack.snackID && Double.compare(price, snack.price) == 0 && Objects.equals(name, snack.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(snackID, name, price);
    }
}
