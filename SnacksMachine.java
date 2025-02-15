package snacks_machine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnacksMachine {
    public static void main(String[] args) {
        snacksMachine();
    }

    public static void snacksMachine(){
        var exit = false;
        var console = new Scanner(System.in);
        //Create the list of products of gotten snacks
        List <Snack> products = new ArrayList<>();
        System.out.println(" *** SNACKS MACHINE ***");
        Snacks.showSnacks(); //SHOW AVAILABLE SNACKS
        while(!exit){
            try{
                var option = showMenu(console);
                exit = executeOptions(option, console, products);
            }catch(Exception e){
                System.out.println("A MISTAKE HAPPENED: "+ e.getMessage());
            }finally {
                System.out.println();
            }
        }
    }

    private static int showMenu(Scanner console){
        System.out.print("""
                Menu:
                1.- Buy Snack
                2.- See Ticket
                3.- Add Snack
                4.- Exit
                Choose an option : \s""");
        //Read and return option select
        return Integer.parseInt(console.nextLine());
    }

    private static boolean executeOptions(int option, Scanner console, List<Snack> products){
        var exit = false;
        switch(option){
            case 1 -> buySnack(console, products);
            case 2 -> seeTicket(products);
            case 3 -> addSnack(console);
            case 4 ->{
                System.out.println("THANKS FOR USING SNACK SYSTEM!");
                exit = true;
            }
            default -> System.out.println("Invalid Option: " + option);
        }
        return exit;
    }

    private static void buySnack(Scanner console, List<Snack> products){
        Snacks.showSnacks();
        System.out.print("Choose an snack (ID): ");
        var snackId = Integer.parseInt(console.nextLine());

        //Check that the snack exists:
        var snackFound = false;
        for (var snack : Snacks.getSnacks()){
            if(snackId == snack.getSnackID()){
                //Add snack to the procuct list
                products.add(snack);
                System.out.println("Snack Added: " + snack);
                snackFound = true;
                break;
            }
        }
        if(!snackFound)
            System.out.println("ID not found: " + snackId);
    }

    private static void seeTicket(List<Snack> products){
        var ticket = " *** SALES RECEIPT ***";
        var total = 0.0;
        for ( var product : products){
            ticket += "\n\t- " + product.getName() + " - $" + product.getPrice();
            total += product.getPrice();
        }
        ticket += "\n\tTotal -> $" + total;

        System.out.println(ticket);
    }

    private static void addSnack(Scanner console){
        System.out.print("Snack name: ");
        var name = console.nextLine();
        System.out.print("Snack price: ");
        var price = Double.parseDouble(console.nextLine());
        Snacks.addSnack(new Snack(name, price));
        System.out.println("New Snack Added Successfully");
        Snacks.showSnacks();
    }
}
