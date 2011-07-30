import spock.lang.Specification;

class StringCalculator{
	
	static final SEPARATOR_FLAG = "//"
	static final SEPARATOR_POSITION = 2
	static final DEFAULT_SEPARATOR = ","
	static final ERROR_MESSAGE = "Negatives not allowed:"
	
	def separator
			
	def splitNumbers(String numbers) {
		
		return numbers.split(separator)
	}
	
	def toIntegerList(def stringList) {
		
		return stringList.collect { number ->
		Integer.valueOf(number)
		}
	}
	
	def isEmpty(String numbers){
		
		return numbers == ""
	}
	
	def replaceNewLinesWithSeparator(def string) {
		
		return string.replaceAll("\n", separator)
	}
	
	def hasSeparatorFlag(String numbers) {
		
		return (numbers.startsWith(SEPARATOR_FLAG))
	}
	
	def getSeparatorPart(String numbers) {
		
		return numbers[SEPARATOR_POSITION]
	}
	
	def getNumbersPart(String numbers) {
		
		if (hasSeparatorFlag(numbers)) {
			return numbers.substring(4)
		}
		return numbers
	}
	
	def establishSeparator(String numbers) {
		
		separator = DEFAULT_SEPARATOR
		if (hasSeparatorFlag(numbers)) {
			
			separator = getSeparatorPart(numbers)
		}
	}
	
	def checkForNegativeNumbers(def listOfIntegers){
		String error = ERROR_MESSAGE
		listOfIntegers.each { number -> 
			if(number < 0){
				error = error+" "+number.toString()
			}
		}
		if(hasBeenAnError(error))
			throw new IllegalArgumentException(error)
	}
	
	def hasBeenAnError(String error){
	
		return error != ERROR_MESSAGE
	}
	
	def add(String numbers){
		
		if (isEmpty(numbers)) {
			return 0
		}
		
		establishSeparator(numbers)		
		numbers = getNumbersPart(numbers)
		
		def numbersWithoutSeparator = replaceNewLinesWithSeparator(numbers);
		def listOfNumbers = splitNumbers(numbersWithoutSeparator)
				def listOfIntegers = toIntegerList(listOfNumbers)
				checkForNegativeNumbers(listOfIntegers)
				return listOfIntegers.sum()
	}
}

class StringCalculatorSpecification extends Specification{
	
	def calculator
	
	def "setup"() {
		calculator = new StringCalculator();
	}
	
	def "emptyStringShouldReturn0"(){
		
		expect:
			calculator.add("") == 0
	}
	
	def "should return itself when there is just one number"() {
		
		expect:
			calculator.add(numbers) == result
		where:
			numbers | result
			"1"     | 1
			"2"     | 2
			"10"    | 10
			"999"   | 999
	}
	
	def "should return containing number's sum"() {
		
		expect:
			calculator.add(numbers) == result
		where:
			numbers    | result
			"1,2"      |  3
			"100,200"  |  300
	}
	
	def "should handle unknown amount of numbers"() {
		
		expect:
			calculator.add(numbers) == result
		where:
			numbers   | result
			"1,1,1"   | 3
			"1,1,1,2" | 5
	}
	
	def "should handle new lines instead of commas"() {
		
		expect:
			calculator.add(numbers) == result
		where:
			numbers    | result
			"1\n2,3"   |  6
	}
	
	def "should handle different delimiters"() {
		
		expect:
			calculator.add(numbers) == result
		where:
			numbers    | result
			"//;\n1;2;3"   |  6
			"//%\n1%2%3"   |  6
			"//@\n1@2@3"   |  6
	}
	
	def "Should throw an IllegalArgumentException if there's some negative number"(){
		
		expect:
			try{
				calculator.add(numbers)
				assert false, "should have thrown an exception"
			}
			catch(IllegalArgumentException ex){
				ex.getMessage() == errorMessage
			}
		where:
			numbers | errorMessage
			"-1,2"	|	"Negatives not allowed: -1"
			"-4,5-7"|	"Negatives not allowed: -4 -7"
	}
}



