package GET2018.PF.PFAssignment1.ShoppingCart;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class contains the main method which implements the Shopping Cart
 * 
 * @author Mohit Sharma
 */
public class ShoppingCart {
	static ArrayList<ShoppingCartItems> cart = new ArrayList<>();
	static ArrayList<ItemsList> list = new ArrayList<>();

	public static void main(String args[]) {
		list.add(new ItemsList("USB HP 8GB", 435, 50, 500.50));
		list.add(new ItemsList("USB HP 16GB", 12, 50, 1000.23));
		list.add(new ItemsList("HP Printer", 3214, 20, 5200.70));
		list.add(new ItemsList("HP Keyboard", 444, 25, 10600));
		list.add(new ItemsList("HP Mouse", 1423, 50, 760));
		while (true) {
			System.out
					.println("Choose any Operation:-\n1. Add Item\n2. Update List\n3. Display Cart\n4. Generate Bill\n5. Exit");
			String operation = new Scanner(System.in).nextLine();
			switch (operation) {
			case "1":
				boolean check = ShoppingCart.addItem();
				if (check) {
					System.out.println("Item Added");
				}
				break;

			case "2":
				ShoppingCart.updateList();
				break;

			case "3":
				System.out.println("Item ID\tItem Name\tQuantity\tPrice");
				for (int i = 0; i < cart.size(); i++) {
					ShoppingCartItems cartList = cart.get(i);
					System.out.println(cartList.getItemID() + "\t"
							+ cartList.getItemName() + "\t"
							+ cartList.getQuantity() + "\t\t"
							+ cartList.getPrice());
				}
				break;

			case "4":
				double totalPrice = 0;
				int totalQuantity = 0;
				double discount = 0;
				System.out.println("Item ID\tItem Name\tQuantity\tPrice");
				for (int i = 0; i < cart.size(); i++) {
					ShoppingCartItems cartList = cart.get(i);
					totalPrice = totalPrice + cartList.getPrice();
					totalQuantity = totalQuantity + cartList.getQuantity();
					System.out.println(cartList.getItemID() + "\t"
							+ cartList.getItemName() + "\t\t"
							+ cartList.getQuantity() + "\t"
							+ cartList.getPrice());
				}
				System.out.println("Total Price:- \t\t\t\t" + totalPrice);
				System.out.println("Enter Promocode to avail Discount :-");
				String promocode = new Scanner(System.in).nextLine();
				discount = ShoppingCart.Discount(promocode, totalPrice,
						totalQuantity);
				System.out.println("*****************"
						+ "\nAmount to be paid:- "
						+ (totalPrice - discount * totalPrice));
				break;

			case "5":
				System.exit(1);

			default:
				System.out.println("Wrong Input");
			}
		}
	}

	/**
	 * This method adds selected product to Items List
	 * 
	 * @return true if the selected product is added
	 */
	static boolean addItem() {
		int itemID;
		int quantity;
		int iteration;
		System.out.println("Item ID\tItem Name\tQuantity\tPrice");
		for (int i = 0; i < list.size(); i++) {
			ItemsList ItemsList = list.get(i);
			System.out.println(ItemsList.getItemID() + "\t"
					+ ItemsList.getItemID() + "\t" + ItemsList.getQuantity()
					+ "\t\t" + ItemsList.getPrice());
		}
		System.out.println("Enter Item ID to add in Shopping Cart");
		itemID = new Scanner(System.in).nextInt();
		System.out.println("Enter the quantity to be purchased");
		quantity = new Scanner(System.in).nextInt();
		for (iteration = 0; iteration < list.size(); iteration++) {
			ItemsList AddedItem = list.get(iteration);
			for (int i = 0; i < cart.size(); i++) {
				if (cart.get(i).getItemID() == itemID) {
					System.out.println("Item Already in Cart");
					return false;
				}
			}
			if (AddedItem.getItemID() == itemID) {
				if (quantity <= AddedItem.getQuantity()) {
					cart.add(new ShoppingCartItems(AddedItem.getItemName(),
							itemID, quantity, AddedItem.getPrice() * quantity));
					list.get(iteration).setQuantity(
							AddedItem.getQuantity() - quantity);
					return true;
				} else {
					System.out.println("Requested Quantity Not Available");
					return false;
				}
			}
		}
		if (iteration == list.size()) {
			System.out.println("Entered Item ID not Found");
		}
		return false;
	}

	/**
	 * This method updates products in Cart
	 */
	static void updateList() {
		try {
			int updatedItemID;
			int updatedItemQuantity;
			int iteration;
			int iteration2;
			Scanner inputChoice = new Scanner(System.in);
			System.out.println("Item ID\tItem Name\tQuantity\tPrice");
			for (int i = 0; i < cart.size(); i++) {
				ShoppingCartItems cartList = cart.get(i);
				System.out.println(cartList.getItemID() + "\t"
						+ cartList.getItemName() + "\t\t"
						+ cartList.getQuantity() + "\t" + cartList.getPrice());
			}
			System.out.println("Enter Item ID to be updated");
			updatedItemID = inputChoice.nextInt();
			System.out.println("Enter the quantity to be purchased");
			updatedItemQuantity = inputChoice.nextInt();
			for (iteration = 0; iteration < list.size(); iteration++) {
				if (list.get(iteration).getItemID() == updatedItemID) {
					break;
				}
			}
			for (iteration2 = 0; iteration2 < cart.size(); iteration2++) {
				if (cart.get(iteration2).getItemID() == updatedItemID) {
					break;
				}
			}
			ShoppingCartItems UpdatedItem = cart.get(iteration2);
			ItemsList Item = list.get(iteration);
			if (updatedItemQuantity == 0) {
				cart.remove(iteration2);
				list.get(iteration).setQuantity(
						Item.getQuantity() + UpdatedItem.getQuantity());
			} else {
				if (updatedItemQuantity <= Item.getQuantity()
						+ UpdatedItem.getQuantity()) {
					list.get(iteration).setQuantity(
							Item.getQuantity() + UpdatedItem.getQuantity()
									- updatedItemQuantity);
					cart.get(iteration2).setQuantity(updatedItemQuantity);
					cart.get(iteration2).setPrice(
							updatedItemQuantity * Item.getPrice());
				} else {
					System.out.println("Requested Quantity Not Available");
				}
			}
		} catch (Exception e) {
			System.out.println("Entered Item ID not found");
		}
	}

	/**
	 * Computes the discount given to customer
	 * 
	 * @param enteredPromocode
	 * @param totalPrice
	 * @param totalQuantity
	 * @return discount given on the basis of Promotional Code
	 */
	static double Discount(String enteredPromocode, double totalPrice,
			int totalQuantity) {
		FixedOrderPromotion fixedOrderPromotion = new FixedOrderPromotion();
		FixedProductPromotion fixedProductPromotion = new FixedProductPromotion();
		if (fixedOrderPromotion.isPromotionApplicable(enteredPromocode)) {
			if (totalPrice >= fixedOrderPromotion.getMinimumPrice()) {
				System.out.println("Promocode Applied");
				return fixedOrderPromotion.getFixedDiscount();
			} else if (totalQuantity >= fixedProductPromotion.getMinQuantity()) {
				System.out.println("Promocode Applied");
				return fixedProductPromotion.getFixedDiscount();
			} else {
				System.out
						.println("The Cart doesnot meet the requirements to avail discount");
				return 0;
			}
		} else {
			System.out.println("Incorrect Promocode");
			return 0;
		}
	}
}
