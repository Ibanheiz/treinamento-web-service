package com.ibanheiz.socket;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.Session;

@ApplicationScoped
public class SessionManager {
	
	List<Session> allSessions = new ArrayList<Session>();
	
	public void addSession(Session client) {
		allSessions.add(client);
		System.out.println(allSessions.size());
	}
	
	public void removeSession(Session client) {
		allSessions.remove(client);
	}

	public void sendToAllClients(User user, Session client) {
		for (Session session : allSessions) {
			if (session.equals(client)) {
				continue;
			}
			session.getAsyncRemote().sendText(user.getName() + " disse: " + user.getMessage());
		}
	}
}
