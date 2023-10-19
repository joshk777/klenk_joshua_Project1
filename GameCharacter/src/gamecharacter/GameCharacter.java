package gamecharacter;

/**
 * The GameCharacter class represents a basic character with attributes such as
 * name and health. This class can be extended to create specialized character
 * types.
 *
 * @author Joshua Klenk
 * @version 1.1
 */
public class GameCharacter implements Comparable<GameCharacter> 
{

    private String characterName; //name of character.
    private int health; // The current health points of the character.

    /**
     * Constructs a basic character that receives a specific name and health
     * points.
     *
     * Initializes the basic character information such as health & name.
     *
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
     * Sets the name of the character.
     *
     * @param newName The name to be assigned to the character.
     */
    public void setName(String newName) 
    {
        characterName = newName;
    }

    /**
     * Sets the health points of the character .
     *
     * @param initialHealth The health points to be assigned to the character.
     */
    public void setHealth(int initialHealth) 
    {
        health = initialHealth;
    }

    /**
     * Retrieves the name of the character.
     *
     * @return The name of the character as a string.
     */
    public String getName() 
    {
        return characterName;
    }

    /**
     * Returns the current health points of the character.
     *
     * @return The current health points as an integer.
     */
    public int getHealth() 
    {
        return health;
    }

    /**
    * Compares this GameCharacter to another GameCharacter based on their name and health.
    *
    * @param anotherCharacter The GameCharacter to compare to.
    * @return A negative integer if this character's name is less than anotherCharacter's name,
    *         a positive integer if this character's name is greater,
    *         and if the names are the same, it returns a negative integer if this character's health is lower,
    *         a positive integer if this character's health is higher, or 0 if both names and health are equal.
    * @throws ClassCastException if the provided object is not an instance of GameCharacter.
    */
    @Override
    public int compareTo(GameCharacter anotherCharacter) //throws ClassCastException
    {
        int nameComparison;

        if (!(anotherCharacter instanceof GameCharacter)) 
        {
            throw new ClassCastException("GameCharacter pnject is expected.");
        }

        nameComparison = characterName.compareToIgnoreCase(anotherCharacter.getName());

        if (nameComparison == 0) 
        {
            // If the names are equal, compare by health as a secondary criterion.
            if (getHealth() < anotherCharacter.getHealth()) 
            {
                return -1;
            } 
            else if (getHealth() > anotherCharacter.getHealth()) 
            {
                return 1;
            } 
            else 
            {
                return 0; // If names and health are equal, consider them equal.
            }
        } 
        else 
        {
            return nameComparison;
        }
    }

    /**
     * Indicates whether some other object is "equal to" this GameCharacter. Two
     * GameCharacters are considered equal if their character names are the same
     * (case-insensitive) and their health values are equal.
     *
     * @param obj The object to compare to this GameCharacter.
     * @return true if the objects are equal, false otherwise.
     * @throws ClassCastException if the provided object is not an instance of
     * GameCharacter.
     */
    @Override
    public boolean equals(Object obj) throws ClassCastException {
        if (!(obj instanceof GameCharacter)) {
            throw new ClassCastException("GameCharacter is expected");
        }

        GameCharacter anotherCharacter = (GameCharacter) obj;

        boolean isEqual = false;

        if (characterName.equalsIgnoreCase(anotherCharacter.getName())
                && health == anotherCharacter.getHealth()) {
            isEqual = true;
        }

        return isEqual;
    }
}
