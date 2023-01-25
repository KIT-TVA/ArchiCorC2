package Interfaces;

interface IAccount {
	/*@
	@ requires true;
	@ ensures (\result ==> balance == \old(balance)+x) && (!\result ==> balance == \old(balance));
	@ assignable balance;
	@*/
	public boolean update(int x);
	/*@
	@ requires true;
	@ ensures (\result ==> balance == \old(balance)-x) && (!\result ==> balance == \old(balance));
	@ assignable balance;
	@*/
	public boolean undoUpdate(int x);
}