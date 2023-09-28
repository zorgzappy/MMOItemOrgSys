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

//    public void checkItemCategoryNum(int numb)
//    {
//
//        boolean recount = false;
//        for (int i = 0; i < circulation.length; i++)
//        {
//            if (circulation[i] != null)
//            {
//                if (circulation[i].getItemCategoryNum() != itemCategoryID)
//                {
//
//                    circulation[i] = null;
//                    recount = true;
//                }
//            }
//        }
//
//    }


}
