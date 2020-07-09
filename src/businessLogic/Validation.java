package businessLogic;

public class Validation {

	public boolean validate(String email, String password) {
		if(email.equals("admin") && password.equals("admin"))
			return true;
		else 
			return false;
	}
	
}
