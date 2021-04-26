
package uts_pbo;

import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author Danu Hartanto - A11201710606
 */
public class Test {
     Stack<Character> stackPoint = new Stack<>();
    Stack<Character> left = new Stack<>();
    Stack<Character> right = new Stack<>();
    public String Input_Stack() {
       // untuk input tumpukan kiri dan kanan ( 111+11=1111+1)
        Scanner input = new Scanner(System.in);
        System.out.print("input  :");
        
        String inputan = input.next();
        //untuk mengembalikan nilai varibel inputan
        return inputan;
    }
    // mengecek persamaan inputan . persamaan inputan variable yang di inputan berupa 1, + , =
    public String conversiStringToStack(String inputan){
        String cekInputan = "y";
        int indexs = inputan.indexOf("=");
        int indexs2 = inputan.indexOf("1");
        if (indexs == -1 || indexs2 == -1){// mengecek jumlah indeks  kanan dan kiri apakah jika jumlahnya sama berarti memenuhi persamaan ,tanda +, = tidak di hitung
            System.out.println(inputan + " adalah persamaan yang tidak valid");
            cekInputan = "x";
        }
        String z = "+";
        char plus = z.charAt(0);
        String k = "=1";
        char equal = k.charAt(0);
        char one = k.charAt(1);
        //cek yang di izinkan karakter
        for (int i = 0; i < inputan.length(); i ++){
            if (inputan.charAt(i) != plus){
                this.stackPoint.push(inputan.charAt(i));
                if (inputan.charAt(i) != one && inputan.charAt(i) != equal){
                    System.out.println(inputan + " tidak valid karena karakter yang diijinkan hanya 1,+,dan=");
                    cekInputan = "x";
                }

            }
        }
        return cekInputan;
    }
    public void cekInput(Stack stack,String inputan){
        String k = "=1";
        char equal = k.charAt(0);
        char one = k.charAt(1);
        int counter = 0;
        String cek = "t";
        left = stackPoint;
        for (int j = 0; j < stackPoint.size();j++){
            if (left.peek() == one){/* scanning string kanan kiri dan push  1 sampai ketemu = setelah itu
                pencocokan 1 nilai dari stack*/
                right.push(left.pop());
            }
            if (left.peek() == equal){
                left.pop();
                counter ++;
                if (counter == 2) {// tanda yang digunakan lebih dari satu
                    System.out.println(inputan + " tidak valid karena hanya satu tanda sama dengan yang diijinkan.");
                    cek = "s";
                    break;
                }
            }
        }
        if (cek == "t"){
            if (left.size() == right.size()){ // nilai hasil jumlah antara kiri dan kanan sama
                System.out.println(inputan + " adalah persamaan yang valid");
            }
            if (left.size() != right.size()){// nilai hasil jumlah antara kiri dan kanan berbeda
                System.out.println(inputan + " adalah persamaan yang tidak valid");
            }
        }
    }
}
