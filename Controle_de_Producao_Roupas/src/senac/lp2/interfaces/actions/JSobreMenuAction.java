package senac.lp2.interfaces.actions;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JSobreMenuAction extends AbstractAction{
	public static final String SOBRE = "SOBRE";

	private JPanel principal;
	private CardLayout cards;

	public JSobreMenuAction(JPanel principal, CardLayout cards) {
		super("Sobre");
		this.principal = principal;
		this.cards = cards;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		cards.show(principal, SOBRE);
	}
}
