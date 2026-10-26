public class Motorcycle extends Vehicle {
    private final boolean hasSidecar;

    public Motorcycle(String brand, String model, int year, int enginePower, String engineType, boolean hasSidecar) {
        super(brand, model, year, enginePower, engineType);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void move() {
        System.out.println("Мотоцикл едет по дороге.");
    }

    public void doWheelie() {
        if (hasSidecar) {
            System.out.println("С коляской нельзя поднять переднее колесо.");
        } else {
            System.out.println("Мотоцикл едет на заднем колесе.");
        }
    }
}
