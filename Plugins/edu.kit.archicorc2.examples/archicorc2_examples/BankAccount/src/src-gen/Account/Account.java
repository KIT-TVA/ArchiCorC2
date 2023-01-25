package Account;

class Account implements interfaces.IAccount {
	private int balance;
	private int OVERDRAFT_LIMIT;

	/***** GETTER ******/
	/*@
	@ requires true;
	@ ensures \result == balance;
	@*/
	public int get_balance() {
		return balance;
	}

	/*@
	@ requires true;
	@ ensures \result == OVERDRAFT_LIMIT;
	@*/
	public int get_OVERDRAFT_LIMIT() {
		return OVERDRAFT_LIMIT;
	}

	/***** SETTER ******/
	/*@
	@ requires true;
	@ ensures balance == balance_arg1;
	@ assignable balance;
	@*/
	public int set_balance(int balance_arg1) {
		this.balance = balance_arg1;
	}

	/*@
	@ requires true;
	@ ensures OVERDRAFT_LIMIT == OVERDRAFT_LIMIT_arg1;
	@ assignable OVERDRAFT_LIMIT;
	@*/
	public int set_OVERDRAFT_LIMIT(int OVERDRAFT_LIMIT_arg1) {
		this.OVERDRAFT_LIMIT = OVERDRAFT_LIMIT_arg1;
	}

	/***** OBJECTS ******/
	// None

	/***** METHODS ******/

	/*@
	@ requires true;
	@ ensures (\result ==> balance == old(balance)+x) && (!\result ==> balance == old(balance));
	@ assignable balance;
	@*/
	public boolean update(int x) {
		int newBalance;
		newBalance = balance + x;
		if (newBalance < this.OVERDRAFT_LIMIT) {
			ret = false;
		} else if (newBalance >= this.OVERDRAFT_LIMIT) {
			balance = newBalance;
			ret = true;
		}
		return ret;
	}

	/*@
	@ requires true;
	@ ensures (\result ==> balance == old(balance)-x) && (!\result ==> balance == old(balance));
	@ assignable balance;
	@*/
	public boolean undoUpdate(int x) {
		int newBalance;
		newBalance = balance - x;
		if (newBalance < this.OVERDRAFT_LIMIT) {
			ret = false;
		} else if (newBalance >= this.OVERDRAFT_LIMIT) {
			balance = newBalance;
			ret = true;
		}
		return ret;
	}
}