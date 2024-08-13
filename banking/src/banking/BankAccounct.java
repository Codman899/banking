package banking;

class customException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public customException(String str) {
		super(str);
		
	}
}

public class BankAccounct{
	private String accholder_name;
	private double balance;
	
public BankAccounct  (String accholder_name,double inputamount)throws customException {
	this.accholder_name=accholder_name;
	if(inputamount>0) {
	this.balance=inputamount;
	}
	else {
	throw  new customException("invalid input ammount"); 	
	}
}
 
public void deposit(double dep_amount) throws customException{
	if(dep_amount>0) {
		balance +=dep_amount;
		System.out.println("Ammount: "+dep_amount +" successfully deposited");
	}
	else {
		throw new customException("Deposited amount is not valid");
	}
	
}

public void withdraw(double with_amount) throws customException{
	if(with_amount>0) {
		if(with_amount<balance) {
			balance -= with_amount;
			System.out.println("debited INR "+with_amount);
			
		}
		else {
			throw new customException("!Withdraw amount greater then balance");
		}
	}
	else {
		throw new customException("Withdraw amount not valid ");
	}
	
}

public  void display(){
	System.out.println("Account holder name: "+accholder_name);
	System.out.println("Available Balance: "+balance);
}
public void interest () {
double interest= (balance*0.0685);
System.out.println("you will earn interest of RS "+interest+" for kepting balance for 1 year");
}
	

public static void main(String[] args) throws customException {
		try {
			BankAccounct c = new BankAccounct("Ankit",12000);
			c.display();
			c.deposit(500);
			c.display();
			c.withdraw(4000);
			c.display();
			c.interest();
			
			
		} catch (customException e) {
			System.out.println(e.getMessage());
			
		}
		
	}

}
