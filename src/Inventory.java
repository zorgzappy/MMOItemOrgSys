//This will be the Inventory of a player, which will also be used by the GUI class to display what items a player has in their inventory at all times.


public class Inventory {
    private final int MAX_ITEMS = 20;
    private final int MAX_EQUIPPED = 5;
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
        if (items[index1] != null && items[index2] != null)
        {
            //swap item from inventory
            System.out.println("You successfully swapped an item!");
        }
        else {
            System.out.println("You can't swap any more items!");
        }
    }



}
