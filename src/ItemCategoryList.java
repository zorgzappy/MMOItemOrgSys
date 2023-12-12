public class ItemCategoryList {

    /*
    MAKE SURE THAT WHEN YOU ADD SHIT, THE ITEMCATEGORYID AND ITEMCATEGORYNUM IS RANDOMLY GENERATED AND IS NOT THE SAME
    AS ANY OTHER ITEM/ITEMCATEGORYID. MAKE A METHOD FOR THIS CHECK SINCE IT WILL HAPPEN A LOT.
     */



    //Holds every ItemCategory in the game.
    private ItemCategory[] allItemsCategories;
    private int quantity;

    public ItemCategoryList()
    {
        quantity = 0;
        allItemsCategories = new ItemCategory[20];

    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
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

    public void add(ItemCategory item)
    {
        this.generate();
        //Add rehash parameters and rehash here

        for (int i = 0; i < allItemsCategories.length; i++)
        {
            if (allItemsCategories[i] == null)
            {
                allItemsCategories[i] = item;
                quantity++;
                break;
            }
        }
    }

    public void generate()
    {

        if (quantity == (int)((allItemsCategories.length/4.0)*3) )
        {
            this.rehash();
        }

    }




}
