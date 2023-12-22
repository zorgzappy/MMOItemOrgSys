public class ItemCategoryList {

    /*
    MAKE SURE THAT WHEN YOU ADD SHIT, THE ITEMCATEGORYID AND ITEMCATEGORYNUM IS RANDOMLY GENERATED AND IS NOT THE SAME
    AS ANY OTHER ITEM/ITEMCATEGORYID. MAKE A METHOD FOR THIS CHECK SINCE IT WILL HAPPEN A LOT.
     */



    //Holds every ItemCategory in the game.
    private ItemCategory[] allItemsCategories;
    private int quantityItemCategories;

    private int quantityItems;

    public ItemCategoryList()
    {
        quantityItems = 0;
        allItemsCategories = new ItemCategory[20];
        quantityItemCategories = 0;


    }

    public int getQuantityItemCategories()
    {
        return quantityItemCategories;
    }

    public void setQuantityItemCategories(int quantity) {
        this.quantityItemCategories = quantity;
    }



    public void setQuantityItems(int quantity)
    {
        quantityItems = quantity;
    }

    public int getQuantityItems()
    {
        return quantityItems;
    }

    public void rehash()
    {
        ItemCategory[] temp = new ItemCategory[allItemsCategories.length*2];
        for (int i = 0; i < allItemsCategories.length; i++)
        {
            temp[i] = allItemsCategories[i];
        }
        allItemsCategories = temp;
    }

    public void addItem(Item item)
    {
         //If the item is in the allitemcategories array, we first set the ItemCategoryNum of the item
        // equal to the ItemCategoryIDof the itemcattegory in the array. For the creation ID, get the quantity of items
        //in the itemcategory and add 1 to it. Then set the creationid of the item to that number. Then add the item to the
        //itemcategory's circulation.


        item.setItemCategoryNum(item.getAttack()*2 + item.getDefense()*43 + item.getHealth()*5 + item.getMana()*7 + item.getItemType()*11 + item.getRarity()*13);
        for (int i = 0; i < allItemsCategories.length; i++)
        {
            if (allItemsCategories[i] != null)
            {
                if (allItemsCategories[i].getItemCategoryID() == item.getItemCategoryNum())
                {
                    item.setCreationid(allItemsCategories[i].getQuantity()+1);
                    allItemsCategories[i].add(item);
                    quantityItems++;
                    System.out.println("Item successfully added!");
                    return;
                }
            }
        }

        //If the item is not in the allitemcategories array, we first create a new itemcategory with the itemcategoryid
        //equal to the itemcategorynum of the item. Then we set the creationid of the item to 1. Then we add the item to the
        //itemcategory's circulation.

        ItemCategory itemCategory = new ItemCategory();
        itemCategory.setItemCategoryID(item.getItemCategoryNum());
        item.setCreationid(1);
        if (item.getRarity() == 1)
        {
            itemCategory.setName("Common Item");
        }
        else if (item.getRarity() == 2)
        {
            itemCategory.setName("Uncommon Item");
        }
        else if (item.getRarity() == 3)
        {
            itemCategory.setName("Rare Item");
        }
        else if (item.getRarity() == 4)
        {
            itemCategory.setName("Epic Item");
        }
        else if (item.getRarity() == 5)
        {
            itemCategory.setName("Legendary Item");
        }
        itemCategory.add(item);
        quantityItems++;
        this.addItemCategory(itemCategory);

    }


    public boolean addItemCategory(ItemCategory item)
    {
        this.generate();
        //Add rehash parameters and rehash here
        int firstNull = -1;
        for (int i = 0; i < allItemsCategories.length; i++)
        {
           if (allItemsCategories[i] != null)
           {
               if (allItemsCategories[i].getItemCategoryID() == item.getItemCategoryID())
               {
                   System.out.println("ItemCategory already exists!");
                   return false;
               }
           }
           else if (firstNull == -1)
           {
               firstNull = i;
           }
        }
        if (firstNull != -1)
        {
            allItemsCategories[firstNull] = item;
            quantityItemCategories++;
            System.out.println("ItemCategory successfully added!");
            return true;
        }

        System.out.println("ItemCategory not added! ERROR!");
        return false;
    }

    public void removeItem(Item item)
    {
        for (int i = 0; i < allItemsCategories.length; i++)
        {
            if (allItemsCategories[i] != null)
            {
                if (allItemsCategories[i].getItemCategoryID() == item.getItemCategoryNum())
                {
                    allItemsCategories[i].remove(item.getCreationid());
                    quantityItems--;
                    System.out.println("Item successfully removed!");
                    return;
                }
            }
        }
    }

    public void generate()
    {

        if (quantityItemCategories == (int)((allItemsCategories.length/4.0)*3) )
        {
            this.rehash();
        }

    }

    public String toString()
    {
        String output = "";
        for (int i = 0; i < allItemsCategories.length; i++)
        {
            if (allItemsCategories[i] != null)
            {
                output += allItemsCategories[i].toString() + "\n";
            }
        }
        return output;
    }



}
