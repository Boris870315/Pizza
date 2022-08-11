package yummypizza.model.product;

public enum SideOption {

	creamy_mushroom_pasta,
	classic_bolognese,
	chicken_wings,
	garlic_bread,
	soft_drinks,
	fruit_juice;
	
	public static final String question = "choose one" ;

	public static final String[] descriptions = {
			"creamy mushroom pasta",
			"classic bolognese",
			"chicken wings",
			"garlic bread",
			"soft drinks",
			"fruit juice",
            
    };
	public String getDescription() {
        return descriptions[this.ordinal()];
    }
	
}
