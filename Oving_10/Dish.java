public final class Dish {
    private final String name;
    private final String type;
    private final String recipe;
    private final double price;

    /**
     * This method is a constructor and uses "this." because the class is immutable and the variables
     * must be defined for this instance of each method.
     * @param name
     * @param type
     * @param recipe
     * @param price
     */
    public Dish(String name, String type, String recipe, double price) {
        this.name = name;
        this.type = type;
        this.recipe = recipe;
        this.price = price;
    }

    /**
     * This method returns the name of the dish.
     * @return
     */

    public String getName() {
        return name;
    }

    /**
     * This method returns the type of the dish.
     * @return
     */

    public String getType() {
        return type;
    }

    /**
     * This method returns the recipe of the dish.
     * @return
     */

    public String getRecipe() {
        return recipe;
    }

    /**
     * This method returns the price of the dish.
     * @return
     */

    public double getPrice() {
        return price;
    }

    /**
     * This method returns the all the values of the dish as a string.
     * @return
     */

    @Override
    public String toString() {
        return '\n' +
                "Name: " + this.getName() + '\n' +
                "Type: " + this.getType() + '\n' +
                "Recipe: " + this.getRecipe() + '\n' +
                "Price: " + this.getPrice() + '\n';
    }
}
