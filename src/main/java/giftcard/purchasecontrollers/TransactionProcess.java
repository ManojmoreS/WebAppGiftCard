package giftcard.purchasecontrollers;
public class TransactionProcess {
	/*calculate pay back and current balance and return the sum of pay back and current balance*/
	public int calculatePayBack(int totalCouponValue ,int availableAmount,double d){
		int payBack = (int) (totalCouponValue*d);
		int currentBalance = (availableAmount-totalCouponValue)+payBack;
		return currentBalance;
	}
}
