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
		
		return number % FIZZ == 0 || containsFizz(number)
	}
	
	private boolean isBuzz(int number){
		
		return number % BUZZ == 0 || containsBuzz(number)
	}
	
	private boolean containsFizz(int number){
		
		return contains(number, FIZZ)
	}
	
	private boolean containsBuzz(int number){
		
		return contains(number, BUZZ)
	}
	
	private boolean contains(int number, int flag){
		
		while(number > 0){
			if(number%10 == flag)
				return true
			number /= 10
		}
		return false
	}
}