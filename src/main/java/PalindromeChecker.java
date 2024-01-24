import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
public void tester()
{
  //String lines[] = loadStrings("palindromes.txt");
  String[] lines = new String[6]; 
    try{
        File myFile = new File("palindromes.txt");
        Scanner myReader = new Scanner(myFile);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            lines[counter] = data;
            counter++;
        }
        myReader.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
  System.out.println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      System.out.println(lines[i] + " IS a palindrome.");
    }
    else
    {
      System.out.println(lines[i] + " is NOT a palindrome.");
    }
  }
}
public boolean palindrome(String word)
{
  String originalString = word;
  originalString =originalString.toLowerCase();
  originalString = noSpace(originalString);
  originalString = allLetters(originalString);
  //System.out.println(originalString);
  if(reverse(word).equals(originalString)){
    return true;
  }
  return false;
}
public String reverse(String str)
{
    String sNew = new String();
    str = str.toLowerCase();   
    str = noSpace(str);
    str = allLetters(str);
  
    for(int i = 0; i < str.length(); i++){
      sNew = str.charAt(i) + sNew;
    }    
    return sNew;
}
public String noSpace(String str){
    String noSpace = new String("");
    for(int i = 0; i < str.length(); i++){
      if(str.charAt(i) != ' ')
        noSpace = noSpace + str.charAt(i);
    }
    return noSpace;
}
public String allLetters(String str){
  String newString = new String("");
  for(int i = 0; i < str.length(); i++){
      if(Character.isLetter(str.charAt(i))){
        newString = newString + str.charAt(i);
      }
    }
  return newString;
}
}
