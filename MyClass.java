public class MyClass {
       private static int instanceCount = 0;

   
    public MyClass() {
        instanceCount++;
    }

    public static int getInstanceCount() {
        return instanceCount;
    }
}



