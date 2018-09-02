package GET2018.EAD.EADSession4.Model;

import java.sql.Date;

/**
 * This class contains UserInfo fields
 * 
 * @author Mohit Sharma
 *
 */
public class UserInfoPojo {
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String contactNo;
	private String email;
	private String organization;

	public UserInfoPojo() {
	}

	public UserInfoPojo(String firstName, String lastName, Date dateOfBirth, String contactNo, String email,
			String organization) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.contactNo = contactNo;
		this.email = email;
		this.organization = organization;
	}

	public String getContactNo() {
		return contactNo;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getOrganization() {
		return organization;
	}
}
