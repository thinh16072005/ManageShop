package model;
import java.util.ArrayList;
import java.util.function.Predicate;

public class FruitManager {
    private final ArrayList<Fruit> fruitList;
    
    public ArrayList<Fruit> getFruitList() {
        return fruitList;
    }
    
    public FruitManager() {
        fruitList = new ArrayList<>();
    }

    public boolean isEmptyProduct() {
        return fruitList.isEmpty();
    }

    public void addFruit(Fruit fruit) {
        fruitList.add(fruit);
    }

    public void showFruit() {
        for (Fruit fruit : fruitList) {
            System.out.println(fruit);
        }
    }

    public ArrayList<Fruit> search(Predicate<Fruit> con) {
        ArrayList<Fruit> result = new ArrayList<>();
        for (Fruit fruit : fruitList) {
            if (con.test(fruit)) {
                result.add(fruit);
            }
        }
        return result;
        
    }

}
