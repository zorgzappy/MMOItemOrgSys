public class Item {
    /*
   Item values should be a distinct value type ie, each individual item. They don't classify new items, rather
   they are "copies" of an item from the ItemCategory class.
   NOTE: There are multiple duplication checks throughout this code. Generally speaking, some of these checks could
   be bypassed in this specific system BECAUSE there are no methods that are being constantly run that check for any
   dupplication. If there were checks being run every minute (probably want to make it a random time from 30 secs to
   2 minutes to prevent possible vulnerabilities) the system would most likely be sound.
     */

    //This number must match the itemCategoryID from the itemCategory class. Also helps to make sure each item is
    //properly located in the right ItemCategory
    private int ItemCategoryNum;

    //Unique num sequence assigned to this particular item. Should never be the same as any other item IN THE ITEMCATEGORY
    private int creationid;

    //This variable will be used in a actual game to determine where the item was acquired from. Since this is not a
    //entier MMO, this variable will just be a boolean value, since there is no methods of acquiring items in this
    // system.
    private boolean acquisition;


    private int rarity; // 1 = common, 2 = uncommon, 3 = rare, 4 = epic, 5 = legendary
    private int itemType; // 1 = weapon, 2 = Helmet, 3 = Robe, 4 = Boots, 5 = Consumable

    private int attack;

    private int defense;
    private int health;
    private int mana;



    public Item()
    {
        ItemCategoryNum = -1;
        creationid = -1;
        acquisition = true;
        rarity = 1;
        attack = 0;
        defense = 0;
        health = 0;
        mana = 0;
        itemType = 0;

    }

    public Item(int IC, int CI, boolean a, int r, int at, int de, int h, int m, int IT)
    {
        ItemCategoryNum = IC;
        creationid = CI;
        acquisition = a;
        rarity = r;
        attack = at;
        defense = de;
        health = h;
        mana = m;
        itemType = IT;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public int getItemType() {
        return itemType;
    }

    public int getCreationid() {
        return creationid;
    }

    public int getItemCategoryNum() {
        return ItemCategoryNum;
    }

    public boolean getAcquisition()
    {
        return acquisition;
    }

    public int getRarity()
    {
        return rarity;
    }

    public int getAttack()
    {
        return attack;
    }

    public int getDefense()
    {
        return defense;
    }

    public int getHealth()
    {
        return health;
    }

    public int getMana()
    {
        return mana;
    }

    public void setCreationid(int creationid) {
        this.creationid = creationid;
    }

    public void setItemCategoryNum(int ItemCategoryNum) {
        this.ItemCategoryNum = ItemCategoryNum;
    }

    public void setAcquisition(boolean acquisition)
    {
        this.acquisition = acquisition;
    }

    public void setRarity(int rarity)
    {
        this.rarity = rarity;
    }

    public void setAttack(int attack)
    {
        this.attack = attack;
    }

    public void setDefense(int defense)
    {
        this.defense = defense;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public void setMana(int mana)
    {
        this.mana = mana;
    }

public String toString()
    {
        String s = "";
        s += "Item Category Number: " + ItemCategoryNum + "\n";
        s += "Creation ID: " + creationid + "\n";
        s += "Acquisition: " + acquisition + "\n";
        s += "Rarity: " + rarity + "\n";
        s += "Attack: " + attack + "\n";
        s += "Defense: " + defense + "\n";
        s += "Health: " + health + "\n";
        s += "Mana: " + mana + "\n";
        s += "Item Type: " + itemType + "\n";
        return s;

    }

}
