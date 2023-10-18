package gamecharacter;

/**
 * The GameCharacter class represents a basic character with attributes such as name and health.
 * This class can be extended to create specialized character types.
 *@author Joshua Klenk
 *@version 1.1
 */
public class GameCharacter implements Comparable<GameCharacter>
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
    
    /**
    * Compares this GameCharacter to another GameCharacter based on their health and character name.
    *
    @param anotherCharacter the GameCharacter to compare to.
    @return -1 if this character has less health, 1 if this character has more health, or the result of characterName comparison.
    @throws ClassCastException 
    */
    @Override
    public int compareTo(GameCharacter anotherCharacter) throws ClassCastException
    {
        int returnValue;
        
        if(!(anotherCharacter instanceof GameCharacter))
        {
            throw new ClassCastException("GameCharacter pnject is expected.");
        }
        
        if(getHealth() < anotherCharacter.getHealth())
        {
            returnValue = -1;
        }
        else if(getHealth() > anotherCharacter.getHealth())
        {
            returnValue = 1;
        }
        else
        {
            returnValue = characterName.compareToIgnoreCase(anotherCharacter.getName());
        }
        
        return returnValue;
    }
    
    /**
     * Indicates whether some other object is "equal to" this GameCharacter.
     * Two GameCharacters are considered equal if their character names are the same (case-insensitive)
     * and their health values are equal.
     *
     * @param obj The object to compare to this GameCharacter.
     * @return true if the objects are equal, false otherwise.
     * @throws ClassCastException if the provided object is not an instance of GameCharacter.
     */
    @Override
    public boolean equals(Object obj) throws ClassCastException
    {
        if(!(obj instanceof GameCharacter))
        {
        throw new ClassCastException("GameCharacter is expected");
        }
        
        GameCharacter anotherCharacter = (GameCharacter) obj;
        
        boolean isEqual = false;
        
        if(characterName.equalsIgnoreCase(anotherCharacter.getName()) 
                && health == anotherCharacter.getHealth())
        {
            isEqual = true;
        }
        
        return isEqual;
    }
}
