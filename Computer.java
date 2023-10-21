class Computer {
    String brand;
    int year;

    Computer(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    void start() {
        System.out.println("Computer is open");
    }

    void close() {
        System.out.println("Computer is close");
    }
}