package model.user;

public class User {
	
	public int id;
	public String login;
	public String password;
	public String email;
	public String[] roles;
	
	public User(int _id, String _login, String _password, String _email, String[] _roles){
		id			=	_id;
		login		=	_login;
		password	=	_password;
		email		=	_email;
		roles		=	_roles;
	}
		
}
