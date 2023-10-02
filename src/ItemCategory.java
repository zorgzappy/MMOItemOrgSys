public class ItemCategory {

    //All of the specific item pertaining to the itemCategory that are currently in circulation
    private Item[] circulation;


    //The amount of non null entries in circulation
    private int quantity;

    //A ID given specifically to each ItemCategory to make distinct from other itemCategories. Will be the same number
    //as the ItemCategoryNum in each Item in circulation.
    private int itemCategoryID;

    //The name of the ItemCategory
    private String Name;

    public ItemCategory()
    {
        circulation = new Item[10];
        Name = "";
        itemCategoryID = -1;
        quantity = 0;


    }

    //This method will make sure the itemcategorynum and itemcategoryid are both matching. If not, the item is then checked to make sure that it is added in
    //the correct place. If it doesn
    /*

    We first check and see if it the acquisition is false. If it is false, we will remove it.
    Afterwards, we check and see if the itemcategoryID matches with the item's ItemcategoryNum. If false,
    we will check and see if there is a itemcategoryID that matches with the itemcategoryNum and add it to that itemCategory in its respective circulation.
    If the itemcategorynum does not match with anyother itemcategoryid, we will remove that item with null. we will then mark the temporary variable recount to true.
    At the end of the for loop, aka outside the for loop, we will check and see if recount is equal to true. If it does, that means we need to change each item's
    creationnum.
     */




    //Makes the list longer if enough items are created
    public void rehash()
    {
        Item[] temp = new Item[circulation.length*2];
        for (int i = 0; i < circulation.length; i++)
        {
            temp[i] = circulation[i];
        }
        circulation = temp;
    }

    //adds a new Item to the list
    public void add(Item item)
    {
        this.generate();
        this.creationIdCheck(item.getCreationid());
        //Add rehash parameters and rehash here
        for (int i = 0; i < circulation.length; i++)
        {
            if (circulation[i] == null)
            {
                circulation[i] = item;
                quantity++;
                break;
            }
        }
    }

    public void creationIdCheck(int num)
    {
        for (int i = 0; i < circulation.length; i++)
        {
            if (circulation[i] != null)
            {
                if (circulation[i].getCreationid() != num)
                {
                    circulation[i] = null;
                }
            }
        }

    }




    

    //Creates a new Item object and adds it to circulation. Increases quantity by 1; It can be used whenever a player obtains an item from killing a boss/event/etc.
    public void generate()
    {

        if (quantity == ((circulation.length/2)-1))
        {
            this.rehash();
        }

    }


}
