
package uts_pbo;




/**
 *
 * @author Danu Hartanto - A11201710606
 * 
 */
import java.util.Scanner;
import java.util.Stack;
public class UTS_PBO {
    
    public static void main (String [] args){
         Test test = new Test();
        String inputan = test.Input_Stack();

        String cek = test. conversiStringToStack(inputan);
        if (cek != "x"){
            test.cekInput(test.stackPoint,inputan);
    }
    }
}

