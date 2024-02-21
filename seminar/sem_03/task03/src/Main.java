import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> pair1 = new Pair<>("string", 32542);
        System.out.println(pair1.getFirst());
        System.out.println(pair1.getSecond());
        System.out.println(pair1);

        ArrayList<Character> list = new ArrayList<>();
        list.add('r');
        list.add('e');
        list.add('f');
        Pair<ArrayList<Character>, Integer> pair2 = new Pair<>(list, 32542);
        System.out.println(pair2.getFirst());
        System.out.println(pair2.getSecond());
        System.out.println(pair2);

        Integer[] ints = {213,45,7};
        Pair<Integer[], Integer> pair3 = new Pair<>(ints, 32542);
        System.out.println(Arrays.toString(pair3.getFirst()));
        System.out.println(pair3.getSecond());
        System.out.println(pair3);
    }
}

