package snacks_machine_files.service;

import snacks_machine_files.domain.Snack;

import java.util.ArrayList;
import java.util.List;

public class SnacksServiceList implements ISnacksService{
    private static final List<Snack> snacks;

    //Static Initializer Block
    static {
        snacks = new ArrayList<>();
        snacks.add(new Snack("CHIPS", 70));
        snacks.add(new Snack("SODA", 50));
        snacks.add(new Snack("SANDWICH", 120));
    }

    public void addSnack(Snack snack){
        snacks.add(snack);
    }

    public void showSnacks(){
        var snacksInventory = "";
        for(var snack : snacks){
            snacksInventory += snack.toString() + "\n";
        }
        System.out.println("---- Snacks in Inventory ---- \n" + snacksInventory);
    }

    public List<Snack> getSnacks(){
        return snacks;
    }
}
