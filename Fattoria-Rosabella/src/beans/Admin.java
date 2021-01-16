package beans;

public class Admin {

	private String email;
	private String password;
	
	public Admin() {
	}
	
	public Admin(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [email=" + email + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Admin) {
			Admin a = (Admin) obj;
			if(this.getEmail().equals(a.getEmail()) && this.getPassword().equals(a.getPassword())) return true;
			
		}
		return false;
			
	}
	
	
	
}
