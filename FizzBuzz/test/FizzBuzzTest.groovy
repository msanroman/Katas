package test

import src.FizzBuzz
import spock.lang.Specification


class FizzBuzzTest extends Specification{
	
	FizzBuzz game
	
	def "setup"(){
		game = new FizzBuzz()
	}

	def "If a number is not Fizz nor Buzz, should return the number"(){
		
		expect:
			game.askFor(number) == result
		where:
			number 	|	result
				1	|	"1"
				2	|	"2"
	}
	
	def "If a number is divisible by three, should return Fizz"(){
		
		expect:
			game.askFor(number) == result
		where:
			number	|	result
				3	|	"Fizz"
				6	|	"Fizz"
				9	|	"Fizz"
	}
	
	def "If a number is divisible by five, should return Buzz"(){
		
		expect:
			game.askFor(number) == result
		where:
			number	|	result
				5	|	"Buzz"
				10	|	"Buzz"
				20	|	"Buzz"
	}
	
	def "If a number is divisible by three and five, should return FizzBuzz"(){
		
		expect:
			game.askFor(number) == result
		where:
			number	|	result
				15	|	"FizzBuzz"
				30	|	"FizzBuzz"
				45	|	"FizzBuzz"
	}
	
	def "Test all numbers from 1 to 10"(){
		
		expect:
			game.play(10) == ["1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz"]
	}
}
