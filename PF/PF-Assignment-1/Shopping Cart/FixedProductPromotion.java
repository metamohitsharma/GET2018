
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This Class offers Promotion based on Total Quantity of all Products
 * @author Mohit
 */
public class FixedProductPromotion implements Promotion{
	double	fixedDiscount;
	double	minPrice;
	int 	minQuantity;
	
	@Override
	public double getFixedDiscount() {
		return fixedDiscount;
	}
	
	@Override
	public double getMinimumPrice() {
		return minPrice;
	}
	
	@Override
	public boolean isPromotionApplicable(String enteredPromocode) {
		for (PromotionEnum promo : PromotionEnum.values()) {
			if (promo.getCode().equals(enteredPromocode)) {
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date date = new Date();
				String purchaseDate = dateFormat.format(date);
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				try {
					if (sdf.parse(promo.getStartDate()).before(sdf.parse(purchaseDate))) {
						if (sdf.parse(purchaseDate).before(sdf.parse(promo.getEndDate()))) {
							setFixedDiscount();
							return true;
						}
					}
				} catch (ParseException ex) {
					Logger.getLogger(FixedOrderPromotion.class.getName()).log(Level.SEVERE, null, ex);
				}  		
			}
		}
		return false;
	}
	
	@Override
	public void setFixedDiscount() {
		fixedDiscount = 0.15;
	}
	
	@Override
	public void setMinimumPrice() {}
	
	public int getMinQuantity() {
		return minQuantity;
	}
	
	public void setMinQuantity() {
		minQuantity = 20;
	}
	
}
