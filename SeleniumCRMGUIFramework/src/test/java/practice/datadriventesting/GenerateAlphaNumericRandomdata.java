package practice.datadriventesting;

public class GenerateAlphaNumericRandomdata {

	public static void main(String[] args) {
		int n=20;
		
		//Choose a Character random this String
		String AlphaNumericString="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
		
		//create StringBuffer size of AlphanumericString
		StringBuilder sb=new StringBuilder(n);
		
		for (int i=0;i<n;i++) {
			
		//generate a random number between 0 to AlphaNumericString variable length
		int index=(int)(AlphaNumericString.length()*Math.random());
			
		//add Character one by one in end of sb
		sb.append(AlphaNumericString.charAt(index));	
		}
        System.out.println(sb);
	}

}