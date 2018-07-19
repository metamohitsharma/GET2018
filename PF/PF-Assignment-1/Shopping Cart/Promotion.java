package ShoppingCart;

/**
 * This Interface offers Promotion
 * 
 * @author Mohit Sharma
 */
public interface Promotion {
	/**
	 * This Enum contains three parameters code:- The Promotional Code Every
	 * Promotional Code are valid between startDate and endDate
	 */
	enum PromotionEnum {
	GET15("GET15", "1/07/2018", "31/07/2018"), FREE05("FREE05", "1/07/2018", "20/07/2018");
		String code;
		String startDate;
		String endDate;

		PromotionEnum(String code, String startDate, String endDate) {
			this.code = code;
			this.startDate = startDate;
			this.endDate = endDate;
		}

		public String getCode() {
			return code;
		}

		public String getStartDate() {
			return startDate;
		}

		public String getEndDate() {
			return endDate;
		}
	}

	double getMinimumPrice();

	void setMinimumPrice();

	double getFixedDiscount();

	void setFixedDiscount();

	/**
	 * This Method checks whether the entered Promotional Code is Valid or not
	 * 
	 * @param enteredPromocode, the Promocode entered
	 * @return true if the Promocode is Valid
	 */
	boolean isPromotionApplicable(String enteredPromocode);
}
