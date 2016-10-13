package is.ru.stringcalculator;

import java.util.ArrayList;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",")){
			return sum(splitNumbers(text));
		}
		else if(text.startsWith("//")){
			return sum(splitByGiven(text));
		}
		else
			return toInt(text);
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split("[,:\n]");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
 	    ArrayList<Integer> NegNum = new ArrayList<Integer>();
        for(String number : numbers){
        	int Numberint = toInt(number);
        	if(Numberint < 0)
		    {
		    	NegNum.add(Numberint);
		    }
		    if(Numberint <= 1000)
		    {
		    	total += Numberint;	
		    }
		}
		if(NegNum.size() > 0)
		{
			throw new IllegalArgumentException("Negatives not allowed: " + NegNum.toString());
		}
		return total;
    }

    private static String[] splitByGiven(String numbers){
	    String[] part = numbers.split("\n");
		String delimiter = part[0].substring(2);
		numbers = part[1];
	    return numbers.split(delimiter);
	}



}