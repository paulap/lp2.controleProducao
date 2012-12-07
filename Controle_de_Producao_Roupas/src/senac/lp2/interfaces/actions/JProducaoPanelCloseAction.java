package senac.lp2.interfaces.actions;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import senac.lp2.interfaces.Fabrica;

@SuppressWarnings("serial")
public class JProducaoPanelCloseAction extends AbstractAction{
	private JPanel principal;
	private CardLayout cards;

	public JProducaoPanelCloseAction(JPanel principal, CardLayout cards) {
		super("Cancelar");
		this.principal = principal;
		this.cards = cards;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (principal != null) {
			cards.show(principal, Fabrica.PRINCIPAL);
		}

	}
}
