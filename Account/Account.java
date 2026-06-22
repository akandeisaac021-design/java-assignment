import java.math.BigDecimal;

public class Account{

    private BigDecimal balance;
    private boolean userId; 
    private boolean password;

    public Account(boolean userId, boolean password, BigDecimal initialBalance){
        this.userId =userId;
        this.password =password;
        this.balance =(initialBalance != null) ? initialBalance : BigDecimal.ZERO;
    }

    public void createAccount(boolean userId, boolean password){
        if (validateUser(userId, password)){
            this.userId =userId;
            this.password =password;
        }
    }

    public void deposit(BigDecimal amountToBeDeposited){
        if (amountToBeDeposited !=null && amountToBeDeposited.compareTo(BigDecimal.ZERO) >0){
            this.balance =this.balance.add(amountToBeDeposited);
        }
    }

    public void withdrawal(BigDecimal amountToBeWithrawal){
        if (amountToBeWithrawal !=null && amountToBeWithrawal.compareTo(BigDecimal.ZERO) >0 && amountToBeWithrawal.compareTo(this.balance) <=0){
            this.balance =this.balance.subtract(amountToBeWithrawal);
        }
    }

    public BigDecimal getBalance(boolean userId, boolean password){
        if (validateUser(userId, password)){
            return this.balance;
        }
        return new BigDecimal("-1");
    }

    public void updatePin(boolean userId, boolean password){
        if (validateUser(userId, password)){
            this.password =password;
        }
    }

    public boolean validateUser(boolean userId, boolean password){
        return this.userId ==userId && this.password ==password;
    }
}
