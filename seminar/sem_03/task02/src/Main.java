public class Main {
    public static void main(String[] args) {
        Object[] arr1 = {"str", 2, 3.7, 't'};
        Object[] arr2 = {"sg", 7, 8.1, 'j'};
        Object[] arr3 = {"str", 2, 3.7};
        Object[] arr4 = {"str", 2, 3, 't'};
        System.out.println(compareArrays(arr1, arr2));
        System.out.println(compareArrays(arr1, arr3));
        System.out.println(compareArrays(arr1, arr4));
    }
    private static <T> boolean compareArrays(T[] arr1, T[] arr2){
        if (arr1.length != arr2.length){
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i].getClass() != arr2[i].getClass()) return  false;
        }
        return true;
    }
}
