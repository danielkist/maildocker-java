# maildocker-java
Maildocker Java API

### Version
0.9.1-SNAPSHOT

### Dependencies
* Google Gson (2.6+)
* Apache HttpComponents (4+)
* Apache Commons IO (2.4+)

#Send message Sample
```
import java.util.Date;

import com.maildocker.api.MailDocker;
import com.maildocker.api.exception.MailDocketException;
import com.maildocker.api.model.Address;
import com.maildocker.api.model.Authorization;
import com.maildocker.api.model.Message;
import com.maildocker.api.model.TemplateMessage;

public class MaildockerTest {
	
	public static void main(String[] args) throws MailDocketException {
		Authorization auth = Authorization.getInstance("{subdomain}", "{key}", "{secret}");
		MailDocker mail = new MailDocker(auth);
		mail.send(getMessage());
		mail.send(getTemplateMessage());
	}
	
	private static Message getMessage() {
		Address from = Address.getInstance("{name}", "{account");
		Address to   = Address.getInstance("{name}", "{account");
		Message message = new Message();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject("Maildocker Java API Demo");
		message.setText("Message sent from Maildocker. Yay!!!");
		message.setHtml("<h2>Html message sent from Maildocker.</h2><h1>Yay!!!</h1>");
		return message;
	}
	
	private static TemplateMessage getTemplateMessage() {
		Address to = Address.getInstance("{name}", "{account");
		TemplateMessage template = new TemplateMessage();
		template.setTo(to);
		template.setTemplate("{template_name}");
        
        //Some vars
		template.addVar("{key}", {value});
        template.addVar("datetime", new Date());
        
		return template;
	}

}
```
