package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.NumberFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import controller.CaesarGUIController;

public class CaesarGUIView {
  private CaesarGUIController controller;
  
  private JFrame topLevelWindow;
  private JPanel inputRow;
  private JPanel outputRow;
  private JPanel errorRow;
  
  private JPanel buttonPanel;
  
  private JLabel inputLabel;
  private JTextArea inputField;
  
  private JPanel shiftPanel;
  private JLabel shiftLabel;
  private JTextField shiftInputField;
  
  private JButton processInputButton;
    
  private JLabel outputLabel;
  private JTextArea outputField;
    
  public CaesarGUIView() {
    controller = new CaesarGUIController(this);
    
    initInput();
    initOutput();
    initFrame();
  }
  
  public String getInputString() {
    return inputField.getText();
  }
  
  public String getShift() {
    return shiftInputField.getText();
  }
  
  public void setOutputString(String str) {
    outputField.setText(str);
  }
  
  private void initFrame() {
    topLevelWindow = new JFrame("Caesar Cipher");
    topLevelWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    topLevelWindow.setSize(768, 168);
    topLevelWindow.setLayout(new BorderLayout());
    
    topLevelWindow.add(inputRow, BorderLayout.PAGE_START);
    topLevelWindow.add(outputRow, BorderLayout.CENTER);
    
    topLevelWindow.setVisible(true);
  }
  
  private void initInput() {
    inputRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
    
    inputLabel = new JLabel("Input:     ");    
    inputField = new JTextArea(3, 50);
    inputField.setLineWrap(true);
    
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

    shiftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    shiftLabel = new JLabel ("Rotation: ");
    
    NumberFormat format = NumberFormat.getInstance();
    NumberFormatter formatter = new NumberFormatter(format);
    formatter.setValueClass(Integer.class);
    formatter.setMinimum(0);
    formatter.setMaximum(Integer.MAX_VALUE);
    
    shiftInputField = new JFormattedTextField(formatter);
    shiftInputField.setColumns(3);
    
    shiftPanel.add(shiftLabel);
    shiftPanel.add(shiftInputField);
    buttonPanel.add(shiftPanel);
    
    processInputButton = new JButton("Encrypt");
    processInputButton.addActionListener(controller);
    buttonPanel.add(processInputButton);
    
    inputRow.add(inputLabel);
    inputRow.add(inputField);
    inputRow.add(buttonPanel);
    
  }
  
  private void initOutput() {
    outputRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
    outputLabel = new JLabel("Output: ");
    outputField = new JTextArea(3, 50);
    outputField.setLineWrap(true);
    
    outputRow.add(outputLabel);
    outputRow.add(outputField);    
  }
  
  
}
