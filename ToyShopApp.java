public class ToyShopApp {
    public static void main(String[] args) {
        ToyShop toyShop = new ToyShop();
        toyShop.addToy(1, "Teddy Bear", 5, 30);
        toyShop.addToy(2, "Toy Car", 8, 20);
        toyShop.addToy(3, "Doll", 6, 25);

        toyShop.updateToyWeight(1, 40);
        toyShop.updateToyWeight(2, 15);
        toyShop.updateToyWeight(3, 35);

        Toy prizeToy = toyShop.choosePrizeToy();
        toyShop.awardPrize(prizeToy);
    }
}
