import java.util.HashMap;
import java.util.Map;

public class Customer {
    private String name;
    private String contactInformation;
    private Map<String, RentalTransactions> rentalHistory;

    public Customer(String name, String contactInformation) {
        this.name = name;
        this.contactInformation = contactInformation;
        this.rentalHistory = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void addRentalTransaction(String rentalId, RentalTransactions updatedTransaction) {
        rentalHistory.put(rentalId, updatedTransaction);
    }

    public void updateRentalTransaction(String rentalId, RentalTransactions updatedTransaction) {
        if (rentalHistory.containsKey(rentalId)) {
            rentalHistory.put(rentalId, updatedTransaction);
        }
    }

    public void deleteRentalTransaction(String rentalId) {
        rentalHistory.remove(rentalId);
    }

    public void displayRentalHistory() {
        System.out.println("Rental History for customer " + this.name);
        for (RentalTransactions rentalTransactionsa : rentalHistory.values()) {
            System.out.println(rentalTransactionsa.toString());
        }
    }

    @Override
    public String toString() {
        return "Customer [name=" + name + ", contactInformation=" + contactInformation;
    }

}
