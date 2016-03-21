# maildocker-java
Maildocker Java API

### Version
0.9-SNAPSHOT

### Dependencies
* Google Gson (2.6+)
* Apache HttpComponents (4+)
* Apache Commons IO (2.4+)

#Send message Sample
```
public class SendMessageDemo {
	
	//Domain = Your subdomain. Ex: http://seudominio.ecentry.io/
	public static void main(String[] args) throws MailDocketException {
		MailDocker md = new MailDocker("{domain}", "{key}", "{secret}");
		md.send(getMessage());
	}
	
	private static Message getMessage() {
		Address from   = Address.getInstance("From", "from@domain.com");
		Address to     = Address.getInstance("To", "dest@dommain.com");
		String subject = "Maildocker Java API";
		String text    = "Testing. It works?"; 
		return Message.getInstance(from, to, subject, text);
	}
}
```
