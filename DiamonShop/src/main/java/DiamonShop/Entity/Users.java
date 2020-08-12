package DiamonShop.Entity;

public class Users {
private int id;
private int enabled;
private String username; 
private String password; 
private String display_name; 
private String address;
private double wallet;

public Users() {
	super();
}
public double getWallet() {
	return wallet;
}
public void setWallet(double wallet) {
	this.wallet = wallet;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getEnabled() {
	return enabled;
}
public void setEnabled(int enabled) {
	this.enabled = enabled;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getDisplay_name() {
	return display_name;
}
public void setDisplay_name(String display_name) {
	this.display_name = display_name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}


}
