import java.util.ArrayList;
import java.util.List;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;

    public Branch(String branchName) {
        this.name = branchName;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customerName, double initialTransaction) {
        if (findCustomer(customerName) != null) {
            System.out.println("Customer: " + customerName + " already exists.");
            return false;
        }
        customers.add(new Customer(customerName, initialTransaction));
        System.out.println("new Customer: " + customerName + " will be added.");
        return true;
    }

    public boolean addCustomerTransaction(String customerName, double transaction) {
        Customer existingCustomer = findCustomer(customerName);
        if (existingCustomer != null) {
           existingCustomer.addTransaction(transaction);
           System.out.println("Transaction of: " + transaction + " will be added to " + customerName);
            return true;
        }
        System.out.println("Customer: " + customerName + " doesn't exists");
        return false;
    }

    private Customer findCustomer(String customerName) {

        for(Customer customer : customers) {
            if (customer.getName().equals(customerName)) {
                return customer;
            }
        }
        System.out.println("findCustomer ->" + customerName + " not found");
        return null;
    }
}
