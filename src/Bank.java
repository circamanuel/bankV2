import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) != null) {
            return false;
        }
        branches.add(new Branch(branchName));
        return true;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
        Branch branch = findBranch(branchName);

        if (branch == null) {
            return false;
        }
        return branch.newCustomer(customerName, initialTransaction);
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        Branch branch = findBranch(branchName);

        if (branch == null ) {
            return false;
        }
        return branch.addCustomerTransaction(customerName, transaction);
    }

    private Branch findBranch(String branchName) {
        for (Branch branch : branches) {
            if (branch.getName().equals(branchName));
            return branch;
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean printTransaction) {

        Branch branch = findBranch(branchName);
        System.out.println("Customer details for branch " + branchName);

        if (findBranch(branchName) != null) {

            int customerIndex = 1;
            for (Customer customer : branch.getCustomers()) {
                System.out.println("Customer: " +  customer.getName() + "[" + customerIndex + "]");

                if (printTransaction) {
                    System.out.println("Transactions");
                   int transactionIndex = 1;

                   for (Double transaction : customer.getTransactions()) {
                       System.out.println("[" + transactionIndex + "]" + " Amount " + transaction);
                       transactionIndex++;
                   }
                }
            }
            customerIndex++;
        }
        return false;
    }
}

