package dev.wael.jaxRS.services.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dev.wael.jaxRS.services.MessagesService;
import dev.wael.jaxRS.services.entities.Message;

@Path("/messages")
public class MessagesController {

	private MessagesService msgSrv = new MessagesService();

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages() {
		return msgSrv.getMessages();
	}

	@GET
	@Path("/{msgid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message geMessage(@PathParam("msgid") int id) {

		return msgSrv.geMessage(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message msg) {
		return msgSrv.addMessage(msg) ? msg : null;
	}

	@PUT
	@Path("/{msgid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("msgid") int msgid, Message msg) {
		msg.setId(msgid);
		return msgSrv.updateMessage(msg);
	}

}
