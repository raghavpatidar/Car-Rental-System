// Car Rental System
// Design a Java program to manage a car rental system using a HashMap<String, Boolean>, where the key is the car
//  registration number, and the value is a boolean indicating whether the car is available or not.
// Implement methods to add a new car, rent a car, return a car, and display the list of available cars.

import java.util.HashMap;
import java.util.Map;

public class CarRentalSystem {
    private Map<String, Car> cars;
    private Map<String, Customer> customers;
    private Map<String, RentalTransactions> rentalHistory;

    CarRentalSystem() {
        cars = new HashMap<>();
        customers = new HashMap<>();
        rentalHistory = new HashMap<>();
    }

    public void addCard(String registationNumber, Car car) {
        if (!cars.containsKey(registationNumber)) {
            cars.put(registationNumber, car);
            System.out.println("Car with registation number: " + registationNumber + " Added");

        } else {
            System.out.println("Car with registation number: " + registationNumber + " Already Exits");
        }
    }

    public void updateCar(String registationNumber, Car updateCar) {
        if (cars.containsKey(registationNumber)) {
            cars.put(registationNumber, updateCar);
            System.out.println("Car with registation number: " + registationNumber + " Updated");

        } else {
            System.out.println("Car with registation number " + registationNumber + " Not Found");
        }
    }

    public void deleteCar(String registationNumber) {
        if (cars.containsKey(registationNumber)) {
            cars.remove(registationNumber);
            System.out.println("Car with registation number: " + registationNumber + " Removed");

        } else {
            System.out.println("Car with registation number " + registationNumber + " Not Found");
        }
    }

    public void viewCar() {
        for (Car car : cars.values()) {
            System.out.println(car);
        }
    }

    public void addCustomer(String custerId, Customer customer) {
        if (!customers.containsKey(custerId)) {
            customers.put(custerId, customer);
            System.out.println("Customer with curtomerID : " + custerId + " Added");
        } else {
            System.out.println("Customer with curtomerID : " + custerId + " Already Exits");
        }
    }

    public void updateCustomer(String custerId, Customer customer) {
        if (customers.containsKey(custerId)) {
            customers.put(custerId, customer);
            System.out.println("Customer with curtomerID : " + custerId + " Updated");
        } else {
            System.out.println("Customer with curtomerID : " + custerId + " Not found");
        }
    }

    public void deleteCustomer(String custerId) {
        if (customers.containsKey(custerId)) {
            customers.remove(custerId);
            System.out.println("Customer with curtomerID : " + custerId + " Removed");
        } else {
            System.out.println("Customer with curtomerID : " + custerId + " Not Found");
        }
    }

    public void viewCustomer() {
        System.out.println("List of Customers");
        for (Customer customer : customers.values()) {
            System.out.println(customer);
        }
        System.out.println();
    }

    public void rentCar(String rentalID, String rentalDate, String returnDate, int returnDuration, String customerID,
            String registrationNumber) {
        Customer customer = customers.get(customerID);
        Car car = cars.get(registrationNumber);
        System.out.println("Rent Car " + car + customer);

        if (customer != null && car != null && car.getAvaiable()) {
            RentalTransactions rentalTransactions = new RentalTransactions(rentalDate, returnDate, returnDuration,
                    customer, car);
            rentalHistory.put(rentalID, rentalTransactions);
            car.setAvaiable(false);
            customer.addRentalTransaction(rentalID, rentalTransactions);
            System.out.println("Car Rented Successfulyy");
        } else {
            System.out.println("Cannot be rent");
        }
    }

    public void returnCar(String rentalID, String returnDate) {
        if (rentalHistory.containsKey(rentalID)) {
            RentalTransactions rentalTransactions = rentalHistory.get(rentalID);
            rentalTransactions.getCar().setAvaiable(true);
            rentalTransactions.getCustomer().updateRentalTransaction(rentalID,
                    new RentalTransactions(rentalTransactions.getRentalDate(), returnDate,
                            rentalTransactions.getRentalDuration(), rentalTransactions.getCustomer(),
                            rentalTransactions.getCar()));
            rentalHistory.remove(rentalID);
            System.out.println("Car Returned Successfully");

        } else {
            System.out.println("Not Found");
        }
    }

    public void viewReanalHistoryByCustomer(String customerId) {

        if (customers.containsKey(customerId)) {
            // System.out.println("King");
            customers.get(customerId).displayRentalHistory();
        }
        System.out.println();
    }

    public void viewRentalHistoryByCar(String registationNumber) {
        for (RentalTransactions rentalTransactions : rentalHistory.values()) {
            if (rentalTransactions.getCar().getRegistationNumber().equals(registationNumber)) {
                System.out.println(rentalTransactions);
            }
        }
        System.out.println();
    }

}
