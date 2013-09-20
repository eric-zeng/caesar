package view;

public class CaesarTerminalView {
  
  public static void Intro() {
    System.out.println("Caesar cipher");
    System.out.println("Enter a string to be encrypted, followed by the" +
                       " number of places to shift each letter/digit");
    System.out.println();
  }
  
  public static void PromptPlaintext() {
    System.out.print("Plaintext: ");
  }
  
  public static void PromptDigitShift() {
    System.out.print("Digit shift: ");
  }
  
  public static void PromptCharShift() {
    System.out.print("Letter shift: ");
  }
  
  public static void Print(String s) {
    System.out.println(s);
    System.out.println();
  }
  
}
