//This will be the Inventory of a player, which will also be used by the GUI class to display what items a player has in their inventory at all times.

public class Inventory {
    private final int MAX_ITEMS = 20;
    private final int MAX_EQUIPPED = 5;
    private ItemCategoryList itemCategoryList;


    private Item[] equipped = new Item[MAX_EQUIPPED];
    private int quantityEquipped;
    private Item[] items;
    private int quantityItems;

public Inventory()
{
    quantityItems = 0;
    items = new Item[MAX_ITEMS];
    quantityEquipped = 0;
    equipped = new Item[MAX_EQUIPPED];
    itemCategoryList = new ItemCategoryList();


}

    public void setQuantityItems(int quantity) {
        this.quantityItems = quantity;
    }

    public int getQuantityItems() {
        return quantityItems;
    }



    //One method this needs is a pickup method, where the person will randomly pick up an item from "the ground".
    public void pickUp()
    {
        if (quantityItems != MAX_ITEMS)
        {


            int rarity = (int)(Math.random() * 5)+1;
            int itemType = (int)(Math.random() * 5)+1;
            //Need to add to correct ItemCategoryList

            if (rarity == 1) {
                //common
                if (itemType != 5) {


                    int attack = (int) (Math.random() * 5) + 1;
                    int defense = (int) (Math.random() * 5) + 1;
                    int health = (int) (Math.random() * 5) + 1;
                    int mana = (int) (Math.random() * 5) + 1;
                    Item item = new Item(attack, defense, health, mana, itemType, rarity);
                } else {
                    int attack = 5;
                    int defense = 5;
                    int health = 5;
                    int mana = 5;
                    Item item = new Item(attack, defense, health, mana, itemType, rarity);

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
                    Item item = new Item(attack, defense, health, mana, itemType, rarity);
                }
                else {
                    int attack = 10;
                    int defense = 10;
                    int health = 10;
                    int mana = 10;
                    Item item = new Item(attack, defense, health, mana, itemType, rarity);

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
                    Item item = new Item(attack, defense, health, mana, itemType, rarity);
                }
                else {
                    int attack = 15;
                    int defense = 15;
                    int health = 15;
                    int mana = 15;
                    Item item = new Item(attack, defense, health, mana, itemType, rarity);

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
                    Item item = new Item(attack, defense, health, mana, itemType, rarity);
                }
                else {
                    int attack = 20;
                    int defense = 20;
                    int health = 20;
                    int mana = 20;
                    Item item = new Item(attack, defense, health, mana, itemType, rarity);

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
                    Item item = new Item(attack, defense, health, mana, itemType, rarity);
                }
                else {
                    int attack = 25;
                    int defense = 25;
                    int health = 25;
                    int mana = 25;
                    Item item = new Item(attack, defense, health, mana, itemType, rarity);

                }

            }


            //add item to inventory
            System.out.println("You successfully picked up an item!");
            quantityItems++;
        }
        else {
            System.out.println("You can't pick up any more items!");
        }
    }

    /**
     One method this needs is a drop method, where the person will randomly drop an item with the lowest
     rarity from their inventory that is not equipped.
     **/
    public void drop()
    {
        if (quantityItems != 0)
        {
            //drop item from inventory
            System.out.println("You successfully dropped an item!");
            quantityItems--;
        }
        else {
            System.out.println("You can't drop any more items!");
        }
    }


    public void consume(Item i)
    {
        if (quantityItems != 0 && i.getItemType() == 5)
        {
            //consume item from inventory
            System.out.println("You successfully consumed an item!");
            quantityItems--;
        }
        else {
            System.out.println("You can't consume any more items!");
        }
    }

    public void equip()
    {
        if (quantityItems != 0)
        {
            //equip item from inventory
            System.out.println("You successfully equipped an item!");
            quantityItems--;
            quantityEquipped++;
        }
        else {
            System.out.println("You can't equip any more items!");
        }
    }

    public void unequip()
    {
        if (quantityItems != 0)
        {
            //unequip item from inventory
            System.out.println("You successfully unequipped an item!");
            quantityItems++;
            quantityEquipped--;
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
            System.out.println("You can't swap any more items!");
        }
    }



}
