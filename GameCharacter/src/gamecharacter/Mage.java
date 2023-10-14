package gamecharacter;

/**
 * The Mage class represents a specialized type of GameCharacter with magical abilities.
 * It extends the GameCharacter class and includes attributes and methods specific to mages.
 * 
 * @author Josh Klenk
 * @version 1.0
 */
public class Mage extends GameCharacter 
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
}
