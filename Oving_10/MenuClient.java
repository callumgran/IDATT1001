import java.util.ArrayList;
import java.util.Scanner;

public class MenuClient {
    public static void main(String[] args) {
        char k;
        char p;
        MenuList menuList = new MenuList();
        Scanner in = new Scanner(System.in);
        menuList.newDish("Cheese", "Starter", "Chefs Secret", 10);
        menuList.newDish("Bread", "Starter", "Chefs Secret", 10);
        menuList.newDish("Pizza", "Main", "Chefs Secret", 10);
        menuList.newDish("Burger", "Main", "Chefs Secret", 10);
        menuList.newDish("Pasta", "Main", "Chefs Secret", 10);
        menuList.newDish("Tiramisu", "Dessert", "Chefs Secret", 10);
        menuList.newDish("Cake", "Dessert", "Chefs Secret", 10);

        do {
            System.out.println("Enter a number between 1 and 6");
            System.out.println("1: Register new dish");
            System.out.println("2: Find dish by name");
            System.out.println("3: Find dishes by type");
            System.out.println("4: Register new menu with dishes");
            System.out.println("5: Find all menus between 2 prices");
            System.out.println("6: Exit");
            k = in.next().charAt(0);
            System.out.println('\n');
            switch (k) {
                case '1':
                    in.nextLine();
                    System.out.println("Name: ");
                    String name = in.nextLine();
                    System.out.println("Type: ");
                    String type = in.nextLine();
                    System.out.println("Recipe: ");
                    String recipe = in.nextLine();
                    System.out.println("Price: ");
                    double price = in.nextDouble();
                    Dish newDish = menuList.newDish(name, type, recipe, price);
                    System.out.print(newDish);
                    break;

                case '2':
                    in.nextLine();
                    System.out.println("Name: ");
                    String dishName = in.nextLine();
                    ArrayList<Dish> dish = new ArrayList<Dish>();
                    dish = menuList.getDishByName(dishName);
                    for (int i = 0; i < dish.size(); i++) {
                        System.out.println(dish.get(i).toString());
                    }
                    break;

                case '3':
                    in.nextLine();
                    System.out.println("Type: ");
                    String dishType = in.nextLine();
                    ArrayList<Dish> typeArr = new ArrayList<Dish>();
                    typeArr = menuList.getDishByTypes(dishType);
                    System.out.println(typeArr.size());
                    for (int i = 0; i < typeArr.size(); i++) {
                        System.out.println(typeArr.get(i).toString());
                    }
                    break;

                case '4':
                    ArrayList<Dish> dishes = new ArrayList<Dish>();
                    String allDishes = "";
                    for (int i = 0; i < menuList.getDishes().size(); i++) {
                        allDishes +=  menuList.getDishes().get(i).toString();
                    }
                    System.out.println("Registered dishes: ");
                    System.out.println(allDishes);

                    do {
                        System.out.println("Enter 1 or 2");
                        System.out.println("1: Add a new dish");
                        System.out.println("2: Exit");
                        p = in.next().charAt(0);
                        System.out.println('\n');
                        switch (p) {
                            case '1':
                                in.nextLine();
                                System.out.println("Write the name of a new dish for the menu: ");
                                String newMenuDishName = in.nextLine();
                                ArrayList<Dish> newMenuNewDish = menuList.getDishByName(newMenuDishName);
                                if (newMenuNewDish.size() > 0) {
                                    dishes.add(newMenuNewDish.get(0));
                                    System.out.println(newMenuDishName + " was added to the menu");
                                } else {
                                    System.out.println("Couldn't find dish " + newMenuDishName);
                                }
                                break;

                            case '2':
                                System.out.println("The menu creator is stopped.");
                                break;

                            default:
                                System.out.println("Invalid input - must enter 1 or 2");
                                System.out.println();
                                break;
                        }
                    } while(p != '2');
                    menuList.newMenu(dishes);
                    break;

                case '5':
                    in.nextLine();
                    System.out.println("Min price: ");
                    double min = in.nextDouble();
                    System.out.println("Max price: ");
                    double max = in.nextDouble();
                    ArrayList<Menu> menus = menuList.getDishesBetweenPrices(min, max);
                    System.out.println("Menus between prices " + min + " and " + max + ": ");
                    for (int i = 0; i < menus.size(); i++) {
                        System.out.println("Menu nr " + (i + 1) + ":");
                        System.out.println(menus.get(i).toString() + '\n');
                    }
                    break;

                case '6':
                    System.out.println("The program is stopped.");
                    break;

                default:
                    System.out.println("Invalid input - must enter 1,2,3,4,5 or 6");
                    System.out.println();
                    break;
            }
            System.out.println();
        }
        while(k != '6');
    }
}
