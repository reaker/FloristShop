package FlooristShop;

class FactoryFlower {

    static Flower getFlower(String name) {
        switch (name) {
            case "frezja":
                return new Freesia();
            case "róża":
                return new Rose();
            case "piwonia":
                return new Peony();
            case "bez":
                return new Lilac();
            case "orchidea":
                return new Orchid();
        }

        return null;
    }

}
