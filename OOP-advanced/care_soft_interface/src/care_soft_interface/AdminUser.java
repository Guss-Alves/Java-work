package care_soft_interface;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	
	private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<String>();


	public AdminUser(Integer id, String role) {
		super(id);
		this.role = role;
		// TODO Auto-generated constructor stub
	}
	
	public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
	
	public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
	public ArrayList<String> reportSecurityIncidents() {
		// TODO Auto-generated method stub
		return securityIncidents;
		
	}

	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		int length  =(int)(Math.log10(pin) + 1);
//		System.out.println(length);
		if(length != 6) {
//			System.out.println("Hereee please " + pin);
			
			return false;						
		}
		return true;
	}
	
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if( id == confirmedAuthID ) {
			return true;
		}else {
			authIncident();
			return false;		
		}
	}

	
	//here are getter and setter
	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}

}
