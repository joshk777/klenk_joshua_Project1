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
        
        String command, name, spell, nameToRemove, spellToRemove, nameToFind, spellToFind;
        int health, mana, healthToRemove, manaToRemove, healthToFind, manaToFind;

        LinkedBag<GameCharacter> gameCharacterBag = new LinkedBag<GameCharacter>();
        
        do
        {
            System.out.println("\nBag of GameCharacters\n");
            System.out.println("A - Add a character to the bag.");
            System.out.println("R - Remove a character from the bag.");
            System.out.println("F - Find a character in the bag.");
            System.out.println("D - Display contents of the bag.");
            System.out.println("X - Exit");
            System.out.print("Enter Selection: ");
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
                        System.out.println("\n" + nameToRemove + " with " + healthToRemove + " health, " + manaToRemove +
                                                " mana, and " + spellToRemove + " spell was removed from the bag.\n");
                    }
                    else
                    {
                        System.out.println("\n" + nameToRemove + " with " + healthToRemove + " health, " + manaToRemove +
                                                " mana, and " + spellToRemove + " spell was not removed!.\n");
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
                        System.out.println("\n" + nameToFind + " with " + healthToFind + " health, " + manaToFind +
                                                " mana, and " + spellToFind + " spell is in the bag.\n");
                    } 
                    else 
                    {
                        System.out.println("\n" + nameToFind + " with " + healthToFind + " health, " + manaToFind +
                                                " mana, and " + spellToFind + " spell is not in the bag.\n");
                    }
                    break;
                case "D":
                    
                    Lister<GameCharacter> iterator = gameCharacterBag.iterator();
                    
                    if(iterator.hasNext())
                    {
                    while(iterator.hasNext())
                    {
                        GameCharacter characterToDisplay = iterator.next();
                        
                        if(characterToDisplay instanceof Mage)
                        {
                            Mage mageCharacterToDisplay = (Mage) characterToDisplay;
                            
                            System.out.printf("[{Character Name: %s, Health: %d, Mana: %d, Spell: %s}], ", mageCharacterToDisplay.getName(), mageCharacterToDisplay.getHealth(), 
                                                            mageCharacterToDisplay.getMana(), mageCharacterToDisplay.getSpell());
                        }
                        else
                        {
                            System.out.printf("[{Character Name: %s, Health: %d}], ", 
                                                characterToDisplay.getName(), characterToDisplay.getHealth());
                        }
                    }
                    System.out.println("\nBag Size: " + gameCharacterBag.getSize() + "\n");
                    }
                    else
                    {
                        System.out.print("\nCharacter Bag [--Empty--] \tSize: " + gameCharacterBag.getSize() + "\n");
                    }
                    break;
                case "X":
                  
                    System.out.println("Good-Bye");
                    break;
                default:
                    System.out.println("\nInvalid Selection.\n");
            }
        }while(!command.equalsIgnoreCase("X"));
        keyboard.close();
    }
}
