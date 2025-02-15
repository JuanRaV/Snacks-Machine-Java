package snacks_machine_files.service;

import snacks_machine_files.domain.Snack;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class SnacksServiceFile implements ISnacksService{
    private final String FILE_NAME = "snacks.txt";
    //Create the snacks list
    private List<Snack> snacks = new ArrayList<>();

    //Constructor
    public SnacksServiceFile(){
        //Create file
        var file = new File(FILE_NAME);
        var exists = false;

        try{
            exists = file.exists();


            if(exists){
                //If exists, load the data that we have in this file
//                this.snacks = getSnacksFromFile();
            }
            else{
                //Create new file
                var exit = new PrintWriter(new FileWriter(file));
                exit.close(); //Save the file on disk
                System.out.println("File created successfully");
            }
        } catch (Exception e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
        //If the file didn't exist, this file will be empty so we load some elements on it
        if(!exists){
            uploadInitialSnacks();
        }

    }

    private void uploadInitialSnacks(){
        this.addSnack(new Snack("CHIPS", 55.0));
        this.addSnack(new Snack("SODA", 35.0));
        this.addSnack(new Snack("SANDWICH", 130.0));
    }

    @Override
    public void addSnack(Snack snack) {
        //Add new snack
        //1.- Add to memory list
        snacks.add(snack);
        //2.- Add to file
        this.addSnackFile(snack);
    }

    private void addSnackFile(Snack snack){
        boolean append = false;
        var file = new File(FILE_NAME);
        try{
            //This line will decide if we will overwrite the file or append
            append = file.exists();
            var exit = new PrintWriter(new FileWriter(file,append));
            exit.println(snack.writeSnackToFile());
            exit.close(); //Write the info in the file
        } catch (Exception e) {
            System.out.println("ERROR ADDING SNACK" + e.getMessage());
        }
    }

    @Override
    public void showSnacks() {

    }

    @Override
    public List<Snack> getSnacks() {
        return List.of();
    }
}
