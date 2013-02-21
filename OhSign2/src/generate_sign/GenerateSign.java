package generate_sign;

public class GenerateSign {

    static int lineLen = 0;
    static int printMax = 0;
    static int printMin = 0;
    static int spaceCount = 0; 
    
    static String[] sign = {
        "WELCOME",
        "TO",
        "CCC",
        "GOOD",
        "LUCK",
        "TODAY"
    };
    
    public static void printLine(int w) {
        int dotsRequired = w - lineLen;
        if (printMin == printMax - 1) {
            while (sign[printMin].length() != w) {
                sign[printMin] += ".";
                dotsRequired--;
            }
        } else {
            while (dotsRequired != 0) {
                for (int j = printMin; j < printMax - 1; j++) {
                    sign[j] += ".";
                    dotsRequired--;
                    if (dotsRequired == 0) {
                        break;
                    }
                }

            }
        }
        for (int k = printMin; k <= printMax - 1; k++) {
            System.out.print(sign[k]);
        }

        System.out.println("");        
    }
    
    public static void generateSign (int w) {

        for (int i = 0; i < sign.length; i++) {
            if (lineLen + sign[i].length() + spaceCount <= w) {
                lineLen += sign[i].length();
                printMax++;
                spaceCount++;
            } else {
                
                printLine(w);
                
                printMin = printMax;
                lineLen = 0;
                i--;
                spaceCount = 0;
            }
        }
        printLine(w);
    }
    
    public static void main(String args[]) {
        generateSign(16);
    }
}