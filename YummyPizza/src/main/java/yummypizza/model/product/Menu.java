package yummypizza.model.product;

public enum Menu {
	pizza, sidemenu;
	
	public static final String[] descriptions = {
            "pizza",
            "side menu",
    };
		
	public static final String question = "choose one" ;
	
	public String getDescription() {
        return descriptions[this.ordinal()];
    }
}
