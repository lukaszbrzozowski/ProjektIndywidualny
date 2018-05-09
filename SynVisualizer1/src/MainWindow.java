import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;


public class MainWindow {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setMinimumSize(new Point(1000, 700));
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		Button btnGenerujAnimacj = new Button(shell, SWT.NONE);
		btnGenerujAnimacj.setBounds(75, 0, 104, 25);
		btnGenerujAnimacj.setText("Generuj animacj\u0119");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton.setBounds(179, 0, 136, 25);
		btnNewButton.setText("Rozpocznij odtwarzanie");
		
		Button btnZatrzymaj = new Button(shell, SWT.NONE);
		btnZatrzymaj.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnZatrzymaj.setBounds(315, 0, 75, 25);
		btnZatrzymaj.setText("Zatrzymaj");
		
		Button btnZakocz = new Button(shell, SWT.NONE);
		btnZakocz.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		btnZakocz.setBounds(390, 0, 75, 25);
		btnZakocz.setText("Zako\u0144cz");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(46, 506, 863, 145);
		lblNewLabel.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque magna purus, posuere vitae venenatis vitae, dapibus at libero. \n Suspendisse vel dui non tellus feugiat tristique quis vel magna. Nullam eget pretium dui. Aliquam congue tellus vitae arcu auctor lobortis. \n Suspendisse ligula ligula, pellentesque id erat vel, fringilla maximus mauris. Phasellus eu accumsan magna, eget pellentesque enim. Suspendisse at facilisis odio. \n Sed accumsan est dapibus placerat condimentum. Pellentesque fringilla velit nec convallis iaculis. Duis eget vulputate odio. Duis tincidunt ipsum \n non faucibus pellentesque. Sed mauris neque, bibendum aliquet pulvinar eu, mattis quis nibh. Nullam condimentum porta sem, condimentum fermentum \n ligula tristique ac. Nunc scelerisque ex justo, at placerat erat fermentum at. Mauris elementum, sem eget feugiat fringilla, diam enim finibus  \nmassa, in eleifend nulla tortor nec lacus. ");
		
		Button btnDodajPlik_1 = new Button(shell, SWT.NONE);
		btnDodajPlik_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
		          int returnValue = fileChooser.showOpenDialog(null);
		          if (returnValue == JFileChooser.APPROVE_OPTION) {
		            File selectedFile = fileChooser.getSelectedFile();
		            System.out.println(selectedFile.getName());
		          }
		        }
		});
		btnDodajPlik_1.setBounds(0, 0, 75, 25);
		btnDodajPlik_1.setText("Dodaj plik");
		
		Label label = new Label(shell, SWT.CENTER);
		label.setImage(SWTResourceManager.getImage("C:\\Users\\\u0141ukasz Brzozowski\\eclipse-workspace\\SynVisualizer1\\src\\colors.jpg"));
		label.setBounds(10, 37, 964, 463);
		
		JButton btnDodajPlik = new JButton();
		btnDodajPlik.setBounds(0, 0, 75, 25);
		btnDodajPlik.setText("Dodaj plik");
		btnDodajPlik.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent ae) {
		          JFileChooser fileChooser = new JFileChooser();
		          int returnValue = fileChooser.showOpenDialog(null);
		          if (returnValue == JFileChooser.APPROVE_OPTION) {
		            File selectedFile = fileChooser.getSelectedFile();
		            System.out.println(selectedFile.getName());
		          }
		        }
		      });
		

	}
}
