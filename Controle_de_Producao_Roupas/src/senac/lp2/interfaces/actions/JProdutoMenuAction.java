package senac.lp2.interfaces.actions;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JProdutoMenuAction extends AbstractAction {
	public static final String CONSULTAR1 = "CONSULTAR1";

	private JPanel principal;
	private CardLayout cards;

	public JProdutoMenuAction(JPanel principal, CardLayout cards) {
		super("Consultar Produto");
		this.principal = principal;
		this.cards = cards;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		cards.show(principal, CONSULTAR1);
	}
}
