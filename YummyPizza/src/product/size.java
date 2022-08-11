package product;

public enum size {
	small,
	large ,
	extralarge;


	public static final String[] descriptions = {
			"8-inch",
			"11-inch",
			"12-inch"
	};

	public String getDescription() {
		return descriptions[this.ordinal()];
	}
}