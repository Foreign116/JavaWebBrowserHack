package jwb;

import java.awt.event.ActionListener;
import java.io.PrintStream;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SearchProviders {
	private GUI _gui;
	private MyClass _myClass;
	private JButton _googleButton;
	private JButton _bingButton;
	private String _currentProvider;

	public SearchProviders(GUI gui, MyClass myClass) {
		this._gui = gui;
		this._myClass = myClass;

		this._myClass.addSearchProviders(this);

		this._googleButton = new JButton("Bing");
		this._bingButton = new JButton("Homepage");

		ActionListener listener = new GoogleProvider(this);
		this._googleButton.addActionListener(listener);

		listener = new BingProvider(this);
		this._bingButton.addActionListener(listener);

		this._gui.getPanel().add(this._googleButton);
		this._gui.getPanel().add(this._bingButton);

		System.out.println("working");
	}

	public void setCurrentProvider(String provider) {
		this._currentProvider = provider;
	}

	public String getCurrentProvider() {
		return this._currentProvider;
	}

	public void outputProvider() {
		System.out.println(this._currentProvider);
	}

	public GUI getGUI() {
		return this._gui;
	}

	public MyClass getMyClass() {
		return this._myClass;
	}
}
