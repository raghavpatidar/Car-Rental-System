public class RentalTransactions {
    private String rentalDate;
    private String returnDate;
    private int rentalDuration;
    private Customer customer;
    private Car car;

    public RentalTransactions(String rentalDate, String returnDate, int rentalDuration,
            Customer customer, Car car) {
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.rentalDuration = rentalDuration;
        this.customer = customer;
        this.car = car;
    }

    public String getRentalDate() {
        return rentalDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Car getCar() {
        return car;
    }

    @Override
    public String toString() {
        return "RentalTransactions: rentalDate: " + rentalDate + ", returnDate: " + returnDate + ", rentalDuration: "
                + rentalDuration;
    }

}
