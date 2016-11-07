package jwb;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkEvent.EventType;
import javax.swing.event.HyperlinkListener;

public class GUI {
	private JFrame _frame;
	private JButton hbutton;
	private JButton _button;
	private JPanel _panel;
	private JTextField _textField;
	MyClass myc = new MyClass();
	ArrayList<JEditorPane> jp = new ArrayList();

	public GUI() {
		final JEditorPane jpp = new JEditorPane();
		JScrollPane scpane = new JScrollPane(jpp);

		jpp.setEditorKit(JEditorPane.createEditorKitForContentType("text/html"));
		jpp.addHyperlinkListener(new HyperlinkListener() {
			public void hyperlinkUpdate(HyperlinkEvent e) {
				if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
					System.out.println(e.getURL());
					try {
						jpp.setPage(e.getURL());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		scpane.setVisible(true);
		jpp.setVisible(true);
		jpp.setEditable(false);
		try {
			jpp.setPage("http://www.browsedankmemes.com");
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		this.jp.add(jpp);
		this.hbutton = new JButton("History");
		this._frame = new JFrame();
		this._frame.setSize(1400, 1000);
		this._panel = new JPanel();
		this._panel.add(new JLabel("NAds"));

		JButton backButton = new JButton("Back");

		ActionListener backListener = new BackButtonListener(this.myc);
		backButton.addActionListener(backListener);
		this._panel.add(backButton);

		JButton forwardButton = new JButton("Forward");

		ActionListener forwardListener = new ForwardButtonListener(this.myc);
		forwardButton.addActionListener(forwardListener);
		this._panel.add(forwardButton);
		this.hbutton.addActionListener(new HistoryButtonListener(this.myc));
		this._button = new JButton("Search");
		this._textField = new JTextField();
		this._textField.setPreferredSize(new Dimension(200, 20));

		ActionListener listener = new SearchButtonClicked(this._textField, this.myc);
		new SearchProviders(this, this.myc);
		this._frame.getContentPane().setLayout(new BorderLayout());
		this._button.addActionListener(listener);
		this._textField.addActionListener(listener);
		this._panel.add(this._textField);
		this._panel.add(this._button);
		this._panel.add(this.hbutton);
		this._frame.add(this._panel, "North");
		this._frame.add(scpane, "Center");

		this._frame.setVisible(true);
		this._frame.setDefaultCloseOperation(3);
	}

	public JPanel getPanel() {
		return this._panel;
	}

	public ArrayList<JEditorPane> returnjep() {
		return this.jp;
	}
}
