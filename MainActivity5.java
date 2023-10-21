public class MainActivity5{
    public static void main(String[] args) {
        for (Color color : Color.values()) {
            System.out.println(color + " - " + color.getRGBValues());
        }
    }
}