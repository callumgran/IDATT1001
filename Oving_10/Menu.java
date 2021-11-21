import java.util.ArrayList;

public final class Menu {
    private final ArrayList<Dish> menu;

    /**
     * This method is a constructor and uses "this." because the class is immutable and the variables
     * must be defined for this instance of each method.
     * @param menu
     */

    public Menu(ArrayList<Dish> menu) {
        this.menu = menu;
    }

    /**
     * This method returns this menu.
     * @return
     */
    public ArrayList<Dish> getMenu() {
        return menu;
    }

    /**
     * This method returns the total price of this menu.
     * @return
     */
    public double getTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < this.menu.toArray().length; i++) {
            totalPrice += this.menu.get(i).getPrice();
        }
        return totalPrice;
    }

    /**
     * This method returns this menu as a String.
     * @return
     */
    @Override
    public String toString() {
        String menuDishes = "";
        for (int i = 0; i < this.getMenu().size(); i++) {
            menuDishes += this.getMenu().get(i).toString();
        }
        menuDishes += "\nTotal Price: " + this.getTotalPrice();
        return menuDishes;
    }
}
