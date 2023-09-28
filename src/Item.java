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

    //In order of the amount created, dictates the order in which it was created in.
    private int creationNum;

    //This variable will be one of the many checks in place to see if duplication has occured.
    //If the variable is ever false AFTER an item has been properly initialized, then item was not obtained
    //From a legitmate source in game. Obviously not something that pertains to this specific project since
    //there is no game, so for now this variable will always be true.
    private boolean acquisition;

    public Item()
    {
        ItemCategoryNum = -1;
        creationid = -1;
        creationNum = -1;
        acquisition = true;

    }

    public Item(int IC, int CI, int CN, boolean a)
    {
        ItemCategoryNum = IC;
        creationid = CI;
        creationNum = CN;
        acquisition = a;
    }

    public int getCreationid() {
        return creationid;
    }

    public int getItemCategoryNum() {
        return ItemCategoryNum;
    }

    public int getCreationNum() {
        return creationNum;
    }

    public boolean getAcquisition()
    {
        return acquisition;
    }

}
