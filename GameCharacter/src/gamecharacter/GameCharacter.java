package gamecharacter;

/**
 * The GameCharacter class represents a basic character with attributes such as name and health.
 * This class can be extended to create specialized character types.
 *@author Joshua Klenk
 *@version 1.0
 */
public class GameCharacter 
{

    private String characterName; //name of character.
    private int health; // The current health points of the character.

    /**
     *Constructs a basic character that receives a specific name and health points.
     *
     *Initializes the basic character information such as health & name.
     * @param newName name of the character being created.
     * @param initialHealth beginning health points.
     * 
     */
    public GameCharacter(String newName, int initialHealth) 
    {
        characterName = newName;
        health = initialHealth;

    }

    /**
     *Sets the name of the character.
     *
    @param newName The name to be assigned to the character.
     */
    public void setName(String newName) 
    {
        characterName = newName;
    }

    /**
     * Sets the health points of the character .
     *
    @param initialHealth The health points to be assigned to the character.
     */
    public void setHealth(int initialHealth) 
    {
        health = initialHealth;
    }

    /**
     * Retrieves the name of the character.
     *
    @return The name of the character as a string.
     */
    public String getName() 
    {
        return characterName;
    }

    /**
     * Returns the current health points of the character.
     *
    @return The current health points as an integer.
     */
    public int getHealth() 
    {
        return health;
    }
}
