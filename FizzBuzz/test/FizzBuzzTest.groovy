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
			game.askFor(number) == "Fizz"
		where:
			number << [3, 6, 9, 13]
	}
	
	def "If a number is divisible by five, should return Buzz"(){
		
		expect:
			game.askFor(number) == "Buzz"
		where:
			number << [5, 10, 20, 52]
	}
	
	def "If a number is divisible by three and five, should return FizzBuzz"(){
		
		expect:
			game.askFor(number) == "FizzBuzz"
		where:
			number << [15, 30, 45, 53, 60]
	}
	
	def "Test all numbers from 1 to 15"(){
		
		expect:
			game.play(15) == ["1", "2", "Fizz", "4", "Buzz", "Fizz", 
				"7", "8", "Fizz", "Buzz", "11", "Fizz", "Fizz", 
				"14", "FizzBuzz"]
	}
}
