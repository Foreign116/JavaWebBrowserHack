package jwb;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import javax.swing.JEditorPane;

public class MyClass {
	private String _userInput;
	private SearchProviders _provider;
	private ArrayList<String> _pageArray = new ArrayList();
	private ArrayList<String> ha = new ArrayList();
	private int _pageCount = 0;

	public void buttonClicked(String input) throws IOException {
		this._userInput = input;
		if (input.equals("")) {
			System.exit(0);
		}
		input = multiWordCheck(input, ' ', "+");
		this._userInput = input;

		System.out.println("Still working");

		boolean search = true;
		for (int i = 0; i < this._userInput.length(); i++) {
			if (this._userInput.charAt(i) == '.') {
				search = false;
			}
		}
		if (search) {
			((JEditorPane) this._provider.getGUI().returnjep().get(0))
					.setPage("http://bing.com/search?q=" + this._userInput);
			this._pageArray.add("http://bing.com/search?q=" + this._userInput);
			this.ha.add("http://bing.com/search?q=" + this._userInput);
			this._pageCount += 1;
		} else {
			((JEditorPane) this._provider.getGUI().returnjep().get(0)).setPage("http://" + this._userInput);
			this._pageArray.add("http://" + this._userInput);
			this.ha.add("http://" + this._userInput);
			this._pageCount += 1;
		}
	}

	public String multiWordCheck(String input, char replace, String with) {
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == replace) {
				input = input.substring(0, i) + with + input.substring(i + 1, input.length());
			}
		}
		return input;
	}

	public String validcharcheck(String input) {
		String result = "";
		for (int i = 0; i < input.length(); i++) {
			if (Character.isLetter(input.charAt(i))) {
				result = result + input.charAt(i);
			}
		}
		return result;
	}

	public ArrayList<String> getUrls() {
		ArrayList<String> result = new ArrayList();
		result.add("http://google.com/#q=" + this._userInput);
		result.add("http://bing.com/#q=" + this._userInput);
		result.add("http://" + validcharcheck(this._userInput) + ".com");
		return result;
	}

	public void addSearchProviders(SearchProviders provider) {
		this._provider = provider;
	}

	public GUI getGUI() {
		return this._provider.getGUI();
	}

	public void goToLastPage() {
		try {
			if (this._pageCount == 0) {
				((JEditorPane) this._provider.getGUI().returnjep().get(0)).setPage("http://www.browsedankmemes.com");
			} else {
				this._pageCount -= 1;
				((JEditorPane) this._provider.getGUI().returnjep().get(0))
						.setPage((String) this._pageArray.get(this._pageCount - 1));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print(this._pageCount);
	}

	public void goToNextPage() {
		try {
			if (this._pageCount != this._pageArray.size()) {
				this._pageCount += 1;
				((JEditorPane) this._provider.getGUI().returnjep().get(0))
						.setPage((String) this._pageArray.get(this._pageCount - 1));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print(this._pageCount);
	}

	public ArrayList<String> returnpa() {
		return this.ha;
	}
}
