public class Car extends Vehicle {
    private final int passengerCount;

    public Car(String brand, String model, int year, int enginePower, String engineType, int passengerCount) {
        super(brand, model, year, enginePower, engineType);
        if (passengerCount <= 0) {
            throw new IllegalArgumentException("Число пассажиров должно быть положительным.");
        }
        this.passengerCount = passengerCount;
    }

    @Override
    public void move() {
        System.out.println("Легковой автомобиль едет по дороге.");
    }

    public void openTrunk() {
        System.out.println("Багажник открыт. Мест для пассажиров: " + passengerCount);
    }
}
