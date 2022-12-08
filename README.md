## Introduction
Group #60 proudly presents "Inventricky", an inventory system that is tailored for business use.
Our program allows the user to make their inventory and manage their stock of items and orders among other features which are mentioned further in this document.

### Instructions
#### Inventory Creation

In your very first use of the program, make sure you start an inventory from scratch 
(considering you haven't used the program before and have nothing to import). Make sure your file name does not already
exist for an inventory in the exports folder, and that it is valid (i.e. no spaces).

#### Adding items

After naming and creating your inventory, you can add items using the add item button. You will be greeted by a field
to input your item details. Press confirm to add the item to inventory.

* Name: name of the item (must be unique)
* Quantified by weight: true if the item is quantified in kg, otherwise quantified per unit
* Price Bought: cost of the item to the business per kg/unit, can be a double
* Selling Price: price of the item for consumer per kg/unit, can be a double
* Case Quantity: units/kgs of item per case
* Department Number: 2 digit department number of item (e.g. 09, 99, 12)

#### Removing items

Click on an item in the inventory to bring up an item menu with an option to remove the item. Press confirm remove
to remove the item.

#### Updating item quantity

To update the quantity of an item, click on the item to bring up the item menu and select the Update Item Quantity 
dropdown. To update quantity bought, select the bought option and type in the quantity bought. To update the quantity
sold, select the sold option and type in the quantity sold. To update the quantity due to an error, select the error 
option and type in the correct quantity. Click confirm update to make these changes.

#### Getting item history

To get the history of quantity changes of an item, click get item history in the item menu. You can also see these changes
for all items in the inventory by clicking the history button at the bottom of the inventory screen.

#### Item analysis

Click on the generate analysis menu button at the top of the inventory screen to get analysis data about the current 
inventory. You can get the revenue breakdown, cost breakdown and profit/loss.

#### Search, sort and filter

The inventory menu contains options for searching, sorting, and filtering the inventory. The sort option provides various
ways to sort the inventory, such as alphabetically or by barcode. The filter option allows you to filter the inventory
by department number. The search option lets you search for an item by name. This works for both substrings and superstrings, 
and ignores capitalization.

#### Placing an order

To place an order for an item, click on order in the inventory menu and select order history. This will bring up the 
order history with an option at the bottom to place an order. Clicking on place order will bring up a screen similar to 
the one for adding a new item. To place an order for an item not in the inventory, fill the input fields and click
place order, which will update the order history. To place an order for an existing item, fill in the input fields with
the same data as the existing item. When placing an order, you can specify how many cases to buy and which supplier 
your order is from. For definition of input fields, see instructions for adding a new item.

#### Receiving an order

To receive an order, select the order in the order history and click receive order below. This will mark the order as
received and update the item quantity in the inventory. 

#### Exporting

To export an inventory, click the export button in the inventory menu bar at the bottom. This will export a .txt file,
serializable file, and csv to the export folder. The .txt file contains a user readable inventory. If the export files
in the exports folder already exist, this will overwrite the files.

#### Importing

To import an inventory, select the imported option when creating the inventory and select the serializable file of the 
inventory in the exports folder.

#### Deleting inventory

To delete an inventory, select the delete inventory menu option and confirm deletion. This will delete the inventory and
all exports of the inventory in the exports folder.

### Getting Started / Importing
Upon starting the program, the user will have the option to import an inventory or create an inventory from Scratch.
the Import inventory method will require the user to choose a serializable file to import from.
An inventory created from scratch (with the name inputted by the user) will be completely blank and not include an items or orders, while an imported inventory will be populated based on the data of the imported serializable file.
From this point, all inventories will have the same functionalities, as described further in the document.

### Exporting
Exporting is a key component in our data persistence system.
If a user wants to save the changes they've made to an inventory, they can export which will create a serializable and a txt file named after the inventory.
The user can import the serializable file when they start the program again or transfer their work to another system.

___

### Orders
Orders are a subclass of Items along with InventoryItems, but serves a different purpose. Orders keep track of all the attributes of InventoryItems but also keep track of cases, the date received, the date bought, estimated arrival date, and supplier.
When an order is received, the user can mark it as received on the Orders UI which will mark the order as received on the Orders table and add the item to the InventoryUI.
Orders all have an individual unique barcode.

### Inventory Items
InventoryItems are the Items displayed in the InventoryUI, and represents all the items currently stored in the inventory.
These InventoryItems can be increased in quantity or sold.
The user is also able to view the history of each individual InventoryItem by clicking on it in the InventoryUI.
Like Orders, InventoryItems all have unique barcodes.

___

### Analysis
Analysis generates a financial report of the inventory. The user can choose to see a rveneue breakdown based on sales, a cost breakdown based on expenses, and a total profit/loss calculator.

___

### Search / Sort / Filter
The default order of the items in InventoryUI is based on the order in which the items were added to the inventory.
If the user would like to reorder the items or search for a specific subsection of items, they can use the search, sort, or filter options.


