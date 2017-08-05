package FlooristShop;

import java.util.Map;

public class Box {

    private Customer customer;
    private Map<Flower, Integer> listOfFlowers;

    Box(Customer customer) {
        this.customer = customer;
        listOfFlowers = customer.getShoppingCart().getShoppingCartMap();
    }

    @Override
    public String toString() {
        String first = "Pudełko własciciel " + customer.getName();
        String temp = "";

        for (Map.Entry<Flower, Integer> pair : listOfFlowers.entrySet()) {
            temp += pair.getKey() + ", kolor: " + pair.getKey().getColor() + ", ilość: " + pair.getValue() + ", cena " + PriceList.getPrice(pair.getKey()) + "\n";
        }
        return first + "\n" + temp;
    }

    public Customer getCustomer() {
        return customer;
    }

    Map<Flower, Integer> getListOfFlowers() {
        return listOfFlowers;
    }

    void add(Map.Entry<Flower, Integer> pair) {
        listOfFlowers.put(pair.getKey(), pair.getValue());

    }
}
