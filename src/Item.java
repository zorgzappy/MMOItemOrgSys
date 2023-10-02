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

    //Unique num sequence assigned to this particular item. Should never be the same as any other item
    private int creationid;

    //This variable will be used in a actual game to determine where the item was acquired from. Since this is not a
    //entier MMO, this variable will just be a boolean value, since there is no methods of acquiring items in this
    // system.
    private boolean acquisition;

    public Item()
    {
        ItemCategoryNum = -1;
        creationid = -1;
        acquisition = true;

    }

    public Item(int IC, int CI, boolean a)
    {
        ItemCategoryNum = IC;
        creationid = CI;
        acquisition = a;
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

}
