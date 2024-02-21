import java.util.Arrays;
import java.util.Objects;

public class Arr <T>{
    public static void main(String[] args) {
        Integer[] ints= {1,3,4,6,7,4,2,3,7};
        String[] strings = {"111","222","3333"};
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(strings));
        Arr<Integer> integerArr = new Arr<>();
        integerArr.swap(ints,3,5);
        Arr<String> str = new Arr<>();
        str.swap(strings,0,2);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(strings));
    }

    private void swap(T[] arr, int num1, int num2){
        T temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }
}
