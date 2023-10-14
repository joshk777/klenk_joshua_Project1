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

        //Initialize variables for user input.
        int updateMana = -1, updateHealth = -1;
        String newName, newSpell;

        //Creates a character object of the mage type.
        Mage myCharacter = new Mage("Jackal", 200, 100, "Firebolt");

        //Prints the hard coded information for the mage.
        System.out.printf("\n%-20s %-20s %-20s %-20s\n", "Character Name", "Total Health", "Total Mana", "Spell");
        System.out.printf("%-20s %-,20d %-,20d %-20s\n", myCharacter.getName(), myCharacter.getHealth(),
                myCharacter.getMana(), myCharacter.getSpell());

        //Gather user input for updating the mage object.
        System.out.print("\nUpdate Character Name: ");
        newName = keyboard.nextLine();
        myCharacter.setName(newName);

        System.out.print("\nUpdate new health value: ");
        updateHealth = keyboard.nextInt();
        myCharacter.setHealth(updateHealth);
        keyboard.nextLine();
            
        //Input validation for negative numbers.
        while(updateHealth < 0)
        {
            System.out.println("\nPlease enter a non negative number.");
            System.out.print("Update new health value: ");
            updateHealth = keyboard.nextInt();
            myCharacter.setHealth(updateHealth);
            keyboard.nextLine();
        }
        
        System.out.print("\nUpdate new mana value: ");
        updateMana = keyboard.nextInt();
        myCharacter.setMana(updateMana);
        keyboard.nextLine();
        
        //Input validation for negative numbers.
        while(updateMana < 0)
        {
            System.out.println("\nPlease enter a non negative number.");
            System.out.print("Update new mana value: ");
            updateMana = keyboard.nextInt();
            myCharacter.setMana(updateMana);
            keyboard.nextLine();
        }
        
        System.out.print("\nUpdate chosen spell: ");
        newSpell = keyboard.nextLine();
        myCharacter.setSpell(newSpell);
        System.out.println();

        //Print the updated results.
        System.out.printf("%-20s %-20s %-20s %-20s\n", "Character Name", "Total Health", "Total Mana", "Spell");
        System.out.printf("%-20s %-,20d %-,20d %-20s\n", myCharacter.getName(), myCharacter.getHealth(),
                myCharacter.getMana(), myCharacter.getSpell());

        keyboard.close();

    }
}
