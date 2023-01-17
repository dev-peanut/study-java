package bank;

import java.util.Random;

public class KaKao extends Bank{
	
	int stockMoney;
	
	@Override
	public int showBalance() {
		setMoney(getMoney() / 2);
		return super.showBalance();
	}
	
//	주가
	public void stock() {
		Random random = new Random();
		int rating = random.nextInt(31);
		final boolean isDecrese = random.nextInt(2) == 1;
		if(isDecrese) {
			rating *= -1;
			
		}
		
		
		
		
	}
//	매도

	
	
}
