package gamecharacter;
/**
 * The Mage class represents a specialized type of GameCharacter with magical abilities.
 * It extends the GameCharacter class and includes attributes and methods specific to mages.
 * 
 * @author Josh Klenk
 * @version 1.1
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
    * Sets the spell of this Mage to the provided spell value.
    *
    * This method updates the spell attribute of the Mage to the given spell value.
    *
    * @param updateSpell The new spell to be assigned to the Mage.
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
    * Retrieves the current spell points of this Mage.
    *
    * This method returns the current spell of the Mage as an String.
    *
    * @return The current spell of the Mage.
    */
    public String getSpell() 
    {
        return spell;
    }

    /**
    * Retrieves the current mana points of this Mage.
    *
    * This method returns the current mana points of the Mage as an integer.
    *
    * @return The current mana points of the Mage.
    */
    public int getMana() 
    {
        return mana;
    }
    
    /**
    * Compares this Mage to another Mage based on their spell and mana attributes.
    *
    * This method is used to determine the relative order of two Mage objects. 
    * It first compares their spells in a case-insensitive manner. 
    * If the spells are equal, it then compares their mana values. 
    * If both the spell and mana values are equal,
    * the two Mages are considered equal.
    *
    * @param anotherCharacter The Mage object to compare to.
    * @return A negative integer if this Mage's spell is less than
    *         the other Mage's spell, a positive integer if it's greater, and if the
    *         spells are the same, it returns a negative integer if this Mage's mana is
    *         lower, a positive integer if it's higher, or 0 if both the spell and mana
    *         values are equal.
    * @throws ClassCastException if the provided object is not an instance of Mage.
    */
    public int compareTo(Mage anotherCharacter) throws ClassCastException
    {
        int spellComparison;

        if (!(anotherCharacter instanceof Mage)) 
        {
            throw new ClassCastException("GameCharacter pnject is expected.");
        }

        spellComparison = spell.compareToIgnoreCase(anotherCharacter.getSpell());

        if (spellComparison == 0) 
        {
            
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
                return 0; 
            }
        } 
        else 
        {
            return spellComparison;
        }
    }
    
    /**
     * Indicates whether some other object is "equal to" this GameCharacter. Two
     * Mage are considered equal if their character spells are the same
     * (case-insensitive) and their mana values are equal.
     *
     * @param obj The object to compare to this Mage.
     * @return true if the objects are equal, false otherwise.
     * @throws ClassCastException if the provided object is not an instance of
     * Mage.
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
