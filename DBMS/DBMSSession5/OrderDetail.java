package GET2018.DBMS.DBMSSession5;

import java.util.Date;

/**
 * This class contains OrderDetails of a User
 * 
 * @author Mohit Sharma
 *
 */
public class OrderDetail {
	private int id;
	private Date orderDate;
	private double orderTotalPrice;

	public OrderDetail(int id, Date orderDate, double orderTotalPrice) {
		this.id = id;
		this.orderDate = orderDate;
		this.orderTotalPrice = orderTotalPrice;
	}

	public int getId() {
		return id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public double getOrderTotalPrice() {
		return orderTotalPrice;
	}
}
