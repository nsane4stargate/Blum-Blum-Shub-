import java.util.*;
import java.math.BigInteger;

public class BBSprng {
	
	private BigInteger p,q,n;
	private List<String> seeds = new ArrayList<String>();
	
	public BBSprng(BigInteger p0, BigInteger q0) {
		p = p0; 
		q = q0;
		if(IsPrime(p,q) == true) {
			n = p.multiply(q);
		}
	}
	

	/********************************
	 *			Void functions 		*
	 ********************************/
	
	void setSeeds(int index, BigInteger seed){
		if(index < 0) {
			return;
		}
		// Calculate next seed
		BigInteger x = (seed.multiply(seed)).mod(getN());
		getSeeds().add(x.toString(10));
		setSeeds(index - 1,x);
	}

	/********************************
	 * Functions with return values *
	 ********************************/
	
	BigInteger getQ(){
		return q;
	}

	
	BigInteger getP(){
		return p;
	}

	
	BigInteger getN(){
		return n;
	}

	BigInteger gcd(BigInteger num1, BigInteger num2) {
		BigInteger n = new BigInteger("0");
		if(num2.equals(n)) {
			return num1;
		}
		return gcd(num2,num1.mod(num2));
	}
	
	List<String> getSeeds(){
		return seeds;
	}
	
	
	boolean isARelativePrime(BigInteger result) {
		BigInteger n = new BigInteger("1");
		if(result.equals(n)) {
			return true;
		}
		return false;
	}
	
	
	boolean IsPrime(BigInteger p, BigInteger q){
		BigInteger m = new BigInteger("4");
		BigInteger n = new BigInteger("3");
		if ((p.mod(m)).compareTo(n) == 0) {
			if((q.mod(m)).equals(n)){
				return true;
			}
		}
		return false;
	}
}
