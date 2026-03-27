package DataStructure.LinkedList;
public class test {
    public static void main(String[] args) {
        List<Integer> list= new LinkedList<>();
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(1,90);
        list.add(list.size(),100);
        System.out.println(list.toString());
    }
}
