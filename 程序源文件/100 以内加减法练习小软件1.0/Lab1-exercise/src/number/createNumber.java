package number;

public class createNumber {
	private int numberOne;
	private int numberTwo;
	private int flag;
	private int answer;
	public createNumber( ) {
		int randomNumberOne = (int)(Math.random()*100 + 1);
		int randomNumberTwo = (int)(Math.random()*100 + 1);
		int randomFlag = (int)(Math.random()*100 + 1);
		if(randomFlag % 2 == 0) {
			//偶数代表加法
			while(randomNumberOne + randomNumberTwo > 100) {
				randomNumberOne = (int)(Math.random()*100 + 1);
				randomNumberTwo = (int)(Math.random()*100 + 1);
			}
			this.answer = randomNumberOne + randomNumberTwo;
		}
		if(randomFlag % 2 == 1) {
			//奇数代表减法
			while(randomNumberOne - randomNumberTwo < 0) {
				randomNumberOne = (int)(Math.random()*100 + 1);
				randomNumberTwo = (int)(Math.random()*100 + 1);
			}
			this.answer = randomNumberOne - randomNumberTwo;
		}
		this.flag = randomFlag;
		this.numberOne = randomNumberOne;
		this.numberTwo = randomNumberTwo;
	}
	/**
	 * @return numberOne
	 */
	public  int getNumberOne() {
		return numberOne;
	}
	/**
	 * @return answer
	 */
	public int getAnswer() {
		return answer;
	}
	
	/**
	 * @param numberOne 要设置的 numberOne
	 */
	public void setNumberOne(int numberOne) {
		this.numberOne = numberOne;
	}
	/**
	 * @return numberTwo
	 */
	public int getNumberTwo() {
		return numberTwo;
	}
	/**
	 * @param numberTwo 要设置的 numberTwo
	 */
	public void setNumberTwo(int numberTwo) {
		this.numberTwo = numberTwo;
	}
	/**
	 * @return flag
	 */
	public int getFlag() {
		return flag;
	}
	/**
	 * @param flag 要设置的 flag
	 */
	public void setFlag(int flag) {
		this.flag = flag;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + flag;
		result = prime * result + numberOne;
		result = prime * result + numberTwo;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		createNumber other = (createNumber) obj;
		if (flag != other.flag)
			return false;
		if (numberOne != other.numberOne)
			return false;
		if (numberTwo != other.numberTwo)
			return false;
		return true;
	}

	
}
