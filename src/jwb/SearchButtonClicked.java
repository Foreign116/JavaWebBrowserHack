package jwb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import javax.swing.JTextField;

public class SearchButtonClicked implements ActionListener {
	private JTextField _textField;
	private MyClass _myClass;

	public SearchButtonClicked(JTextField field, MyClass myClass) {
		this._textField = field;
		this._myClass = myClass;
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("Button Clicked - Value: " + this._textField.getText());
		try {
			this._myClass.buttonClicked(this._textField.getText());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
