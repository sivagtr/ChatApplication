package sivagtr.chatapp.chatapp.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import sivagtr.chatapp.chatapp.model.GreetingModel;
import sivagtr.chatapp.chatapp.model.MessageModel;

@Controller
public class GreetingController {


	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public GreetingModel greeting(MessageModel message) throws Exception {
		Thread.sleep(1000); // simulated delay
		return new GreetingModel("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}

}