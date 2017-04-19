package utiles;


import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;

import javax.mail.Transport;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * Created by SAW on 18/02/2017.
 */
public class SendLinkEmail {
    public static boolean Send (String destinataireMail ,String name,int code)
    {
        final String username = "takemeexpletus@gmail.com";
        final String password = "helloworld";
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("arbi.grine@esprit.tn"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destinataireMail));
            message.setSubject(code+" est votre code de récupération de compte TakeMe");
            message.setText("Bonjour  "+name +","
                    + "\n\n Quelqu’un a récemment demandé à réinitialiser votre mot de passe TakeMe. \n \n \n " +
                    "Vous pouvez également saisir le code de réinitialisation du mot de passe \n \n : "+code);

            Transport.send(message);
            System.out.println("Done");
            return (true);
        } catch (MessagingException e) {
            System.out.println(e.getMessage());
            return (false);
        }
    }

}
