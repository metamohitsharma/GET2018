package GET2018.PF.PFAssignment1.ShoppingCart;

/**
 * This class describes the properties of Shopping Cart Items
 * 
 * @author Mohit Sharma
 */
public class ShoppingCartItems {
	String itemName;
	int itemID;
	int quantity;
	double price;
	static double totalAmount;

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

	public static double getTotalAmount() {
		return totalAmount;
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

	public static void setTotalAmount(double totalAmount) {
		ShoppingCartItems.totalAmount = totalAmount;
	}

	public ShoppingCartItems(String itemName, int itemID, int quantity,
			double price) {
		this.itemName = itemName;
		this.itemID = itemID;
		this.quantity = quantity;
		this.price = price;
	}
}
