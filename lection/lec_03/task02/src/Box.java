import java.util.ArrayList;

public class Box <T extends Fruit>{
    private final ArrayList<T> inBox;

    public Box(ArrayList<T> inBox) {
        this.inBox = inBox;
    }

    public double getWeight(){
        double temp = 0;
        for (T emp: inBox) {
            temp += emp.getWeight();
        }
        return temp;
    }
    public void pourOver(Box<T> o){
//        T temp;
//        while ((temp = o.inBox.removeLast()) != null){
//            this.inBox.add(temp);
//        }
        o.inBox.removeAll(this.inBox);
    }

    public boolean  compare(Box<T> o) {
        return this.getWeight() == o.getWeight();
    }
}
