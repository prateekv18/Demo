package Assignment;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestRB {
	public static void main(String[] args) {
		ResourceBundle rb= ResourceBundle.getBundle("in.co.rays.rb.app", new Locale("hi"));
		System.out.println(rb.getString("greeting"));
	}
}
