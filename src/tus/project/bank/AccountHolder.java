package tus.project.bank;

import java.util.regex.Pattern;

public class AccountHolder {
    private String name;
    private Long phoneNumber;
    private String emailAddress;
    private String ppsn;
    public AccountHolder(String name, Long phoneNumber, String emailAddress, String ppsn) {
        if(validData(ppsn, emailAddress, phoneNumber)) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.emailAddress = emailAddress;
            this.ppsn = ppsn;
        }
        else{
            System.out.println("Invalid data given: cannot create account");
        }
    }
    public AccountHolder() {}

    @Override
    public String toString() {
        return "AccountHolder{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", emailAddress='" + emailAddress + '\'' +
                ", ppsn='" + ppsn + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPpsn() {
        return ppsn;
    }

    public void setPpsn(String ppsn) {
        this.ppsn = ppsn;
    }

    public boolean validData(String ppsn, String email, Long phoneNumber){
        String ppsnRegex = "^[0-9]{7}[A-Z]{1,2}$";
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        String phoneRegex = "^(\\+\\d{1,3}[- ]?)?\\d{10}$";
        return Pattern.matches(ppsnRegex, ppsn) && Pattern.matches(emailRegex, email) &&  Pattern.matches(phoneRegex, phoneNumber.toString());
    }
}
