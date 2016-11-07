package jwb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class ClearButtonListener implements ActionListener {
	private MyClass mm;
	private HistoryButtonListener hbl;

	public ClearButtonListener(MyClass myc, HistoryButtonListener hh) {
		this.mm = myc;
		this.hbl = hh;
	}

	public void actionPerformed(ActionEvent arg0) {
		this.mm.returnpa().clear();
		this.hbl.rjp().removeAll();
		this.hbl.rjp().repaint();
		this.hbl.rjp().revalidate();
	}
}
