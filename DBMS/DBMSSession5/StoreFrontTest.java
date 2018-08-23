package GET2018.DBMS.DBMSSession5;

import static org.junit.Assert.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * This class tests various methods defined in Implementation class
 * 
 * @author Mohit Sharma
 *
 */
public class StoreFrontTest {

	Implementation implementation;

	@Rule
	public ExpectedException ex = ExpectedException.none();

	@Before
	public void init() throws ClassNotFoundException, SQLException {
		implementation = new Implementation();
	}

	@Test
	public void When_UserID_Expect_OrderShipped() throws ParseException, SQLException {
		List<OrderDetail> resultList = new ArrayList<OrderDetail>();
		resultList.add(new OrderDetail(5, java.sql.Date.valueOf("2018-05-11"), 9900));
		resultList.add(new OrderDetail(4, java.sql.Date.valueOf("2018-06-12"), 18000));
		resultList.add(new OrderDetail(1, java.sql.Date.valueOf("2018-08-15"), 30000));
		List<OrderDetail> orderList = implementation.orderDetailsOfShippedOrder("rsbhatra98@gmail.com");
		for (int i = 0; i < resultList.size(); i++) {
			assertEquals(resultList.get(i).getId(), orderList.get(i).getId());
			assertEquals(resultList.get(i).getOrderDate(), orderList.get(i).getOrderDate());
			assertEquals(resultList.get(i).getOrderTotalPrice(), orderList.get(i).getOrderTotalPrice(), 0);
		}
	}

	@Test
	public void When_GivenImages_Expect_NoOfRowsInserted() throws StoreFrontException {
		assertEquals(2, implementation.insertImagesOfProducts(new int[] { 1, 2 },
				new String[] { "Product1.jpg", "Product2.jpg" }));
	}

	@Test
	public void When_GivenImagesAndIdsWhichNotExist_Expect_NegativeCase() throws StoreFrontException {
		assertEquals(-1, implementation.insertImagesOfProducts(new int[] { 100, 203 },
				new String[] { "Product1.jpg", "Product2.jpg" }));
	}

	@Test
	public void When_DeleteProductNotOrdered_Expect_NoOfDeletedProducts() throws SQLException {
		assertEquals(4, implementation.deleteProductsNotOrdered());
	}

	@Test
	public void When_TopCategories_ExpectNoOfChildCategory() {
		List<CategoryDetail> resultList = new ArrayList<CategoryDetail>();
		resultList.add(new CategoryDetail("Electronics", 9));
		resultList.add(new CategoryDetail("Accessories", 3));
		resultList.add(new CategoryDetail("Fashion Styling", 6));
		List<CategoryDetail> categoryList = implementation.categoryDetail();
		for (int i = 0; i < resultList.size(); i++) {
			assertEquals(resultList.get(i).getCategoryName(), categoryList.get(i).getCategoryName());
			assertEquals(resultList.get(i).getNoOfChilds(), categoryList.get(i).getNoOfChilds());
		}
	}

	@Test
	public void When_UserIDNull_Expect_NullPointerException() throws SQLException {
		ex.expect(NullPointerException.class);
		ex.expectMessage("userId can't be Null");
		implementation.orderDetailsOfShippedOrder(null);
	}

	@Test
	public void When_ImageOrIDNull_Expect_NullPointerException() throws StoreFrontException {
		ex.expect(NullPointerException.class);
		ex.expectMessage("Id or Images Can't be Null");
		implementation.insertImagesOfProducts(null, null);
	}

	@Test
	public void When_ImageOrIDLengthNotEqual_Expect_StoreFrontException() throws StoreFrontException {
		ex.expect(StoreFrontException.class);
		ex.expectMessage("Id and Images length are not Equal");
		implementation.insertImagesOfProducts(new int[] { 1 }, new String[] { "Hello.jpg", "Product3.jpg" });
	}
}
