import Prog1Tools.IOTools;

import java.util.Arrays;

public class VierGewinnt {
    public static void printField(char[][] field){
        for (int i=0; i<field.length; i++){
            for(int j=0; j<field[i].length; j++){
                System.out.print(field[i][j] + "    ");
            }
            System.out.println();
        }
    }

    public static void insertToken(char[][] field, char token, int index){ //int
        for (int i=field.length-1; i>=0; i--){
            if (field[i][index] == '_'){
                field[i][index] = 'X';
                printField(field);
                break;
            }
            else if (field[0][index] != '_'){
                System.out.println("null");
                break;
            }
        }
    }

    public static boolean isGameOver(char[][] field, char token){ //boolean
        int howLong_X = 1;
        int howLong_O = 1;
        int columnX = 1;
        int columnO = 1;
        int[] columnidX = new int[field[0].length];
        int[] columnidO = new int[field[0].length];
        boolean x_truth = false;
        boolean o_truth = false;
            for (int i=0; i<field.length; i++){
                for (int j=0; j<field[i].length; j++){
                //compare rows
//                    if (j == field[i].length-1 && !x_truth && !o_truth){
//                        howLong_X = 1;
//                        howLong_O = 1;
//                        break;
//                    }
//                    if (field[i][j] != field[i][j + 1]) {
//                        howLong_X = 1;
//                        howLong_O = 1;
//                    }
//                    if (field[i][j] == field[i][j + 1] && field[i][j] != '_' && field[i][j + 1] != '_' ) {
//                        if (field[i][j] == 'X' && field[i][j+1] == 'X' && howLong_X < 4) {
//                            howLong_X += 1;
//                        }
//
//
//                        if (field[i][j] == 'O' && field[i][j+1] == 'O' && howLong_O< 4) {
//                            howLong_O += 1;
//                        }
//                    }
//
//                    if (howLong_X == 4 || howLong_O == 4) {
//                        if (howLong_X == 4 && token == 'X') {
//                            x_truth = true;
//                            return x_truth;
//                        }
//                        if (howLong_O == 4 && token == 'O') {
//                            o_truth = true;
//                            return o_truth;
//                        }
//
//                    }
//
//                    if (!x_truth && !o_truth && ((howLong_O != 4 && token == 'O') || howLong_X != 4 && token == 'X') && i == field.length - 1 && j == field.length - 1) {
//                        if (howLong_O != 4 && token == 'O') {
//                            return x_truth;
//                        }
//                        if (howLong_X != 4 && token == 'X') {
//                            return o_truth;
//                        }
//                    }

                //compare columns
                    if (i == 0 && !x_truth && !o_truth){
                        columnX = 1;
                        columnO = 1;
                        continue;
                    }

                    if (field[i][j] == 'X' && field[i][j] != field[i-1][j]) {
                        columnX = 1;
                        columnidX[j] = 0;
                    }

                    else if (field[i][j] == 'O' && field[i][j] != field[i-1][j]) {
                        columnO = 1;
                        columnidO[j] = 0;
                    }

                    if (field[i][j] == field[i-1][j] && field[i][j] != '_') {
                        if (field[i][j] == 'X' && field[i-1][j] == 'X' && columnX < 4) {
                            columnidX[j] += 1;
                            columnX += 1;
                        }


                        if (field[i][j] == 'O' && field[i-1][j] == 'O' && columnO < 4) {
                            columnidO[j] += 1;
                            columnO += 1;
                        }
                    }

                    if (columnX == 4 || columnO == 4 || columnidX[j] == 3) {
                        if ((columnX == 4 || columnidX[j] == 3) && token == 'X') {
                            x_truth = true;
                            return x_truth;
                        }
                        if (columnO == 4 && token == 'O') {
                            o_truth = true;
                            return o_truth;
                        }

                    }

            }
        }

    return false;
    }



    // row comparison needs to compare j, where i remains the same
    // column comparison compares i, j remains same
    // diagonal [i][j] to [i+1/-1][j+1/-1)
    // the program checks who won
    // row logic: remain i, compare all elements in i
    public static void getPlayer2Move(char[][] field) {

    }

    public static void main(String[] args) {
        char[][] field = new char[][] {
                {'_', '_', '_', 'O', '_', '_', '_'},
                {'_', '_', '_', 'O', '_', '_', '_'},
                {'_', '_', 'X', 'O', '_', '_', '_'},
                {'_', '_', 'X', 'O', '_', '_', '_'},
                {'_', '_', 'X', 'O', '_', '_', '_'},
                {'_', '_', 'X', 'O', '_', '_', '_'},
        };

        //char user_Token = IOTools.readChar("Token: ");
        //int user_Index = IOTools.readInt("Which slot? (0-4)");



        //printField(field);
        //insertToken(field, 'x', 1);
        System.out.println(isGameOver(field, 'O'));
    }
}
