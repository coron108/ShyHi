package dev.rug.shyhi;

import java.util.ArrayList;

public class Convo {

	private String _id;
	private String type;
	private String user1;
	private String user2;
	private ArrayList<Message> messages;
	
	
	public Convo(){};
	public Convo(String i, String u1, String u2, ArrayList<Message> m){
		_id = i;
		user1 = u1;
		user2 = u2;
		messages = m;
	}
	
	public String getId(){
		return _id;
	}
	public String getType(){
		return type;
	}
	public String getUser1(){
		return user1;
	}
	public String getUser2(){
		return user2;
	}
	public ArrayList<Message> getMessages(){
		return messages;
	}
	
	public void addMessage(Message m){
		messages.add(m);
	}
	
	public String getMostRecentMessage(){
		return messages.get(messages.size()-1).getMessage();
	}
	
}
