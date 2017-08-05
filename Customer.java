package FlooristShop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Customer {

    private String name;
    private double money;
    private ShoppingCart shoppingCart;

    Customer(String name, int money) {
        this.money = money;
        this.name = name;
        shoppingCart = new ShoppingCart(this);
    }

    void get(Flower flower) {
        shoppingCart.add(flower, flower.getAmount());
    }

    String getName() {
        return name;
    }

    ShoppingCart getShoppingCart() {

        return shoppingCart;
    }

    void pay() {

        List<Flower> temp = new ArrayList();
        int amountToPay = 0;
        for (Map.Entry<Flower, Integer> pair : shoppingCart.getShoppingCartMap().entrySet()) {

            if (PriceList.getPrice(pair.getKey()) < 0) {
                temp.add(pair.getKey());
            } else {
                amountToPay += PriceList.getPrice(pair.getKey()) * pair.getValue();
            }
            if (amountToPay > money) {
                amountToPay -= PriceList.getPrice(pair.getKey()) * pair.getValue();

                temp.add(pair.getKey());
                money += amountToPay;

            }
            money -= amountToPay;
        }
        for (Flower f : temp) {
            shoppingCart.remove(f);
        }
    }

    String getCash() {
        return String.format("%.2f", money);
    }

    void pack(Box pudlo) {

        for (Map.Entry<Flower, Integer> pair : shoppingCart.getShoppingCartMap().entrySet()
                ) {
            pudlo.add(pair);
        }
        shoppingCart = new ShoppingCart(this);
    }
}
