
Files (in src/):
  Q1_GenericSum.java      - Generic sum using <T extends Number> and doubleValue()
  Q2_OptionalEmail.java   - Optional<String>: of, empty, ifPresent, orElse, orElseThrow
  Q3_Result.java          - Result<T extends Number>: average/percentage, pass check, Optional, requireNonNull
  Q4_EventManager.java    - LocalDate/LocalTime event manager (interactive, uses Scanner)
  Q5_GenericUtility.java  - Utility: isEqual, getDefault, max, isNull
  Main.java               - Runs Q1, Q2, Q3, Q5 together

How to compile and run:
  cd src
  javac *.java
  java Q1_GenericSum
  java Q2_OptionalEmail
  java Q3_Result
  java Q4_EventManager      (enter name, date, time as HH:mm, venue or press Enter)
  java Q5_GenericUtility
  java Main                 (runs Q1, Q2, Q3, Q5)
