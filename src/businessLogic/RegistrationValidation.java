package businessLogic;
import java.util.regex.*;
public class RegistrationValidation
{
	public boolean checkUserDetails(String email,String password,String confirmPassword,String phone_number)
	{       
		    if(validPassword(password,confirmPassword) && validEmail(email)&& validPhoneNumber(phone_number))
		    {
		    	return true;
		    }
		    else 
		    return false;
	}
	//password validation 
	   private boolean validPassword(String password,String confirmPassword)
	   {          String regex = "^(?=.*[0-9])"
				+ "(?=.*[a-z])(?=.*[A-Z])"
				+ "(?=.*[@#$%^&+=])"
				+ "(?=\\S+$).{8,20}$";
	     Pattern   p = Pattern.compile(regex);
	     if( !password.equals(confirmPassword)|| password==null) {
	    	 System.out.println("Your Entered Password and Confirm Password Doesn't Matched");
	    	 return false;
	     }
	     else {
	     Matcher m =p.matcher(password);
	     if(m.matches())
	         {
	             return m.matches();
	          }
	     else
	       {
	    	   System.out.println("Password Must consist of atleast 8 characters, a symbol, an upper and a lowercase letter");
	    	   return m.matches();
	        }
	     }
	   }
	   ///Email validation
	   private boolean validEmail(String email)
	   {   
		   String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                   "[a-zA-Z0-9_+&*-]+)*@" + 
                   "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                   "A-Z]{2,7}$"; 
		   Pattern pat = Pattern.compile(emailRegex); 
	        if (email == null) 
	            return false; 
	        return pat.matcher(email).matches();
	   }
	  
	   private boolean validPhoneNumber(String phone_number)
	   {
		   if(phone_number.length()<=10)
		   {
			   return true;
		   }
		   else { 
			   System.out.println("Mobile numbers must be 10 digits ");
			   return false;
		   }
	   }
	   }
	   
