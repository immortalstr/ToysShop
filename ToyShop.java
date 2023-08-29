import java.io.*;
import java.util.*;

class ToyShop {
    private List<Toy> toys;

    public ToyShop() {
        toys = new ArrayList<>();
    }

    public void addToy(int id, String name, int quantity, double weight) {
        Toy toy = new Toy(id, name, quantity, weight);
        toys.add(toy);
    }

    public void updateToyWeight(int id, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                break;
            }
        }
    }

    public Toy choosePrizeToy() {
        double totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }

        double randomValue = Math.random() * totalWeight;
        double cumulativeWeight = 0;
        for (Toy toy : toys) {
            cumulativeWeight += toy.getWeight();
            if (randomValue <= cumulativeWeight) {
                return toy;
            }
        }

        return null;
    }

    public void awardPrize(Toy prizeToy) {
        if (prizeToy != null && prizeToy.getQuantity() > 0) {
            System.out.println("Congratulations! You won: " + prizeToy.getName());
            prizeToy.setQuantity(prizeToy.getQuantity() - 1);
            savePrizeToyToFile(prizeToy);
        } else {
            System.out.println("No prize available.");
        }
    }

    private void savePrizeToyToFile(Toy prizeToy) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("prize_list.txt", true))) {
            writer.write(prizeToy.getName());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
