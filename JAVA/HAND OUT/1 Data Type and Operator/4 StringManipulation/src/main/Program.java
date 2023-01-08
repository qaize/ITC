package main;

import java.lang.StringBuilder;

public class Program {

        public static void main(String[] args) {
                String morpheusOne = "There is a difference between knowing the path, ";
                String morpheusTwo = "and walking the path.";
                String oracleOne = "    You didn't       come here to make a choice.     ";
                String oracleTwo = "You already made it, you come here to understand why YOU made it.";
                String oracleThree = "Its says know yourself";

                /*Concate String*/
                //Concat string with + (performancenya kurang baik) karena terus menciptakan memory baru untuk string
                String morpheusQuote = morpheusOne + morpheusTwo;
                System.out.println(morpheusQuote);

                //Concat dengan append dengan menggunakan StringBuilder. Performance cepat untuk dilakukan berkali-kali, tetapi repot untuk dibentuk.
                StringBuilder morpheusQuoteBuilder = new StringBuilder();
                morpheusQuoteBuilder.append(morpheusOne);
                morpheusQuoteBuilder.append(morpheusTwo);
                System.out.println(morpheusQuoteBuilder);

                //Concat dengan concat function, lebih cepat dari + tapi tidak sebaik String builder performancennya.
                String morpheusConcatFunction = morpheusOne.concat(morpheusTwo);
                System.out.println(morpheusConcatFunction);

                //Concat using format function (interpolation)

                /*
                 * %a : untuk menggantikan floating point
                 * %b : untuk menggantikan type apa pun menjadi boolean
                 * %c : untuk menggantikan char
                 * %d : untuk menggantikan integer
                 * %e : untuk menggantikan floating point menjadi scientific notation.
                 * %f : untuk menggantikan floating point menjadi decimal number
                 * %g : untuk menggantikan floating point menjadi decimal number atau scientific notation tergantung presisinya.
                 * %h : untuk menggantikan value apa pun menjadi hex string.
                 * %0 : untuk menggantikan number value menjadi octal number
                 * %s : untuk menggantikan value apapun menjadi string
                 * %t : untuk menggantikan date time
                 * %x : untuk menggantikan number value menjadi hex string
                 * */

                String morpheusConcatFormat = String.format("%s%s", morpheusOne, morpheusTwo);
                System.out.println(morpheusConcatFormat);

                String concatinationOne = String.format("Boolean: %b, Char: %c", true, 'X');
                System.out.println(concatinationOne);

                String concatinationTwo = String.format("Floating: %.2f, Floating: %.3f", 34.56876, 12.78976);
                System.out.println(concatinationTwo);

                //Trim spasi depan dan belakang
                System.out.println(oracleOne);
                String oracleTrim = oracleOne.trim();
                System.out.println(oracleTrim);

                //Count Length, menghitung panjang string character
                int stringLength = morpheusOne.length();
                System.out.println(stringLength);

                //Substring, mengambil sepotong string dari satu index ke index lain.
                String substringQuoteOne = oracleTwo.substring(0, 11);
                String substringQuoteTwo = oracleTwo.substring(12, 20);
                System.out.println(substringQuoteOne);
                System.out.println(substringQuoteTwo);

                //Lower Case and Upper Case
                String oracleLower = oracleTwo.toLowerCase();
                System.out.println(oracleLower);
                String oracleUpper = oracleTwo.toUpperCase();
                System.out.println(oracleUpper);

                //Index of Character, index character pertama yang ditemukan
                int index = oracleTwo.indexOf('m');
                System.out.println(index);

                //Remove, Replace
                String replaced = oracleThree.replace('y', 't');
                System.out.println(replaced);

                String removed = oracleThree.replaceAll("yourself", "");
                System.out.println(removed);

                //String dengan text-block

                /*Ketika kita memiliki string dengan text yang sangat panjang, kita tidak bisa membuat new line pada
                * IDE tanpa menggunakan concate operation.
                * */
                String longText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown " +
                    "printer took a galley of type and scrambled it to make a type specimen book.";
                System.out.println(longText);

                //Pada versi java yang baru, kita bisa menggunakan triple quotation untuk membuat string text block
                String textBlock = """
                    Lorem Ipsum is simply dummy text of the printing and typesetting industry. 
                    Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown 
                    printer took a galley of type and scrambled it to make a type specimen book.
                    """;
                System.out.println(textBlock);
                /*
                * Kalau kalian perhatikan isinya sedikit berbeda, karena segala enter dan tab akan berpengaruh terhadap hasil text.
                * */
        }

}
