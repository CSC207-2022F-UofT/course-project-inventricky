## Introduction
Group #60 proudly presents "Inventricky", an inventory system that is tailored for business use.
Our program allows the user to make their inventory and manage their stock of items and orders among other features which are mentioned further in this document.

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


