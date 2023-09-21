package gamecharacter;

/**
*@author Joshua Klenk
*/

public class GameCharacter 
{
    
    //Character attributes
    private String characterName;
    private int health;
    private int maxHealth;
    
    /**
    *Constructor
    *
    *Initializes the basic character information such as health & name
     * @param newName name of the character being created
     * @param initialHealth beginning health points
     * @param maxHealth the maximum allowed health
    */
    public GameCharacter(String newName, int initialHealth, int maxHealth)
    {
        characterName = newName;
        health = initialHealth;
        maxHealth = 150;
    }
    
    /**
    *setName method allows the user to change their characters name
    @param newName sets the characters name
    */
    public void setName(String newName)
    {
        characterName = newName;
    }
    /**
    * setHealth method sets the characters health
    * and limits that health between a range of 0 - 150
    @param initialHealth characters health points
    */
    public void setHealth(int initialHealth)
    {
        if(health < 0)
        {
            health = 0;
        }
        else if(health >= maxHealth)
        {
            health = maxHealth;
        }
        else
        {
            health = initialHealth;
        }
    }
    
    /**
    * Returns the name of the character
    *
    @return the characters name
    */
    public String getName()
    {
      return characterName;  
    }
    
    /**
    * Returns the value of the characters health
    *
    @return the health of the character
    */
    public int getHealth()
    {
        return health;
    }
}
