package yummypizza.model.product;

public enum Topping {

	supreme,
	sauage_sizzle,
	hawaiian,
	sweet_chilli_chicken,
	garden_goodness,
	periperi_chicken,
	vegan_cheese;
	
	public static final String question = "choose one topping" ;

	public static final String[] descriptions = {
			"supreme",
			"sauage sizzle",
			"hawaiian",
			"sweet chilli chicken",
			"garden goodness",
			"periperi chicken",
			"vegan cheese",
    };
	
	public String getDescription() {
        return descriptions[this.ordinal()];
    }
}
