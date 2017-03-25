package giftcard.forgotusernamecontrollers;
import java.util.Random;

public class IDGenerator {
		private static final String CHAR_LIST ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	    private static final int RANDOM_STRING_LENGTH = 10;
	    public String generateRandomString(){
	        StringBuffer randomString = new StringBuffer();
	        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
	            int number = getRandomNumber();
	            char temporaryCharacter = CHAR_LIST.charAt(number);
	            randomString.append(temporaryCharacter);
	        }
	        return randomString.toString();
	    }
	    private int getRandomNumber(){
	        int randomInt = 0;
	        Random randomGenerator = new Random();
	        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
	        if (randomInt - 1 == -1)
	            return randomInt;
	        else
	        	return randomInt - 1;
	    }
}
