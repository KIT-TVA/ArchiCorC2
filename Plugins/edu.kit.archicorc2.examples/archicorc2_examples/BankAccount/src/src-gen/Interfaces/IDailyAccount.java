package Interfaces;

interface IDailyAccount {
	/*@
	@ requires true;
	@ ensures (\result ==> balance == \old(balance)+x) && (!\result ==> balance == \old(balance));
	@ ensures (\result ==> withdraw <= \old(withdraw)) && (!\result ==> withdraw == \old(withdraw));
	@ assignable balance;
	@*/
	public boolean update(int x);
	/*@
	@ requires true;
	@ ensures (\result ==> balance == \old(balance)-x) && (!\result ==> balance == \old(balance));
	@ ensures (\result ==> withdraw >= \old(withdraw)) && (!\result ==> withdraw == \old(withdraw));
	@ assignable balance;
	@*/
	public boolean undoUpdate(int x);
}