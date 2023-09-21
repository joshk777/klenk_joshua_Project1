package gamecharacter;

import java.util.Scanner;
/**
 * @author Joshua Klenk
 */

public class GameCharacterDriver 
{
    public static void main(String[] args) 
    {
        //instantiate the scanner object for user input
        Scanner keyboard = new Scanner(System.in);
        
        //initialize variables for user input
        int updateMana,updateHealth;
        String newName, newSpell;
        
        //creates a character object of the mage type
        Mage myCharacter = new Mage("Jackal", 200, 100, "Firebolt");

        //prints the hard coded information for the mage
        System.out.printf("\n%-20s %-20s %-20s %-20s\n", "Character Name", "Total Health", "Total Mana", "Spell");
        System.out.printf("%-20s %-,20d %-,20d %-20s\n", myCharacter.getName(), myCharacter.getHealth(), 
                myCharacter.getMana(), myCharacter.getSpell());
        
        //gather user input for updating the mage object
        System.out.print("\nUpdate Character Name: ");
        newName = keyboard.nextLine();
        myCharacter.setName(newName);
        
        System.out.print("\nUpdate new health value: ");
        updateHealth = keyboard.nextInt();
        myCharacter.setHealth(updateHealth);
        keyboard.nextLine();
        
        System.out.print("\nUpdate new mana value: ");
        updateMana = keyboard.nextInt();
        myCharacter.setMana(updateMana);
        keyboard.nextLine();
        
        System.out.print("\nUpdate chosen spell: ");
        newSpell = keyboard.nextLine();
        myCharacter.setSpell(newSpell);
        System.out.println();

        //print the updated results
        System.out.printf("\n%-20s %-20s %-20s %-20s\n", "Character Name", "Total Health", "Total Mana", "Spell");
        System.out.printf("%-20s %-,20d %-,20d %-20s\n", myCharacter.getName(), myCharacter.getHealth(), 
                myCharacter.getMana(), myCharacter.getSpell());
        
        keyboard.close();
        
    } 
}
