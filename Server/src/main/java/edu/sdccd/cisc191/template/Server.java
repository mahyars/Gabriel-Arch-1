package edu.sdccd.cisc191.template;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;


/**
 * This program is a server that takes connection requests on
 * the port specified by the constant LISTENING_PORT.  When a
 * connection is opened, the program sends the current time to
 * the connected socket.  The program will continue to receive
 * and process connections until it is killed (by a CONTROL-C,
 * for example).  Note that this server processes each connection
 * as it is received, rather than creating a separate thread
 * to process the connection.
 */
// Course Objectives: Module 2-6

// creates class that extends "Application" to access Javafx imports
public class Server extends Application  {

    /*I would avoid using magic numbers in the code, such as 300 and 250
        when creating the Scene in the Server class.
        Instead, declare constants at the beginning of the class to give those numbers
        meaningful names.*/
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_HEIGHT = 250;
    //Creates buttons for events later on
    Button showMenu;
    Button burgerFood;
    Button pizzaFood;
    Button cokeDrink;
    Button spriteDrink;

    public static void main(String[] args) {
        // Launches Javafx GUI
        launch(args);

    }
    //Method that prints the Menu in console for user
    public boolean printMenu(){
        //Creates a String 2-dimensional array with menu contents
        String [][] arrayTwo = {{" Burger == $5.99", " Pizza == $7.99"},{" Coke == $0.99", " Sprite == $0.99"}};
        System.out.println( "===============Menu===============");
        //Outer loop to increment Row
        for (int i = 0; i < arrayTwo.length; i++) {
            //Inner loop to increment Column and prints each item
            for (int j = 0; j < arrayTwo[i].length; j++) {
                System.out.print(arrayTwo[i][j]);
                // creates space in between items
                if (j < arrayTwo[i].length - 1) {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
        System.out.println( "==================================");
       return true;
    }
    // Method that contains all contents of the stage, and starts it
    @Override
    public void start(Stage primaryStage) throws Exception {

// Sets stage name title

        primaryStage.setTitle("Food Menu");
        // Creates button objects for event handling, and also labels the buttons in the parameter
        showMenu = new Button("Show Menu");
        burgerFood = new Button("Purchase Burger");
        pizzaFood = new Button("Purchase Pizza");
        cokeDrink = new Button("Purchase Coke");
        spriteDrink = new Button("Purchase Sprite");
        //Creates objects from specified classes
        Burger b = new Burger();
        Pizza p = new Pizza();
        Coke c = new Coke();
        Sprite s = new Sprite();

        // Using Lambdas notation sets an action event that does a event based on the object method
        showMenu.setOnAction( e -> printMenu());
        burgerFood.setOnAction ( e -> b.receipt());
        pizzaFood.setOnAction ( e -> p.receipt());
        cokeDrink.setOnAction ( e -> c.receipt());
        spriteDrink.setOnAction ( e -> s.receipt());

        //Created VBox object
        VBox foodLeft = new VBox();
        // Takes children(button) into the VBox
        foodLeft.getChildren().addAll(burgerFood, pizzaFood);
        //Creates another VBox object
        VBox drinkRight = new VBox();
        // Takes children(button) into the VBox
        drinkRight.getChildren().addAll(cokeDrink, spriteDrink);

        // Creates BorderPane Object to place buttons in the specified place
        BorderPane borderPane = new BorderPane();
        //Sets the set of buttons in object foodLeft on the Left hand side
         borderPane.setLeft(foodLeft);
        //Sets the set of buttons in object drinkRight  on the right hand side
         borderPane.setRight(drinkRight);
         // Sets the showMenu button on the center
         borderPane.setCenter(showMenu);

         // Creates a scene where all the buttons are placed
        Scene scene = new Scene(borderPane,  WINDOW_WIDTH, WINDOW_HEIGHT);
        primaryStage.setScene(scene);
        // Displays the stage to its users
        primaryStage.show();

    }
}