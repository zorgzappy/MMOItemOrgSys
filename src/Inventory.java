//This will be the Inventory of a player, which will also be used by the GUI class to display what items a player has in their inventory at all times.

public class Inventory {
    private final int MAX_ITEMS = 20;
    private final int MAX_EQUIPPED = 4;
    private ItemCategoryList itemCategoryList;


    private Item[] equipped = new Item[MAX_EQUIPPED];
    private int quantityEquipped;
    private Item[] items;
    private int quantityItems;
    private int totalAttack;
    private int totalDefense;
    private int totalHealth;
    private int totalMana;

    //generate setters and getters for totalAttack, totalDefense, totalHealth, and totalMana
    public void setTotalAttack(int totalAttack) {
        this.totalAttack = totalAttack;
    }
    public int getTotalAttack() {
        return totalAttack;
    }
    public void setTotalDefense(int totalDefense) {
        this.totalDefense = totalDefense;
    }
    public int getTotalDefense() {
        return totalDefense;
    }

    public void setTotalHealth(int totalHealth) {
        this.totalHealth = totalHealth;
    }

    public int getTotalHealth() {
        return totalHealth;
    }

    public void setTotalMana(int totalMana) {
        this.totalMana = totalMana;
    }

    public int getTotalMana() {
        return totalMana;
    }



public Inventory()
{
    quantityItems = 0;
    items = new Item[MAX_ITEMS];
    quantityEquipped = 0;
    equipped = new Item[MAX_EQUIPPED];
    itemCategoryList = new ItemCategoryList();
    totalAttack = 0;
    totalDefense = 0;
    totalHealth = 0;
    totalMana = 0;


}

public void setItemCategoryList(ItemCategoryList itemCategoryList) {
    this.itemCategoryList = itemCategoryList;
}
public ItemCategoryList getItemCategoryList() {
    return itemCategoryList;
}

    public void setEquipped(Item[] equipped) {
        this.equipped = equipped;
    }

    public Item[] getEquipped() {
        return equipped;
    }

    public void setQuantityEquipped(int quantity) {
        this.quantityEquipped = quantity;
    }

