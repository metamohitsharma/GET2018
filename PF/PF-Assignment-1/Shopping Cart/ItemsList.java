/**
 * It is used to describe the properties of products
 * @author Mohit
 */
public class ItemsList {
	String	item_Name;
	int	quantity;
	double	price;
	int	item_ID;
	
	public String getItem_name() {
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
	
	public void setItem_name(String item_Name) {
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
	
	public ItemsList(String item_Name, int item_ID, int quantity, double price) {
		this.item_Name = item_Name;
		this.item_ID = item_ID;
		this.quantity = quantity;
		this.price = price;
	}
}
