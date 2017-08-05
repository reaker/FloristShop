package FlooristShop;

import java.util.HashMap;
import java.util.Map;

public class PriceList {
    private static PriceList instance = null;

    private static Map<Flower, Integer> map = new HashMap<>();

    private PriceList() {
    }

    static PriceList getInstance() {
        if (instance == null) {
            instance = new PriceList();
        }
        return instance;
    }

    public static Map<Flower, Integer> getMap() {
        return map;
    }

    static double getPrice(Flower flower) {

        if (map.containsKey(flower)) {
            return map.get(flower);
        }

        return -1;
    }

    void set(String name, int amount) {

        map.put(FactoryFlower.getFlower(name), amount);
    }
}


