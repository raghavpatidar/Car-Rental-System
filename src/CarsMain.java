import java.util.Scanner;

public class CarsMain {
    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println(
                    " Rental Menu \n1.  Car Menu \n2.  Customer  Menu \n3. Rent a Car \n4. View Rental History by Customer \n5. View Rental History by Car \n6. Return Car \n7. Exit");
            System.out.print("Enter you Choice : ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("1. Add Car \n2. Update Car \n3. Delete Car \n4. view Car");
                    int carChoice = scanner.nextInt();

                    switch (carChoice) {
                        case 1:
                            System.out.println("Enter Details for Car To be added");
                            Car car = createCareFromUserInput(scanner);
                            rentalSystem.addCard(car.getRegistationNumber(), car);
                            System.out.println();
                            break;
                        case 2:
                            System.out.println("Enter Details for Car to be updated");
                            Car updatecar = createCareFromUserInput(scanner);
                            rentalSystem.updateCar(updatecar.getRegistationNumber(), updatecar);
                            System.out.println();
                            break;
                        case 3:
                            System.out.println("Enter Registration number");
                            String registationNumbertobeDeleted = scanner.next();
                            rentalSystem.deleteCar(registationNumbertobeDeleted);
                            System.out.println();
                            break;

                        case 4:
                            System.out.println("Below is details of cars");
                            rentalSystem.viewCar();
                            System.out.println();
                            break;

                        default:
                            System.out.println("Invalid choice");
                            System.out.println();
                            break;
                    }
                    break;

                case 2:
                    System.out.println("1. Add Customer \n2. Update Customer \n3. Delete Customer \n4. view Customer");
                    int customerChoice = scanner.nextInt();

                    switch (customerChoice) {
                        case 1:
                            System.out.println("Enter Details for Customer");
                            Customer customer = createCustomerFromUserInput(scanner);
                            System.out.print("Enter Customer ID : ");
                            String customerID = scanner.next();
                            rentalSystem.addCustomer(customerID, customer);
                            System.out.println();
                            break;
                        case 2:
                            System.out.println("Enter Details for Car to be updated");
                            Customer updatecustomer = createCustomerFromUserInput(scanner);
                            System.out.print("Enter Customer ID : ");
                            String updatecustomerID = scanner.next();
                            rentalSystem.updateCustomer(updatecustomerID, updatecustomer);
                            System.out.println();
                            break;
                        case 3:
                            System.out.println("Enter CustomerId number");
                            String deletecutomerId = scanner.next();
                            rentalSystem.deleteCar(deletecutomerId);
                            System.out.println();
                            break;

                        case 4:
                            System.out.println("Below is details of cars");
                            rentalSystem.viewCustomer();
                            System.out.println();
                            break;

                        default:
                            System.out.println("Invalid choice");
                            System.out.println();
                            break;
                    }

                    break;
                case 3:
                    System.out.println("Enter Rental details");
                    System.out.print("Enter Rental ID: ");
                    String rentalID = scanner.next();
                    System.out.print("Enter Rental Date:");
                    String rentalDate = scanner.next();
                    System.out.print("Enter Return Date:");
                    String returnDate = scanner.next();
                    System.out.print("Enter Rental Duration:");
                    int rentalDuration = scanner.nextInt();
                    System.out.print("Enter Customer ID:");
                    String rentcurstomerId = scanner.next();
                    System.out.print("Enter Car Registation Number:");
                    String rentCarRegistationNumber = scanner.next();
                    rentalSystem.rentCar(rentalID, rentalDate, returnDate, rentalDuration, rentcurstomerId,
                            rentCarRegistationNumber);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Enter Customer ID to view Rental History");
                    String viewCustomerHistoryId = scanner.next();
                    rentalSystem.viewReanalHistoryByCustomer(viewCustomerHistoryId);
                    System.out.println();
                    break;
                case 5:

                    System.out.println("Enter Car registationNumber  to view Rental History ");
                    String viewCarHistoryId = scanner.next();
                    rentalSystem.viewRentalHistoryByCar(viewCarHistoryId);
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Enter Return Details");
                    System.out.print("Enter rentalID : ");
                    String returnrentalId = scanner.next();
                    System.out.print("Enter return Date : ");
                    String returnReturnDate = scanner.next();
                    rentalSystem.returnCar(returnrentalId, returnReturnDate);
                    System.out.println();
                    break;
                case 7:
                    System.out.println("Exintg Car Rental System");
                    System.out.println();
                    break;

                default:
                    System.out.println("Invalid choice , Please enter correct chocie");
                    System.out.println();
                    break;
            }
        } while (choice != 7);
    }

    private static Customer createCustomerFromUserInput(Scanner scanner) {
        System.out.print("Enter Name :");
        String name = scanner.next();
        System.out.print("Enter Contact informaction :");
        String contactInformation = scanner.next();
        return new Customer(name, contactInformation);
    }

    private static Car createCareFromUserInput(Scanner scanner) {
        System.out.print("Enter registationNumber: ");
        String registationNumber = scanner.next();
        System.out.print("Enter Make: ");
        String make = scanner.next();
        System.out.print("Enter Model: ");
        String modle = scanner.next();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        System.out.print("Enter color: ");
        String color = scanner.next();
        System.out.print("Enter price: ");
        String price = scanner.next();
        Car car = new Car(registationNumber, make, modle, year, color, price, true);

        System.out.println(car);
        return car;
    }
}
