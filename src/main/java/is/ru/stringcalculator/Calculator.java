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
		else
			return 1;
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



}