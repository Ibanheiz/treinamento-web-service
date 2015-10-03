package com.ibanheiz.socket;

import java.io.IOException;

import javax.inject.Inject;
import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import javax.xml.bind.JAXBException;

@ServerEndpoint("/chat")
public class ServerChat {
	
	@Inject
	private SessionManager manager;
	
	@OnOpen
	public void open(Session client, EndpointConfig config) {
		System.out.println("Abrindo conexão...");
		client.getAsyncRemote().sendText("Conexão aberta jovem");
		manager.addSession(client);
	}
	
	@OnMessage
	public void message(String json, Session client) {
		User user = new User();
		try {
			user = WSUtil.getUserFromJson(json);
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
		String message = user.getMessage();
		System.out.println("Mensagem recebida: " + message);
		client.getAsyncRemote().sendText("Você disse: " + message);
		manager.sendToAllClients(user, client);
	}

	@OnClose
    public void close(CloseReason reason, Session client) {
        System.out.println("Fechando conexão...");
		manager.removeSession(client);
    }
}
