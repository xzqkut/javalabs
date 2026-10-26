public abstract class Vehicle {
    private final String brand;
    private final String model;
    private final int year;
    private final Engine engine;

    protected Vehicle(String brand, String model, int year, int enginePower, String engineType) {
        if (brand == null || brand.trim().isEmpty() || model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Марка и модель должны быть указаны.");
        }
        if (year <= 0) {
            throw new IllegalArgumentException("Год выпуска должен быть положительным.");
        }

        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engine = new Engine(enginePower, engineType);
    }

    public final void printInfo() {
        System.out.println(brand + " " + model + ", " + year + " год");
        engine.printEngineInfo();
    }

    public abstract void move();

    private final class Engine {
        private final int power;
        private final String type;

        private Engine(int power, String type) {
            if (power <= 0 || type == null || type.trim().isEmpty()) {
                throw new IllegalArgumentException("Укажите мощность и тип двигателя.");
            }

            this.power = power;
            this.type = type;
        }

        private void printEngineInfo() {
            System.out.println("Двигатель: " + type + ", " + power + " л. с.");
        }
    }
}
