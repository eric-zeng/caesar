package test;

import static org.junit.Assert.*;
import model.Caesar;

import org.junit.Test;

public class CaesarTest {

  @Test
  public void testShiftString() {
    assertEquals("Empty String", "", Caesar.ShiftString("", 1, 15));
    assertEquals("Shift \"passwords\" by 16", "fqiimehti",
                 Caesar.ShiftString("passwords", 0, 16));
    assertEquals("Shift \"!Hello3. ?\" by 9", "!Qnuux2. ?",
                  Caesar.ShiftString("!Hello3. ?", 9, 9));
  }

  @Test
  public void testShiftDigit() {
    assertEquals("Shift 2 by 0", 2, Caesar.ShiftDigit(2, 0));
    assertEquals("Shift 1 by 4", 5, Caesar.ShiftDigit(1, 4));
    assertEquals("Shift 8 by 3", 1, Caesar.ShiftDigit(8, 3));
    assertEquals("Shift 4 by -2", 2, Caesar.ShiftDigit(4, -2));
    assertEquals("Shift 1 by -5", 6, Caesar.ShiftDigit(1, -5));
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testShiftDigitTooBig() {
    Caesar.ShiftDigit(10, 2);
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testShiftDigitTooSmall() {
    Caesar.ShiftDigit(-1, 21);
  }

  @Test
  public void testShiftChar() {
    assertEquals("Shift 'a' by 0", 'a', Caesar.ShiftChar('a', 0));
    assertEquals("Shift 'A' by 0", 'A', Caesar.ShiftChar('A', 0));
    assertEquals("Shift 'h' by 10", 'r', Caesar.ShiftChar('h', 10));
    assertEquals("Shift 'N' by 4", 'R', Caesar.ShiftChar('N', 4));
    assertEquals("Shift 'b' by -5", 'w', Caesar.ShiftChar('b', -5));
    assertEquals("Shift 'D' by -15", 'O', Caesar.ShiftChar('D', -15));    
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testShiftCharInvalid() {
    Caesar.ShiftChar('.', 10);
  }

}
