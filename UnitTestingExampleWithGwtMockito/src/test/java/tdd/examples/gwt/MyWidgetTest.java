package tdd.examples.gwt;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwtmockito.GwtMockitoTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(GwtMockitoTestRunner.class)
public class MyWidgetTest {

	@Mock NumberFormat formatter;
	@InjectMocks private MyWidget widget;

	@Test
	public void shouldFormatNumber() {
		when(formatter.format(5)).thenReturn("5.00");
		
		widget.setNumber(5);
		
		verify(widget.numberLabel).setText("5.00");
	}
}
