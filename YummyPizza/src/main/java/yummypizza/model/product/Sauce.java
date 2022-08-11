package yummypizza.model.product;

public enum Sauce {

	tomato, 
	BBQ;
	
	public static final String question = "choose one Sauce" ;

	public static final String[] descriptions = {
            "tomato",
            "BBQ",
         
            
    };
	public String getDescription() {
        return descriptions[this.ordinal()];
    }
	
}
