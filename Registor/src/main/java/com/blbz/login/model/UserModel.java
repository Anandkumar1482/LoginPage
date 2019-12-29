package com.blbz.login.model;

public class UserModel {

private int	Id;
private	String FirstName;
private	String LastName;
private	String UserName;
private	String Password;
private	String Email;

public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getFirstName() {
	return FirstName;
}
public void setFirstName(String firstName) {
	FirstName = firstName;
}
public String getLastName() {
	return LastName;
}
public void setLastName(String lastName) {
	LastName = lastName;
}
public String getUserName() {
	return UserName;
}
public void setUserName(String userName) {
	UserName = userName;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
@Override
public String toString() {
	return "UserModel [Id=" + Id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", UserName=" + UserName
			+ ", Password=" + Password + ", Email=" + Email + "]";
}
}
