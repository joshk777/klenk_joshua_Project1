package gamecharacter;

import java.util.Scanner;

/**
 *The Game Character driver is a driver program for creating and interacting with
 *various characters
 *
 * @author Joshua Klenk
 *@version 1.0
 */
public class GameCharacterDriver 
{

    public static void main(String[] args) 
    {
        //Instantiate the scanner object for user input.
        Scanner keyboard = new Scanner(System.in);
        
        boolean exit = false;
        String command, name, nameToRemove, nameToFind;
        int health, healthToRemove, healthToFind;

        LinkedBag<GameCharacter> gameCharacterBag = new LinkedBag<GameCharacter>(); // creates a linked bag
        
        while(!exit)
        {
            System.out.println("Bag of GameCharacters");
            System.out.println("Menus:");
            System.out.println("A - Add a character to the bag.");
            System.out.println("R - Remove a character from the bag.");
            System.out.println("F - Find a character in the bag.");
            System.out.println("D - Display contents of the bag.");
            System.out.println("X - Exit");
            
            command = keyboard.next().toUpperCase();
            
            switch(command)
            {
                case "A":
                    System.out.print("\nEnter the name of the character: ");
                    name = keyboard.next();
                    System.out.print("Enter the health points: ");
                    health = keyboard.nextInt();
                    
                    GameCharacter character = new GameCharacter(name, health);
                    gameCharacterBag.add(character);
                    
                    System.out.println(name + " added to the bag. Health set to: " + health + "\n");
                    break;
                case "R":
                    System.out.print("\nEnter the characters name to remove: ");
                    nameToRemove = keyboard.next();
                    System.out.print("Enter the characters health to remove: ");
                    healthToRemove = keyboard.nextInt();
                    
                    GameCharacter characterToRemove = new GameCharacter(nameToRemove, healthToRemove);
                    
                    if(gameCharacterBag.remove(characterToRemove))
                    {
                        System.out.println(nameToRemove + "removed from the bag.\n");
                    }
                    else
                    {
                        System.out.println(nameToRemove + " not found in the bag.\n");
                    }
                    break;
                case "F":
                    System.out.print("\nEnter the character's name to find: ");
                    nameToFind = keyboard.next();
                    System.out.print("Enter the character's health to find: ");
                    healthToFind = keyboard.nextInt();

                    GameCharacter characterToFind = new GameCharacter(nameToFind, healthToFind);
                    if (gameCharacterBag.exists(characterToFind)) 
                    {
                        System.out.println(nameToFind + " exists in the bag.\n");
                    } 
                    else 
                    {
                        System.out.println(nameToFind + " does not exist in the bag.\n");
                    }
                    break;
                case "D":
                    System.out.println("\nBag contents:");
                    Lister<GameCharacter> iterator = gameCharacterBag.iterator();
                    
                    if(iterator.hasNext())
                    {
                    while(iterator.hasNext())
                    {
                        GameCharacter characterToDisplay = iterator.next();
                        System.out.println("\nCharacter Name: " + characterToDisplay.getName());
                        System.out.println("Health Point: " + characterToDisplay.getHealth() + "\n");
                    }
                    System.out.println("\nBag Size: " + gameCharacterBag.getSize() + "\n");
                    }
                    else
                    {
                        System.out.print("Character Bag [--Empty--] \tSize: " + gameCharacterBag.getSize() + "\n");
                    }
                    break;
                case "X":
                    exit = true;
                    System.out.println("Good-Bye");
                    break;
                default:
                    System.out.println("Invalid command. Please try again.\n");
            }
        }
        keyboard.close();
    }
}
