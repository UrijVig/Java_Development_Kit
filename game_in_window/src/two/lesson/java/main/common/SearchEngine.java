package two.lesson.java.main.common;

public interface SearchEngine<T> {
    default boolean insertElement(T[] arr, T element){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                arr[i] = element;
                return true;
            }
        }
        return false;
    }
    default int findElement(T[] arr, T element){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(element)){
                return i;
            }
        } return -1;
    }
    default boolean removeElement(T[] arr){
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != null){
                arr[i] = null;
                return true;
            }
        } return false;
    }
}
