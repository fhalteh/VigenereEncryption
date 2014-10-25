package cryptocrypt;

public class vinegere {

	public static void main(String [] args){
		
		String plain_text = "e";
		plain_text = plain_text.toLowerCase();
		plain_text = removeStuff(plain_text);
		System.out.println(plain_text);
		
		String key = "s";
		key = key.toLowerCase();
		
		System.out.println("This is the plain Text: "+plain_text);
		
		String cipher_text = encrypt(plain_text, key);
		System.out.println(cipher_text);
	}
	
	//method to remove the spaces!
	public static String removeStuff(String S){
		String newString = "";
		for (int i = 0; i < S.length();i++)
		{
			if(S.charAt(i)!=' ' && S.charAt(i)!='.' && S.charAt(i)!=',' && S.charAt(i)!='!')
				newString += S.charAt(i);
				
		}
		return newString;
	}
	
	public static String encrypt(String plain_text, String key){
		String cipher_text ="";
		
		for(int i = 0; i <plain_text.length();i++){
			char current_char = plain_text.charAt(i);
			int num_value_of_char = letterToNumber(current_char);
			int index_value_of_key = keyToNumberValue(i,key);
			int num_value_of_key = letterToNumber(key.charAt(index_value_of_key));
			int cipher_num_value = ((num_value_of_char + num_value_of_key)%29);
			char cipher_char_value = NumberToLetter(cipher_num_value);
			cipher_text += cipher_char_value;
		}
		return cipher_text;
	}
	
	public static int keyToNumberValue(int index, String key){
		int length_of_key = key.length();
		System.out.println("Length of key: "+ length_of_key);
		
		if(index>=length_of_key)
		return index%length_of_key;
		
		else return index;
	}
	
	public static int letterToNumber(char a){
		if(a=='å' || a=='ö' || a=='ä')	 //if it's a swedish character
		{
			if(a=='å')
				return 26;
			if(a=='ä')
				return 27;
			if(a=='ö')
				return 28;			
		}
		else{ //not a Swedish Character
			return ((int) a)-97;
		}	
		return 9999;
	}
	public static char NumberToLetter(int a){
		if(a==26 || a==27 || a==28)	 //if it's a swedish character
		{
			if(a==26)
				return 'å';
			if(a==27)
				return 'ä';
			if(a==28)
				return 'ö';			
		}
		else{ //not a Swedish Character
			return ((char)(a+97));
		}	
		return 9999;
	}
}
