package FlooristShop;

public abstract class Flower {

    private String color;
    private String name;

    private int amount;

    public Flower(String name) {
        this.name = name;
    }

    public Flower(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Flower(String name, String color, int amount) {
        this.name = name;
        this.color = color;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flower flower = (Flower) o;

        if (!color.equals(flower.getColor())) return false;
        return name.equals(flower.getName());
    }

    @Override
    public int hashCode() {
        int result = color.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    String getColor() {
        return color;
    }

    int getAmount() {
        return amount;
    }
}
