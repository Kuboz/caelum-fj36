/**
 * 
 */
package br.com.caelum.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author soa7324
 *
 */
public class TratadorDeMensagemNaFila implements MessageListener {

	@Override
	public void onMessage(Message msg) {
		TextMessage textMessage = (TextMessage) msg;
		try {
			System.out.println("Tratador recebendo mensagem:" + textMessage.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}



}