    public int getQuantityEquipped() {
        return quantityEquipped;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public Item[] getItems() {
        return items;
}

    public void setQuantityItems(int quantity) {
        this.quantityItems = quantity;
    }

    public int getQuantityItems() {
        return quantityItems;
    }



    //One method this needs is a pickup method, where the person will randomly pick up an item from "the ground".
    public Item pickUp()
    {
        if (quantityItems != MAX_ITEMS)
        {


            int rarity = (int)(Math.random() * 5)+1;
            int itemType = (int)(Math.random() * 5)+1;
            //Need to add to correct ItemCategoryList
            Item item = new Item();
            if (rarity == 1) {
                //common
                if (itemType != 5) {


                    int attack = (int) (Math.random() * 5) + 1;
                    int defense = (int) (Math.random() * 5) + 1;
                    int health = (int) (Math.random() * 5) + 1;
                    int mana = (int) (Math.random() * 5) + 1;
                     item = new Item(-1, -1, true,rarity, attack, defense, health, mana, itemType);
                    itemCategoryList.addItem(item);


                } else {
                    int attack = 5;
                    int defense = 5;
                    int health = 5;
                    int mana = 5;
                     item = new Item(-1, -1, true,rarity,attack, defense, health, mana, itemType );
                    itemCategoryList.addItem(item);


                }
            }
            else if (rarity == 2)
            {
                //uncommon
                if (itemType !=5) {
                    int attack = (int) (Math.random() * 10) + 2;
                    int defense = (int) (Math.random() * 10) + 2;
                    int health = (int) (Math.random() * 10) + 2;
                    int mana = (int) (Math.random() * 10) + 2;
                     item = new Item(-1, -1, true,rarity,attack, defense, health, mana, itemType );
                    itemCategoryList.addItem(item);

                }
                else {
                    int attack = 10;
                    int defense = 10;
                    int health = 10;
                    int mana = 10;
                     item = new Item(-1, -1, true,rarity,attack, defense, health, mana, itemType);
                    itemCategoryList.addItem(item);


                }
            }
            else if (rarity == 3)
            {
                //rare
                if (itemType != 5) {
                    int attack = (int) (Math.random() * 15) + 4;
                    int defense = (int) (Math.random() * 15) + 4;
                    int health = (int) (Math.random() * 15) + 4;
                    int mana = (int) (Math.random() * 15) + 4;
                     item = new Item(-1, -1, true,rarity,attack, defense, health, mana, itemType);
                    itemCategoryList.addItem(item);

                }
                else {
                    int attack = 15;
                    int defense = 15;
                    int health = 15;
                    int mana = 15;
                      item = new Item(-1, -1, true,rarity,attack, defense, health, mana, itemType);
                    itemCategoryList.addItem(item);


                }
            }
            else if (rarity == 4)
            {
                //epic
                if (itemType != 5) {
                    int attack = (int) (Math.random() * 20) + 6;
                    int defense = (int) (Math.random() * 20) + 6;
                    int health = (int) (Math.random() * 20) + 6;
                    int mana = (int) (Math.random() * 20) + 6;
                      item = new Item(-1, -1, true,rarity,attack, defense, health, mana, itemType);
                    itemCategoryList.addItem(item);

                }
                else {
                    int attack = 20;
                    int defense = 20;
                    int health = 20;
                    int mana = 20;
                      item = new Item(-1, -1, true,rarity,attack, defense, health, mana, itemType);
                    itemCategoryList.addItem(item);

                }

            }
            else if (rarity == 5)
            {
                //legendary
                if (itemType != 5) {
                    int attack = (int) (Math.random() * 25) + 11;
                    int defense = (int) (Math.random() * 25) + 11;
                    int health = (int) (Math.random() * 25) + 11;
                    int mana = (int) (Math.random() * 25) + 11;
                      item = new Item(-1, -1, true,rarity,attack, defense, health, mana, itemType);
                    itemCategoryList.addItem(item);
                    //make sure to add the item to the item array
                }
                else {
                    int attack = 25;
                    int defense = 25;
                    int health = 25;
                    int mana = 25;
                      item = new Item(-1, -1, true,rarity,attack, defense, health, mana, itemType);
                    itemCategoryList.addItem(item);

                }

            }
            for (int i = 0; i < items.length; i++)
            {
                if (items[i] == null)
                {
                    items[i] = item;
                    break;
                }
            }

            //add item to inventory
            System.out.println("You successfully picked up an item!");
            quantityItems++;
            return item;
        }
        else {
            System.out.println("You can't pick up any more items!");
            return null;
        }
    }

    /**
     One method this needs is a drop method, where the person will randomly drop an item with the lowest
     rarity from their inventory that is not equipped.
     **/
    public Item dropLow()
    {
        if (quantityItems != 0)
        {
            //drop item from inventory
            int lowestrarity = 100;
            int index = -1;
            for (int i = 0; i < items.length; i++)
            {
                if (items[i] != null)
                {
                    if (items[i].getRarity() < lowestrarity)
                    {
                        lowestrarity = items[i].getRarity();
                        index = i;
                        if (items[i].getRarity() == 1)
                        {
                            break;
                        }
                    }
                }
            }
            Item rm = items[index];
            itemCategoryList.removeItem(items[index]);
            items[index] = null;
            System.out.println("You successfully dropped an item!");
            quantityItems--;
            return rm;
        }
        else {
            System.out.println("Your inventory is empty! Cannot drop anything!");
            return null;
        }
    }


    public void consume(Item i)
    {
        if (quantityItems != 0 && i.getItemType() == 5)
        {
            //consume item from inventory
            if (i.getRarity() == 1)
            {
                totalAttack += i.getAttack();
                totalDefense += i.getDefense();
                totalHealth += i.getHealth();
                totalMana += i.getMana();
            }
            else if (i.getRarity() == 2)
            {
                totalAttack += i.getAttack();
                totalDefense += i.getDefense();
                totalHealth += i.getHealth();
                totalMana += i.getMana();
            }
            else if (i.getRarity() == 3)
            {
                totalAttack += i.getAttack();
                totalDefense += i.getDefense();
                totalHealth += i.getHealth();
                totalMana += i.getMana();
            }
            else if (i.getRarity() == 4)
            {
                totalAttack += i.getAttack();
                totalDefense += i.getDefense();
                totalHealth += i.getHealth();
                totalMana += i.getMana();
            }
            else if (i.getRarity() == 5)
            {
                totalAttack += i.getAttack();
                totalDefense += i.getDefense();
                totalHealth += i.getHealth();
                totalMana += i.getMana();
            }
            for (int x = 0; x < items.length; x++)
            {
                if (items[x] == i)
                {
                    items[x] = null;
                    break;
                }
            }
            itemCategoryList.removeItem(i);
            System.out.println("You successfully consumed an item!");
            quantityItems--;
        }
        else {
            System.out.println("You can't consume this item!");
        }
    }

    public void equip(Item item, int index)
    {
        if (quantityItems != 0 && quantityEquipped != MAX_EQUIPPED)
        {
            this.setTotalAttack(this.getTotalAttack() + item.getAttack());
            this.setTotalDefense(this.getTotalDefense() + item.getDefense());
            this.setTotalHealth(this.getTotalHealth() + item.getHealth());
            this.setTotalMana(this.getTotalMana() + item.getMana());
            equipped[item.getItemType()-1] = item;
            items[index] = null;

            //equip item from inventory
            System.out.println("You successfully equipped an item!");
            quantityItems--;
            quantityEquipped++;
        }
        else {
            System.out.println("You can't equip any more items!");
        }
    }

    public void unequip(Item item, int index)
    {
        if (quantityItems != 0 && quantityEquipped != 0)
        {
            //unequip item from inventory
            System.out.println("You successfully unequipped an item!");
            quantityItems++;
            quantityEquipped--;
            this.setTotalAttack(this.getTotalAttack() - item.getAttack());
            this.setTotalDefense(this.getTotalDefense() - item.getDefense());
            this.setTotalHealth(this.getTotalHealth() - item.getHealth());
            this.setTotalMana(this.getTotalMana() - item.getMana());
            items[index] = item;
            equipped[item.getItemType()-1] = null;
        }
        else {
            System.out.println("You can't unequip any more items!");
        }
    }

    //This is only for swapping items in the inventory, not equipped items.
    public void swap(int index1, int index2)
    {
        if (items[index1] != null || items[index2] != null)
        {
            //swap item from inventory
            System.out.println("You successfully swapped an item!");
        }
        else {
            System.out.println("There is nothing to swap!");
        }
    }

    public String toString()
    {
        String s = "";
        s += "Equipped Items: \n";
        for (int i = 0; i < equipped.length; i++)
        {
            if (equipped[i] != null)
            {
                s += equipped[i].toString() + "\n";
            }
        }
        s += "\n\nInventory Items: \n";
        for (int i = 0; i < items.length; i++)
        {
            if (items[i] != null)
            {
                s += items[i].toString() + "\n";
            }
        }

        return s;
    }

}
