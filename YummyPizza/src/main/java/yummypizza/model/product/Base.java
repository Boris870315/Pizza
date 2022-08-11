package yummypizza.model.product;

public enum Base {

	traditional , 
	wholemeal, 
	gluten;
	
	public static final String question = "choose one base" ;

	public static final String[] descriptions = {
            "traditional",
            "wholemeal",
            "gluten free",
    };
	
	public String getDescription() {
        return descriptions[this.ordinal()];
    }
	
}
