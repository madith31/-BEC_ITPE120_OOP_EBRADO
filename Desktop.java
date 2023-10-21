class Desktop extends Computer {
    int ramSpeed;

    Desktop(String brand, int year, int ramSpeed) {
        super(brand, year); // Calls the base class constructor
        this.ramSpeed = ramSpeed;
    }

    void start() {
        super.start(); // Calls the base class method
        System.out.println("Desktop is starting.");
    } 
    void close() {
        super.close(); // Calls the base class method
        System.out.println("Desktop is shutdown.");
    }   
    void RandomAccessMemorySpeed() {
        System.out.println("Desktop is quickly read and write data to and from memory at " + ramSpeed + " MHz.");
    }
}