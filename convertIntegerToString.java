
public class convertIntegerToString {
	
	static String convertIntToString(Integer n)
	{
		int space = 48;
		StringBuilder str = new StringBuilder();
		boolean isNegative = false;
		if(n < 0)
		{
			n = -1 * n;
			isNegative = true;
		}
		
		while(n > 0)
		{
			int digit = n % 10;
			str.append((char) (digit + space));
			n /= 10;
		}
		if(isNegative)
			return "-" + str.reverse().toString();
		else
			return str.reverse().toString();
	}
	
	public static void main(String[] args) {		
		System.out.println(new Integer(-101));
		System.out.println(convertIntToString(new Integer(-101)));
	}

}
