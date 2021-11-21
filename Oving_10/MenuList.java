import java.util.ArrayList;

public final class MenuList {
    private final ArrayList<Menu> menus;
    private final ArrayList<Dish> dishes;

    /**
     * This method is a constructor and uses "this." because the class is immutable and the variables
     * must be defined for this instance of each method.
     */
    public MenuList() {
        this.menus = new ArrayList<Menu>();
        this.dishes = new ArrayList<Dish>();
    }

    /**
     * Here the code will return all generated dishes.
     * @return
     */

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    /**
     * Here the code will return all generated menus.
     * @return
     */

    public ArrayList<Menu> getMenus() {
        return menus;
    }

    /**
     * This method allows the user to create a new dish based on the parameters below.
     * @param name
     * @param type
     * @param recipe
     * @param price
     * @return
     */

    public Dish newDish(String name, String type, String recipe, double price) {
        Dish newDish = new Dish(name, type, recipe, price);
        this.dishes.add(newDish);
        return newDish;
    }

    /**
     * This method allows the user to create a new menu based on dishes that they have selected.
     * @param menuDishes
     * @return
     */

    public Menu newMenu(ArrayList<Dish> menuDishes) {
        Menu newMenu = new Menu(menuDishes);
        this.getMenus().add(newMenu);
        return newMenu;
    }

    /**
     * This method gets the dish by the name that has been given as a parameter and returns all data
     * of the dish. It uses lowercase so that it is more user-friendly.
     * @param name
     * @return
     */

    public ArrayList<Dish> getDishByName(String name) {
        String dishNameLowercase = name.toLowerCase();
        ArrayList<Dish> nameArray = new ArrayList<Dish>();
        for (int i = 0; i < this.getDishes().size(); i++) {
            if (this.getDishes().get(i).getName().toLowerCase().equals(dishNameLowercase)) {
                nameArray.add(this.getDishes().get(i));
            }
        }
        return nameArray;
    }

    /**
     * This method gets all dishes by the type that has been given as a parameter and returns all data
     * of the dishes. It uses lowercase so that it is more user-friendly.
     * @param type
     * @return
     */

    public ArrayList<Dish> getDishByTypes(String type) {
        String dishTypeLowercase = type.toLowerCase();
        ArrayList<Dish> typeArray = new ArrayList<Dish>();
        for (int i = 0; i < this.getDishes().size(); i++) {
            if (this.getDishes().get(i).getType().toLowerCase().equals(dishTypeLowercase)) {
                typeArray.add(this.getDishes().get(i));
            }
        }
        return typeArray;
    }

    /**
     * This method takes in 2 parameters and returns all dishes between said parameters.
     * @param min
     * @param max
     * @return
     */

    public ArrayList<Menu> getDishesBetweenPrices(double min, double max) {
        ArrayList<Menu> menusWithinPrice = new ArrayList<Menu>();
        for (int i = 0; i < this.getMenus().size(); i++) {
            if (this.getMenus().get(i).getTotalPrice() >= min && getMenus().get(i).getTotalPrice() <= max) {
                menusWithinPrice.add(this.getMenus().get(i));
            }
        }
        return menusWithinPrice;
    }
}
