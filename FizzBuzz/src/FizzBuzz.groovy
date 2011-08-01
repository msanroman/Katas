package src

class FizzBuzz {
	
	static final FIZZ = 3
	static final BUZZ = 5
	
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
		
		return number % FIZZ == 0
	}
	
	private boolean isBuzz(int number){
		
		return number % BUZZ == 0
	}
	
}
