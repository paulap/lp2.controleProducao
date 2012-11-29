package senac.lp2.interfaces.actions;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JProducaoMenuAction extends AbstractAction{
	public static final String PRODUZIR = "PRODUZIR";

	private JPanel principal;
	private CardLayout cards;

	public JProducaoMenuAction(JPanel principal, CardLayout cards) {
		super("Produzir");
		this.principal = principal;
		this.cards = cards;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		cards.show(principal, PRODUZIR);
	}
}
