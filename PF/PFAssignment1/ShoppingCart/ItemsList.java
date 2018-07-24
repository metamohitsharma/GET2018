package GET2018.PF.PFAssignment1.ShoppingCart;

/**
 * It is used to describe the properties of products
 * 
 * @author Mohit Sharma
 */
public class ItemsList {
	String itemName;
	int quantity;
	double price;
	int itemID;

	public String getItemName() {
		return itemName;
	}

	public int getItemID() {
		return itemID;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ItemsList(String itemName, int itemID, int quantity, double price) {
		this.itemName = itemName;
		this.itemID = itemID;
		this.quantity = quantity;
		this.price = price;
	}
}