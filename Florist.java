package FlooristShop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Klasa "kwiaciarnia"
class Florist {

    public Florist() {
        // Ustalenie cennika
        PriceList pl = PriceList.getInstance();
        pl.set("róża", 10);
        pl.set("bez", 12);
        pl.set("piwonia", 8);
        pl.set("orchidea", 20);
    }

}

// Klasa testująca
class FloristsTest {
    public static void main(String[] args) {

        // Kwiaciarnia samoobsługowa
        Florist kwiaciarnia = new Florist();

        // Przychodzi klient janek. Ma 200 zł
        Customer janek = new Customer("Janek", 200);

        // Bierze różne kwiaty: 5 róż, 5 piwonii, 3 frezje, 3 bzy
        janek.get(new Rose(5));
        janek.get(new Peony(5));
        janek.get(new Freesia(3));
        janek.get(new Lilac(3));
        janek.get(new Orchid(1));

        // Pewnie je umieścił na wózku sklepowyem
        // Zobaczmy co tam ma
        ShoppingCart wozekJanka = janek.getShoppingCart();
        System.out.println("Przed płaceniem\n" + wozekJanka);

        // Teraz za to zapłaci...
        janek.pay();

        // Czy przypadkiem przy płaceniu nie okazało się,
        // że w wozku są kwiaty na które nie ustalono jescze cceny?
        // W takim razie zostałyby usunięte z wózka i Janek nie płaciłby za nie

        System.out.println("Po zapłaceniu\n" + janek.getShoppingCart());

        // Ile Jankowi zostało pieniędzy?
        System.out.println("Jankowi zostało : " + janek.getCash() + " zł");

        // Teraz jakos zapakuje kwiaty (może do pudełka)
        Box pudelkoJanka = new Box(janek);
        janek.pack(pudelkoJanka);

        // Co jest teraz w wózku Janka...
        // (nie powinno już nic być)

        System.out.println("Po zapakowaniu do pudełka " + janek.getShoppingCart());

        // a co w pudełku:
        System.out.println(pudelkoJanka);

        // Zobaczmy jaka jest wartość czerwonych kwiatów w pudełku Janka
        System.out.println("Czerwone kwiaty w pudełku Janka kosztowały: " +
                valueOf(pudelkoJanka, "czerwony"));

        // Teraz przychodzi Stefan
        // ma tylko 60 zł
        Customer stefan = new Customer("Stefan", 60);

        // ąle nabrał kwiatów nieco za dużo jak na tę sumę
        stefan.get(new Lilac(3));
        stefan.get(new Rose(5));

        // co ma w wózku
        System.out.println(stefan.getShoppingCart());

        // płaci i pakuje do pudełka
        stefan.pay();
        Box pudelkoStefana = new Box(stefan);
        stefan.pack(pudelkoStefana);

        // co ostatecznie udało mu się kupić
        System.out.println(pudelkoStefana);
        // ... i ile zostało mu pieniędzy
        System.out.println("Stefanowi zostało : " + stefan.getCash() + " zł");
    }

    // tu definicja metody valueOf(Box pudelko, String kolor) zwracającej
    // sumaryczną wartość kwiatów o podanym kolorze, znajdujących się w pudełku

    public static double valueOf(Box box, String color) {

        List list = new ArrayList();
        double sum = 0;

        for (Map.Entry<Flower, Integer> pair : box.getListOfFlowers().entrySet()
                ) {
            if (pair.getKey().getColor().equals(color)) {
                sum += pair.getValue() * PriceList.getPrice(pair.getKey());
            }
        }
        return sum;
    }
}