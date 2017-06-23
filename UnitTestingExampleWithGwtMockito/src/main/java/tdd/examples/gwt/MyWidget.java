package tdd.examples.gwt;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Aliaksandr Bandarchyk
 */
public class MyWidget extends Composite {

	interface MyUiBinder extends UiBinder<Widget, MyWidget> {}
	private final MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	@UiField Label numberLabel;
	private final NumberFormat formatter;

	public MyWidget(NumberFormat formatter) {
	    this.formatter = formatter;
	    initWidget(uiBinder.createAndBindUi(this));
	  }

	void setNumber(int number) {
		numberLabel.setText(formatter.format(number));
	}
}
