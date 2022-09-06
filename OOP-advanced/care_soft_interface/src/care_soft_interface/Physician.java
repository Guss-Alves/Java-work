package care_soft_interface;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser{
	
	private ArrayList<String> patientNotes;

	//constructor is here
	public Physician(Integer id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	// TO DO: Implement HIPAACompliantUser!
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		int length  =(int)(Math.log10(pin) + 1);
//		System.out.println(length);
		if(length != 4) {
//			System.out.println("Hereee please " + pin);
			return false;						
		}
		return true;
	}

	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		if( this.id == confirmedAuthID ) {
			System.out.println("this is the id --> " + this.id);
			return true;
		}
		return false;
	}
	
	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
	
	// TO DO: Setters & Getters
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}
	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
	
}
