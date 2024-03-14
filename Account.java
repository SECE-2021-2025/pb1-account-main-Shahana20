public class Account {

    //Class variables
    private String id;
    private String name;
    private Integer balance;

    //Parameterized constructor for 2 parameters(id, name)
    Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    //Parameterized constructor for 2 parameters(id, name, balance)
    Account(String id, String name, Integer balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }


    //Getter - retrieves class variable
    //Setter - Assigns local variable to class variable
    //this.<variable name> - class variable

    //Getter & setter for id
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }

    //Getter & setter for name
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    //Getter & setter for balance
    public Integer getBalance() {
        return this.balance;
    }
    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account[ id = " + this.id + " name = " + this.name + " balance = " + this.balance + " ]";
    }
    
    //Credit functionality
    public Integer credit(Integer amount) {
        this.balance += amount;
        return this.balance;
    }

    //Debit functionality
    public Integer debit(Integer amount) {
        if(this.balance >= amount) {
            this.balance -= amount;
            return this.balance;
        }
        else {
            return null;
        }
    }

    //Account Transfer functionality
    public Integer transferTo(Account acc, Integer amount) {
        if(amount <= this.balance) {
            acc.setBalance(acc.getBalance() + amount);
            this.balance -= amount;
            return this.balance;
        }
        else {
            return null;
        }
    }

}