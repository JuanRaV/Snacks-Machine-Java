package snacks_machine;

import java.util.ArrayList;
import java.util.List;

public class Snacks {
    private static final List<Snack> snacks;

    //Static Initializer Block
    static {
        snacks = new ArrayList<>();
        snacks.add(new Snack("CHIPS", 70));
        snacks.add(new Snack("SODA", 50));
        snacks.add(new Snack("SANDWICH", 120));
    }

    public static void addSnack(Snack snack){
        snacks.add(snack);
    }

    public static void showSnacks(){
        var snacksInventory = "";
        for(var snack : snacks){
            snacksInventory += snack.toString() + "\n";
        }
        System.out.println("---- Snacks in Inventory ---- \n" + snacksInventory);
    }

    public static List<Snack> getSnacks(){
        return snacks;
    }
}
