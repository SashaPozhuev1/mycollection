package mycollection;

public class Main {
    public static void main(String[] args){
        MyCollection<String> strings = new MyCollection<>("name");
        String string1 = new String("из переменной");

        strings.add("Привет");
        strings.add(string1);
        strings.add(null);

        System.out.println(
                strings.get(0)
                + " "
                + strings.get(1)
                + " "
                + strings.get(2)
                + " "
                + strings.get(3)
        );

        MyCollection<Integer> ints = new MyCollection<Integer>();
        for(int i = 0; i < 33; ++i){
            ints.add(i);
        }
        for(int i = 0; i <= 34; ++i){
            System.out.println(ints.get(i));
        }
        System.out.println(strings.getHead());
    }
}
