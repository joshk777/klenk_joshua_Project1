package gamecharacter;

/**
 * The Mage class represents a specialized type of GameCharacter with magical abilities.
 * It extends the GameCharacter class and includes attributes and methods specific to mages.
 * 
 * @author Josh Klenk
 * @version 1.0
 */
public class Mage extends GameCharacter implements Comparable<GameCharacter>
{

    private String spell; // spell the mage can cast
    private int mana; // The mages mana points

    /**
    * Constructs a new Mage with specific name, health, mana, and spell
    *
    @param newName The name of the mage
    @param updateSpell The initial spell of the mage
    @param initialHealth The initial health points of the mage
    @param initialMana The initial mana points of the mage
    */
    public Mage(String newName, int initialHealth, int initialMana, String updateSpell) 
    {
        super(newName, initialHealth);

        spell = updateSpell;
        mana = initialMana;
    }
    
    /**
    * setSpell updates the mages equipped spell
    *
    @param updateSpell The new spell to equip
    */
    public void setSpell(String updateSpell) 
    {
        spell = updateSpell;
    }

    /**
    * setMana sets the mages mana points
    *
    @param initialMana The new mana point value
    */
    public void setMana(int initialMana) 
    {
        mana = initialMana;
    }

    /**
    * Retrieves the currently equipped spell
    *
    @return The current equipped spell
    */
    public String getSpell() 
    {
        return spell;
    }

    /**
    * Retrieves the current mana points
    *
    @return The current mana points
    */
    public int getMana() 
    {
        return mana;
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
    public int compareTo(Mage anotherCharacter) //throws ClassCastException
    {
        int spellComparison;

        if (!(anotherCharacter instanceof Mage)) 
        {
            throw new ClassCastException("GameCharacter pnject is expected.");
        }

        spellComparison = spell.compareToIgnoreCase(anotherCharacter.getSpell());

        if (spellComparison == 0) 
        {
            // If the names are equal, compare by health as a secondary criterion.
            if (getMana() < anotherCharacter.getMana()) 
            {
                return -1;
            } 
            else if (getMana() > anotherCharacter.getMana()) 
            {
                return 1;
            } 
            else 
            {
                return 0; // If spell and mana are equal, consider them equal.
            }
        } 
        else 
        {
            return spellComparison;
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
    public boolean equals(Object obj) throws ClassCastException 
    {
        if (!(obj instanceof Mage)) 
        {
            throw new ClassCastException("GameCharacter is expected");
        }

        Mage anotherCharacter = (Mage) obj;

        boolean isEqual = false;

        if (spell.equalsIgnoreCase(anotherCharacter.getSpell())
                && mana == anotherCharacter.getMana()) {
            isEqual = true;
        }

        return isEqual;
    }
}
