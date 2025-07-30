public class Admin {
    private String adminID;
    private String username;
    private String password;

    // Default constructor
    public Admin() {
        this.adminID = null;
        this.username = null;
        this.password = null;
    }

    // Constructor with all attributes
    public Admin(String adminID, String username, String password) {
        this.adminID = adminID;
        this.username = username;
        this.password = password;
    }

    // Getter and Setter for adminID
    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    // Getter and Setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
