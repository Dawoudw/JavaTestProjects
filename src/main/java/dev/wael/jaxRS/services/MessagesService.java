package dev.wael.jaxRS.services;

import java.util.ArrayList;
import java.util.List;

import org.jvnet.hk2.annotations.Service;

import dev.wael.jaxRS.services.entities.Message;

/**
 * Root resource (exposed at "myresource" path)
 */
@Service
public class MessagesService {
	static ArrayList<Message> lst = new ArrayList<Message>();

	public MessagesService() {
		// TODO Auto-generated constructor stub

//		lst.add(new Message(1, "Message1", new Date()));
//		lst.add(new Message(2, "Message2", new Date()));
//		lst.add(new Message(3, "Message3", new Date()));
	}

	public List<Message> getMessages() {

		System.out.println(lst);
		return lst;
	}

	public Message geMessage(int id) {
		Message msg = (Message) lst.stream().filter(m -> m.getId() == id).findAny().orElse(null);
		System.out.println(msg);
		return msg;
	}

	public boolean addMessage(Message msg) {
		// TODO Auto-generated method stub
		return lst.add(msg);
	}

	public Message updateMessage(Message msg) {
		// TODO Auto-generated method stub
		// Message m = lst.get());
		int ix = lst.lastIndexOf(geMessage(msg.getId()));
		Message m = lst.set(ix, msg);

		return m;
	}
}
