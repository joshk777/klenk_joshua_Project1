package gamecharacter;

import java.util.Scanner;

/**
 * The GameCharacterDriver class allows users to interact with game characters,
 * adding them to a bag, removing them from the bag, finding characters in the bag,
 * and displaying the contents of the bag. It provides a command-line interface
 * to perform these operations and manage game characters.
 *
 * This class serves as the main entry point for the program and contains the
 * main method that drives the application.
 *
 @author Joshua Klenk
 @version 1.1
 */
public class GameCharacterDriver 
{

    public static void main(String[] args) 
    {

        Scanner keyboard = new Scanner(System.in);
        
        int exit = 0;
        
        String command, name, spell, nameToRemove, spellToRemove, nameToFind, spellToFind;
        int health, mana, healthToRemove, manaToRemove, healthToFind, manaToFind;

        LinkedBag<GameCharacter> gameCharacterBag = new LinkedBag<GameCharacter>();
        
        while(exit != -1)
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
                    System.out.print("Enter the mana points of the character: ");
                    mana = keyboard.nextInt();
                    System.out.print("Enter the spell to use: ");
                    spell = keyboard.next();
                    
                    Mage character = new Mage(name, health, mana,spell);
                    gameCharacterBag.add(character);
                    
                    System.out.println("\n" + name + " added to the bag." + "\nHealth set to: " + health + 
                                            "\nMana set to : " + mana + "\nSpell Chosen: " + spell + "\n");
                    break;
                case "R":
                    System.out.print("\nEnter the name of the character to remove: ");
                    nameToRemove = keyboard.next();
                    System.out.print("Enter the health points to remove: ");
                    healthToRemove = keyboard.nextInt();
                    System.out.print("Enter the mana points of the character to remove: ");
                    manaToRemove = keyboard.nextInt();
                    System.out.print("Enter the spell to remove: ");
                    spellToRemove = keyboard.next();
                    
                    Mage characterToRemove = new Mage(nameToRemove, healthToRemove, manaToRemove, spellToRemove);
                    
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
                    System.out.print("\nEnter the name of the character to find: ");
                    nameToFind = keyboard.next();
                    System.out.print("Enter the health points to find: ");
                    healthToFind = keyboard.nextInt();
                    System.out.print("Enter the mana points of the character to find: ");
                    manaToFind = keyboard.nextInt();
                    System.out.print("Enter the spell to find: ");
                    spellToFind = keyboard.next();
                    
                    Mage characterToFind = new Mage(nameToFind, healthToFind, manaToFind, spellToFind);
                    
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
                        System.out.println("Health Point: " + characterToDisplay.getHealth());
                        
                        if(characterToDisplay instanceof Mage)
                        {
                            Mage mageCharacterToDisplay = (Mage) characterToDisplay;
                            
                            System.out.println("Mana Points: " + mageCharacterToDisplay.getMana());
                            System.out.println("Spell: " + mageCharacterToDisplay.getSpell() + "\n");
                        }
                    }
                    System.out.println("\nBag Size: " + gameCharacterBag.getSize() + "\n");
                    }
                    else
                    {
                        System.out.print("Character Bag [--Empty--] \tSize: " + gameCharacterBag.getSize() + "\n");
                    }
                    break;
                case "X":
                    exit = -1;
                    System.out.println("Good-Bye");
                    break;
                default:
                    System.out.println("Invalid command. Please try again.\n");
            }
        }
        keyboard.close();
    }
}
