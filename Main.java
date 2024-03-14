import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        String id;
        String name;
        int balance;
        Account acc;
        int choice;
        int accNo;
        int amount;

        System.out.println("Enter no. of Account");
        n = Integer.parseInt(br.readLine());

        Account[] accArr = new Account[n];
        
        for(int i = 0; i < n; i++) {
            System.out.println("Enter the Account id : ");
            id = br.readLine();

            System.out.println("Enter the Account holder name : ");
            name = br.readLine();

            System.out.println("Enter the balance : ");
            balance = Integer.parseInt(br.readLine());

            acc = new Account(id, name, balance);
            accArr[i] = acc;
        }
        do {
            System.out.println("1.Credit");
            System.out.println("2.Debit");
            System.out.println("3.Amount Transfer");
            System.out.println("Enter your choice");
            choice = Integer.parseInt(br.readLine());
            switch(choice) {
                case 1 : 
                    display(accArr);
                    System.out.println("Enter Account No :");
                    accNo = Integer.parseInt(br.readLine());
                    acc = accArr[accNo - 1];
                    System.out.println("Enter amount to deposit :");
                    amount = Integer.parseInt(br.readLine());
                    System.out.println("Account credited with " + amount);
                    System.out.println("The balance is " + acc.credit(amount));
                    break;
                
                case 2 :
                    display(accArr);
                    System.out.println("Enter Account No :");
                    accNo = Integer.parseInt(br.readLine());
                    acc = accArr[accNo - 1];
                    System.out.println("Enter amount to withdraw:");
                    amount = Integer.parseInt(br.readLine());
                    Integer updatedBalance = acc.debit(amount);
                    if(updatedBalance != null) {
                        System.out.println("Balance after withdrawal : " + acc.getBalance());
                    }
                    else {
                        System.out.println("ERROR ! : Withdrawal amount exceeds balance");
                        System.out.println("The current balance is " + acc.getBalance());
                    }
                    break;
                
                case 3 :
                    display(accArr);
                    System.out.println("Enter your account no. ");
                    int senderAccNo = Integer.parseInt(br.readLine());
                    System.out.println("Enter the recipient's account no.: ");
                    int recipientAccNo = Integer.parseInt(br.readLine());
                    System.out.println("Enter the amount to transfer: ");
                    int transferAmount = Integer.parseInt(br.readLine());

                    Account sender = accArr[senderAccNo - 1];
                    Account recipient = accArr[recipientAccNo - 1];

                    Integer remainingBalance = sender.transferTo(recipient, transferAmount);
                    if (remainingBalance != null) {
                        System.out.println("Transfer successful!");
                        System.out.println("Remaining balance in sender's account: " + remainingBalance);
                        System.out.println("Recipient's account balance after transfer: " + recipient.getBalance());
                    } 
                    else {
                        System.out.println("ERROR! Insufficient balance for transfer.");
                        System.out.println("Current balance in sender's account: " + sender.getBalance());
                    }
                    break;
            }

        }while(choice >= 1 && choice <= 3);
         
    }
    public static void display(Account[] accArr) {
        for(int i = 0; i < accArr.length; i++) {
            System.out.println("Acc : " + (i + 1) + " " + accArr[i].toString());
        }
    }
}
