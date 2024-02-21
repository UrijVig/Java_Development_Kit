public class Calc {
    private static <T extends  Number> void  sum(T num1, T num2){
        try {
            System.out.println(parse(num1) + parse(num2));
        } catch (Exception e) {
            System.out.println("что-то пошло не так!" + e.getMessage());
        }
    }
    private static <T extends  Number> void  subtract(T num1, T num2){
        try {
            System.out.println(parse(num1) - parse(num2));
        } catch (Exception e) {
            System.out.println("что-то пошло не так!" + e.getMessage());
        }
    }
    private static <T extends  Number> void  multiply(T num1, T num2){
        try {
            System.out.println(parse(num1) * parse(num2));
        } catch (Exception e) {
            System.out.println("что-то пошло не так!" + e.getMessage());
        }
    }
    private static <T extends  Number> void  divide(T num1, T num2){
        if (!num2.equals(0)) {
            try {
                System.out.println(parse(num1) / parse(num2));
            } catch (Exception e) {
                System.out.println("что-то пошло не так!" + e.getMessage());
            }
        }
    }
    private static <T extends Number> Double parse(T num){
        if (num instanceof Integer){
            return Double.parseDouble(String.valueOf((int) num));
        }else if (num instanceof Double){
            return (double) num;
        } else if (num instanceof Float){
            return Double.parseDouble(String.valueOf((float) num));
        }else if (num instanceof Byte){
            return Double.parseDouble(String.valueOf((byte) num));
        }else if (num instanceof Long){
            return Double.parseDouble(String.valueOf((long) num));
        } else if (num instanceof Short){
            return Double.parseDouble(String.valueOf((int) num));
        }
        return null;
    }

    public static void main(String[] args) {
        int ints = 147;
        byte bytes = 12;
        double doubles = 14.5;
        float floats = 235;
        char chars = 'f';
        int nul = 0;
        sum(ints, bytes);
        sum(doubles, bytes);
//        sum(chars, bytes);
        sum(ints, floats);
        subtract(ints, doubles);
        subtract(bytes, doubles);
        subtract(floats, doubles);
        multiply(ints, doubles);
        multiply(bytes, floats);
        multiply(ints, floats);
        divide(ints, doubles);
        divide(ints, nul);
    }
}
