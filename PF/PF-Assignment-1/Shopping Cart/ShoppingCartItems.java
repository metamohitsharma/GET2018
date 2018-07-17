/**
 * This class describes the properties of Shopping Cart Items
 * @author Mohit
 */
public class ShoppingCartItems {
	String	item_Name;
	int	item_ID;
	int	quantity;
	double	price;
	static double	total_Amount;

	public String getItem_Name() {
		return item_Name;
	}

	public int getItem_ID() {
		return item_ID;
	}
	
	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public static double getTotal_Amount() {
		return total_Amount;
	}

	public void setItem_Name(String item_Name) {
		this.item_Name = item_Name;
	}

	public void setItem_ID(int item_ID) {
		this.item_ID = item_ID;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public static void setTotal_Amount(double total_Amount) {
		ShoppingCartItems.total_Amount = total_Amount;
	}
	
	public ShoppingCartItems(String item_Name, int item_ID, int quantity, double price) {
		this.item_Name = item_Name;
		this.item_ID = item_ID;
		this.quantity = quantity;
		this.price = price;
	}
}
