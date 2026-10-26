public class Truck extends Vehicle {
    private final double maxLoad;
    private double currentLoad;

    public Truck(String brand, String model, int year, int enginePower, String engineType, double maxLoad) {
        super(brand, model, year, enginePower, engineType);
        if (!Double.isFinite(maxLoad) || maxLoad <= 0) {
            throw new IllegalArgumentException("Грузоподъёмность должна быть больше нуля.");
        }
        this.maxLoad = maxLoad;
    }

    @Override
    public void move() {
        System.out.println("Грузовик перевозит груз по дороге.");
    }

    public void loadCargo(double weight) {
        if (!Double.isFinite(weight) || weight <= 0) {
            System.out.println("Масса груза должна быть больше нуля.");
        } else if (weight > maxLoad - currentLoad) {
            System.out.println("Груз превышает оставшуюся грузоподъёмность.");
        } else {
            currentLoad += weight;
            System.out.printf("Груз погружен. Текущая масса: %.1f т из %.1f т.%n", currentLoad, maxLoad);
        }
    }
}
