package config;

public class Session {

    private static Session instance;    
    private String uid;
    private String fname;
    private String lname;
    private String email;
    private String contact;
    private String address;
    private String user;
    private String type;
    private String status;

    
    // Private constructor to prevent external instantiation
    public Session() {
    }

    public static synchronized Session getInstance() {
       if(instance == null){
          instance = new Session();   
       }
       return instance;
    }

    public static boolean isInstanceEmpty() {
        return instance == null;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
     
    
    
}
