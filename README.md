caesar
======

This is a simple program that performs Caesar shifts. CaesarShift.jar is a
standalone executable jar that has a GUI interface for calculating Caesar
shifts, and CaesarUtils.jar is a library that can be used by other programs
to calculate Caesar shifts. 

CaesarUtils has three static methods that can be used for computing Caesar
shifts: shiftString, shiftDigit, and shiftChar. shiftString computes the shift
on each alphanumeric character using the given rotations, ignoring other
characters. shiftDigit and shiftChar computes the shift on individual digits and
 characters using the given rotation. See src/model/Caesar.java for the source.