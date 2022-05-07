class CheckingAccount extends Account{

	private int checksWritten = 0;

	public CheckingAccount (double initBalance){
		super(initBalance);
		checksWritten = 0;
	}

	public int getChecksWritten(){
		return checksWritten;
	}

	public void writeCheck(double amount){
		checksWritten++;
		super.withdraw(amount);
	}
	































}
