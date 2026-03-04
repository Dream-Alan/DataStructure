package DataStructure.DynamicArray;

public class Assert {
    public static void test(boolean value){
        try {
            throw new IllegalArgumentException("error");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
