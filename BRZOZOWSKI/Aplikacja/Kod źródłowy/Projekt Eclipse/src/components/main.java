package components;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class main {
	
		

    private static void createAndShowGUI() {

        //Generuj� ramk� interfejsu
        JFrame frame = new JFrame("�ukasz Brzozowski, Projekt Indywidualny");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(320,250));

        //Generuj� przycisk
        
        JButton przycisk = new JButton();
        przycisk.setSize(100, 30);
        przycisk.setVisible(true);
        przycisk.setText("Dodaj plik");
        frame.add(przycisk);
        
        //Wy�wietlam loga
        JLabel logoMiniLabel = new JLabel();
        ImageIcon logoMini = new ImageIcon("bin" + File.separator + "logo_mini.png");
        Image image = logoMini.getImage();
        Image newimg = image.getScaledInstance(300, 85,  java.awt.Image.SCALE_SMOOTH);
        logoMini = new ImageIcon(newimg); 
        
        JLabel logoPWLabel = new JLabel();
        ImageIcon logoPW = new ImageIcon("bin" + File.separator + "pw_logo.png");
        Image image1 = logoPW.getImage();
        Image newimg1 = image1.getScaledInstance(300, 100, java.awt.Image.SCALE_SMOOTH);
        logoPW = new ImageIcon(newimg1);
        
        logoMiniLabel.setIcon(logoMini);
        logoMiniLabel.setPreferredSize(new Dimension(300, 85));
        
        logoPWLabel.setIcon(logoPW);
        logoPWLabel.setPreferredSize(new Dimension(300, 100));

        frame.getContentPane().add(logoMiniLabel, BorderLayout.NORTH);
        frame.getContentPane().add(logoPWLabel, BorderLayout.PAGE_END);

        
        //Dzia�anie przycisku
        przycisk.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              JFileChooser fileChooser = new JFileChooser();
              FileNameExtensionFilter filter = new FileNameExtensionFilter("Pliki tekstowe", "txt", "text");
              fileChooser.setFileFilter(filter);
              switch (fileChooser.showOpenDialog(frame)) {
                  case JFileChooser.APPROVE_OPTION:
                      File wybranyPlik = fileChooser.getSelectedFile();
                      
                      //Generuj� now� ramk�
                      JFrame frame1 = new JFrame(wybranyPlik.getName());
                      frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                      frame1.setPreferredSize(new Dimension(300, 200));
                      frame1.setVisible(true);
                      frame1.pack();
                      
                      //Wy�wietlam wyb�r pliku
                      JLabel label = new JLabel("Wybrano plik: " + wybranyPlik.getName());
                      frame1.getContentPane().add(label, BorderLayout.NORTH);
                      Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                      frame1.setLocation(dim.width/2-frame1.getSize().width/2, dim.height/2-frame1.getSize().height/2);
                      
                      //Przycisk do generowania animacji
                      
                      JButton generuj = new JButton();
                      generuj.setSize(100, 30);
                      generuj.setVisible(true);
                      generuj.setText("Generuj animacj�");
                      frame1.add(generuj, BorderLayout.CENTER);
                      
                      //Ramka z tekstem
                      
                      JTextArea ramkaTekstu = new JTextArea(10, 30);
                      ramkaTekstu.setText(metody.wczytajTekst.readBytesFromFile(wybranyPlik));
                      
                      JFrame frame2 = new JFrame("Tekst");
                      frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                      frame2.setPreferredSize(new Dimension(400, 300));
                      frame2.setVisible(true);
                      frame2.getContentPane().add(ramkaTekstu);
                      frame2.pack();
                      
                      //Dzia�anie przycisku
                      
                      generuj.addActionListener(new ActionListener() {
                          @Override
                          public void actionPerformed(ActionEvent e) {
                        	  //Generuj� list� liter na podstawie pobranego pliku
                        	  List<String> wczytanyTekst = metody.wczytajTekst.wynikWczytania(wybranyPlik);
                        	  //Generuj� list� kolor�w do wy�wietlenia
                        	  try {
								Color[] kolory = metody.wczytajTabele.wczytajKolory("bin" +File.separator + "BazaDanych.txt", wczytanyTekst);
								//Generuj� now� ramk�
								JPanel rectangle = new JPanel();
								JFrame frame3 = new JFrame();
						        frame3.getContentPane().setLayout(null);
						        frame3.setSize(600,480);
						        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						        frame3.add(rectangle);
			                    frame3.setLocation(dim.width/2-frame3.getSize().width/2, dim.height/2-frame3.getSize().height/2);
						        rectangle.setBounds(0,0,600,480);
						        rectangle.setBackground(Color.RED);
						        frame3.setVisible(true);
						        //Rozpocz�cie animacji
						        ActionListener zmienKolor = new ActionListener() {
						        	Integer i = 0;
									@Override
									public void actionPerformed(ActionEvent arg0) {
										if(!i.equals(kolory.length)) {
										rectangle.setBackground(kolory[i]);
										i++;
									}else {
										frame.dispose();
										((Timer)arg0.getSource()).stop();
									}
									}
								};
						        Timer timer = new Timer(200, zmienKolor);
						        timer.start(); 
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
                          }
                      });
                     
                      break;
              }
           
          }
      });
        
        //Wy�wietlam interfejs
        frame.pack();
        frame.setVisible(true);
        
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

    }
}