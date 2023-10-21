public class MainActivity1 {
    public static void main(String[] args) {
      
        MyClass obj1 = new MyClass();
        MyClass obj2 = new MyClass();
        MyClass obj3 = new MyClass();

        int count = MyClass.getInstanceCount();
        System.out.println("Number of MyClass instances: " + count);

        double[] numbers = { 1.0, 2.0, 3.0, 4.0, 5.0 };
        double average = calAverage.calculateAverage(numbers);
        System.out.println("Average of numbers: " + average);
    }
}
