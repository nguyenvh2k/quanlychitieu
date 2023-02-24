package model;

public class User {
    private int user_id;
    private String username;
    private String email;
    private String password;
    private String firstname;
    private String fullname;
    private int gender;
    private String address;

    public User() {
    }

    public User(int user_id, String username,
                String email, String password, String firstname,
                String fullname, int gender, String address) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.fullname = fullname;
        this.gender = gender;
        this.address = address;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", fullname='" + fullname + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                '}';
    }
}
