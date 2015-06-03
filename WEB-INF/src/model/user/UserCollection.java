package model.user;

import java.util.ArrayList;
import java.util.List;

public class UserCollection {

	public static UserCollection self;
	public static int nbUser;
	
	public List<User> userList;
	
	
	public static UserCollection getInstance(){
		if(self==null){
			return new UserCollection();
		}
		return self ;
	}
	
	private UserCollection(){
		nbUser=0;
		userList = new ArrayList<User>();
	}
	
	public boolean addUser(User u){
		if(u!=null){
			userList.add(u);
			nbUser++;
			return true;
		}
		return false;
	}
	
	public boolean updateUser(User u){
		if(u!=null && this.userList.isEmpty()==false){
			this.userList.remove(findUser(u));
			this.userList.add(u);
			return true;
		}
		return false;
	}

	public boolean removeUser(User u){
		if(u!=null && this.userList.isEmpty()==false){
			userList.remove(u);
			nbUser--;
			return true;
		}
		return false;
	}
	
	public void displayConsole(){
		System.out.println(this.toString());
	}
	
	public String toString(){
		String s = "";
		if(!userList.isEmpty())
			for(User u : userList){
				s+= "user account - Login : "+u.login+"/n";
			}
		return s;
	}
	
	/**
	 * @param user to be set up
	 * @return int type which represents position of User in specified list
	 * if user is not found or errors have been found, then returns -1 
	 */
	private int findUser(User u){
		int i = 0 ;
		while(i<userList.size()){
			if(u.equals(userList.get(i)))
				return i;
			i++;
		}
		return 0;
	}
	
	public String listUsers(){
		String s = "";
		for(User u : userList){
			s+= "<li>user account - Login : "+u.login+"</li><br />";
		}
		return s;
	}
	
	public boolean isEmpty(){
		if(this.userList.isEmpty()==true)
			return true;
		return false;
	}
}
