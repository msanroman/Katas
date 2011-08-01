package src

class FizzBuzz {
	
	public static final FIZZ = 3
	public static final BUZZ = 5
	
	public def play(int upperBound){
		
		(1..upperBound).collect { number -> 
			askFor(number)
		}
	}
	
	public String askFor(int number){
		
		if(isFizz(number) && isBuzz(number))
			return "FizzBuzz"
		if(isFizz(number))
			return "Fizz"
		if(isBuzz(number))
			return "Buzz"
		return number.toString()
	}

	private boolean isFizz(int number){
		
		return number % FIZZ == 0 || contains(FIZZ, number)
	}
	
	private boolean isBuzz(int number){
		
		return number % BUZZ == 0 || contains(BUZZ, number)
	}
	

	private boolean contains(int flag, int number){
		
		while(number > 0){
			if(number%10 == flag)
				return true
			number /= 10
		}
		return false
	}
}