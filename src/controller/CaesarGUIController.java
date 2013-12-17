package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Caesar;
import view.CaesarGUIView;

public class CaesarGUIController implements ActionListener {
  
  private CaesarGUIView view;
  
  public CaesarGUIController(CaesarGUIView view) {
    this.view = view;
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    String plaintext = view.getInputString();
    String shiftString = view.getShift();
    int shift =  Integer.parseInt(shiftString); 
    
    String ciphertext = Caesar.ShiftString(plaintext, shift, shift);
    view.setOutputString(ciphertext);    
  }

}
