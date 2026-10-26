public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car("Toyota", "Corolla", 2020, 122, "бензиновый", 5);
        Vehicle motorcycle = new Motorcycle("Honda", "CB500F", 2022, 47, "бензиновый", false);
        Vehicle truck = new Truck("Volvo", "FH", 2021, 500, "дизельный", 10.0);

        Vehicle prototype = new Vehicle("Учебный", "Прототип", 2026, 80, "электрический") {
            @Override
            public void move() {
                System.out.println("Прототип проходит испытание на полигоне.");
            }
        };

        Vehicle[] vehicles = {car, motorcycle, truck, prototype};

        for (Vehicle vehicle : vehicles) {
            vehicle.printInfo();
            vehicle.move();

            if (vehicle instanceof Car) {
                Car selectedCar = (Car) vehicle;
                selectedCar.openTrunk();
            } else if (vehicle instanceof Motorcycle) {
                Motorcycle selectedMotorcycle = (Motorcycle) vehicle;
                selectedMotorcycle.doWheelie();
            } else if (vehicle instanceof Truck) {
                Truck selectedTruck = (Truck) vehicle;
                selectedTruck.loadCargo(4.0);
                selectedTruck.loadCargo(7.0);
            }

            System.out.println();
        }

        if (motorcycle instanceof Car) {
            Car wrongCar = (Car) motorcycle;
            wrongCar.openTrunk();
        } else {
            System.out.println("Мотоцикл нельзя привести к Car: проверка instanceof предотвратила ошибку.");
        }
    }
}
