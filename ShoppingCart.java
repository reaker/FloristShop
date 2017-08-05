package FlooristShop;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private String owner;
    private Map<Flower, Integer> shoppingCartMap = new HashMap<>();

    ShoppingCart(Customer customer) {
        owner = customer.getName();
    }

    private String listOfFlowers() {
        String temp = "";

        for (Map.Entry<Flower, Integer> pair : shoppingCartMap.entrySet()) {
            temp += pair.getKey() + ", kolor: " + pair.getKey().getColor() + ", ilość: " + pair.getValue() + ", cena " + PriceList.getPrice(pair.getKey()) + "\n";

        }
        return temp;
    }

    @Override
    public String toString() {
        if (shoppingCartMap.size() == 0) {
            return " -- pusto";
        }
        return "Wózek właściciel " + owner + "\n" + listOfFlowers();
    }

    Map<Flower, Integer> getShoppingCartMap() {
        return shoppingCartMap;
    }

    void add(Flower flower, int amount) {
        shoppingCartMap.put(flower, amount);
    }

    void remove(Flower flower) {
        shoppingCartMap.remove(flower);
    }
}
