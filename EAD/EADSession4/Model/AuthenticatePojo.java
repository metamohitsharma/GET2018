package GET2018.EAD.EADSession4.Model;

/**
 * This class contains Id and Password
 * 
 * @author Mohit Sharma
 *
 */
public class AuthenticatePojo {
	private int id;
	private String password;

	public AuthenticatePojo(int id, String password) {
		this.id = id;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}
}
