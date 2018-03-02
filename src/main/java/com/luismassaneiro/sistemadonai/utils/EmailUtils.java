/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.luismassaneiro.sistemadonai.utils;

import com.luismassaneiro.sistemadonai.exceptions.ValidateException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

/**
 *
 * @author Aluno
 */
public class EmailUtils {
    private static EmailUtils instance;
    
    private static final String EMAIL_REMETENTE = "atalaiasoftware@gmail.com";
    private static final String SENHA_REMETENTE = "AtalaiaSoftware@0";
    
    public static EmailUtils getInstance() {
        if(instance == null) {
            instance = new EmailUtils();
        }
        return instance;
    }
    
    public void enviarEmail(String assunto, String conteudo) throws ValidateException  {
        try{
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        @Override
                        protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                            return new javax.mail.PasswordAuthentication(EMAIL_REMETENTE, SENHA_REMETENTE);
                        }
                    });
            MimeMessage message = new MimeMessage(session);
            DataHandler handler = new DataHandler(new ByteArrayDataSource(conteudo.getBytes(), "text/html"));
            message.setSender(new InternetAddress(EMAIL_REMETENTE));
            message.setSubject(assunto);
            message.setDataHandler(handler);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(EMAIL_REMETENTE));
            Transport.send(message);

        }catch (Exception e) {
            e.printStackTrace();
            //throw new ValidateException("Erro ao tentar enviar email!");
        }
    }
    
    class MyAuthenticator extends Authenticator {
		private String usuarioAutenticacao;

		private String senhaUsuarioAutenticacao;

		public MyAuthenticator(String usuarioAutenticacao, String senhaUsuarioAutenticacao) {
			super();
			this.usuarioAutenticacao = usuarioAutenticacao;
			this.senhaUsuarioAutenticacao = senhaUsuarioAutenticacao;
		}

		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(usuarioAutenticacao, senhaUsuarioAutenticacao);
		}
	}
}
