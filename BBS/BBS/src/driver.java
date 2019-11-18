import java.math.BigInteger;
import java.util.List;

public class driver {

	public static void main(String[] args) {
		
		// Strings to store large numbers
		String p = "24672462467892469787";
		String q = "396736894567834589803";
		
		// Convert to BigInteger dataTypes
		BigInteger big_p = new BigInteger(p);
		BigInteger big_q = new BigInteger(q);
		
		// Make a BBS class object
		BBSprng bbs = new BBSprng(big_p,big_q);
		
		// Choose a "x" that is relative prime to q*p 
		BigInteger x = new BigInteger("873245647888478349013");
		
		// Get the gcd(n,x)
		BigInteger relative_prime = bbs.gcd(bbs.getN(), x);
		
		// If the gcd(n,x) = 1, find remaining seeds
		if(bbs.isARelativePrime(relative_prime)) {
			bbs.setSeeds(8, x);
		}else {
			System.out.println("x is not a relative prime of n = p*q");
		}
		
		// Variable to hold object's list
		List<String> list = bbs.getSeeds();
		
		// Print off list of seeds
		int j = 0;
		for(String seed: list) {
			System.out.print("x"+j+" = ");
			System.out.println(seed);	
			j++;
		}
	}
}
