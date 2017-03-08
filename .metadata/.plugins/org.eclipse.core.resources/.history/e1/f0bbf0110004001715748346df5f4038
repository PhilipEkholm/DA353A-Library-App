package messagesystem;

public class Server {
	private User[] users;
	
	public Server(){
		this.users[0] = new User("Philip", "1234");
	}
	
	public boolean hasUser(User user){
		for(int i = 0; i < users.length; i++){
			if(users[i].getName().equals(user.getName())){
				return true;
			}
		}
		
		return false;
	}
}
