package jwb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HistoryButtonListener implements ActionListener {
	private MyClass mm;
	private JFrame jj;
	private JPanel jp;
	private JButton c;

	public HistoryButtonListener(MyClass myc) {
		this.mm = myc;
	}

	public void actionPerformed(ActionEvent arg0) {
		this.jj = new JFrame("History");
		this.jp = new JPanel();
		this.jp.setLayout(new BoxLayout(this.jp, 1));
		this.c = new JButton("Clear");
		this.c.addActionListener(new ClearButtonListener(this.mm, this));
		this.jp.add(this.c, "North");
		this.jj.add(this.jp);
		if (this.mm.returnpa().size() != 0) {
			for (int i = 0; i < this.mm.returnpa().size() - 1; i++) {
				JLabel jl = new JLabel((String) this.mm.returnpa().get(i));
				jl.setVisible(true);
				this.jp.add(jl, "South");
			}
		}
		this.jj.setVisible(true);
		this.jp.setVisible(true);
		this.jj.setSize(1000, 1000);
	}

	public JPanel rjp() {
		return this.jp;
	}
}
