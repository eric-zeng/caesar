package controller;

import java.util.Scanner;

import model.Caesar;
import view.CaesarTerminalView;

public class CaesarTerminal {
  /**
   * Encrypts a given string using a Caesar cipher (right shift). The
   * characters A-Z, a-z, and 0-9 will be shifted, other characters will not be
   * changed.
   */
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    CaesarTerminalView.Intro();
    while(true) {
      CaesarTerminalView.PromptPlaintext();
      String plaintext = s.nextLine();
      
      CaesarTerminalView.PromptDigitShift();
      int digitShift = Integer.parseInt(s.nextLine());
      
      CaesarTerminalView.PromptCharShift();
      int charShift = Integer.parseInt(s.nextLine());
      
      CaesarTerminalView.Print(Caesar.ShiftString(plaintext, digitShift,
                                                  charShift));
    }
  }
}
