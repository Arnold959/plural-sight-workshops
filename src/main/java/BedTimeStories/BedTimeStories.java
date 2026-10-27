package BedTimeStories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BedTimeStories {

    //Array containing the story filenames
    String[] stories={
            "goldilocks.txt",
            "hansel_and_gretel.txt",
            "mary_had_a_little_lamb.txt"
    };

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        //Create an object
        BedTimeStories bts = new BedTimeStories();
        //Display stories
        bts.showStories();
        //Ask user to select a story
        System.out.println("\nEnter the name of a story:");
        String fileName = scanner.next();
        bts.readStory(fileName);
        scanner.close();
    }


    //Method to display available stories
    public void showStories(){
        System.out.println("\nAvailable Stories");
        for (String story : stories) {
            System.out.println(story);
        }
    }
    //Method to read and print a story
    public void readStory(String fileName){

        int lineNumber = 1;
        boolean found = false;

        for (String story : stories) {
            if (story.equalsIgnoreCase(fileName)) {
                fileName = story;
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Please choose a valid story");
            return;
        }
        String filepath = fileName;
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(lineNumber + ". " + line);
                    lineNumber++;
                }


        } catch (IOException e){
            System.out.println("File not found!" + fileName);
            System.out.println(e.getMessage());
        }
    }


}

