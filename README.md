# MMOItemOrgSys

# Statement of Purpose:
	This project aims to create an item organization system that can be implemented within an MMO video game (or an RPG one). One of the main goals of this project is to optimize the time complexity of any method so that it is as efficient as possible. 

# Classes:
	There will be several classes in this program in order to create the full functional program.

# Item Class
Each item will have a creationID, indicating its unique creation. For any item, there should not be another item with the same creationID. All creationID’s will be created starting from one. The reason we don’t assign a randomly generated number is because if we simply have it numbered counting from 1 and increasing, we will be able to look for an item with a specific creationID more easily using a binary search, with a amortized run time of Olog(n). The one problem with this method is that if we delete any item, we will start to create gaps between Item object’s creationID’s. Not really too big of a problem, but it is something to note. 
Each Item also has an ItemCategoryNum variable. This number will be the same number as a variable from the ItemCategory class (that variable will be called itemCategoryID). The ItemCategoryNum variable is there to make sure that each item is in the correct ItemCategory class. IE, you don’t want the item data for a magic wand to be stored in a class full of  Magical hats. This basically just makes sure that each item is properly stored in an array that has the same items. 
Acquisition variable will be used to determine where in the game a certain item was acquired from. Since there is no game in this model, there is no need for an acquisition variable, so for our model, it will just be a boolean statement, simply to acknowledge that there should be an acquisition variable. 



# ItemCategory Class
Purpose:
The purpose of this class is to hold a list of ONE specific kind of Item. This allows for each item to be properly organized in its own respective list. It allows for easy search of a specific item in the list. 
Constructor:
The constructor has four variables. The first variable is the itemCategoryID variable. As stated in the Item class, the function of this variable is to make sure that each item is properly located in the correct ItemCategory class
The second variable is the circulation[] array. This holds all the Items that are currently in circulation (Aka created). Its initial value will be 10, but it will rehash itself when needed. One problem that may rise is that the initial value could be too small. For example, in a big MMO game, lets there is a new item that gets released. If too many people get that item at the same time, there might not be enough time for the array to rehash. Realistically, this shouldn’t be a problem since we check if we should rehash before adding, but its something to note. 
The quantity variable tells us the amount of non-null entries in circulation[]
The Name variable gives the name of the Items that are being held in the circulation[] array. The reason why I don’t give each item a name variable and then use that to check and make sure it is in the right area is because most ints are 4 bytes long, and most strings would be more than 4 bytes long. 
Methods:
Rehash
This method will take the current size of circulation[], make a new array with double that size, then copy all of the elements from circulation[] to this new array, and then set circulation[] equal to the new array.
Generate
Checks to see if the rehashing should occur. 3/4ths load 
Add(Item)
Checks to see if rehashing should occur. Afterwards, it looks for the first null entry in circulation[], and sets it equal to the item. 
Remove(int)
Looks for the item with the same creationid, and removes it. It then checks afterwards if it should downsize the array size. 
There is also a Remove(Item) that uses the Remove(int) function
Search(itemt)
Uses  
