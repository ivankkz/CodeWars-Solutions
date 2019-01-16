package kyu4;

import java.util.Arrays;

//  Task description on https://www.codewars.com/kata/sudoku-solution-validator
public class SudokuValidator {
    public static boolean check(int[][] Matrixsudoku) {
        int countRows = Matrixsudoku.length;
        int lengthOfSquare = new Double(Math.sqrt(countRows)).intValue();

        for (int i = 0; i < countRows; i++) {
            // check all rows
            if (!checkPartOfMatrixSudoku(Matrixsudoku, i, i + 1, 0, countRows))
                return false;
            //check all columns
            if (!checkPartOfMatrixSudoku(Matrixsudoku, 0, countRows, i, i + 1))
                return false;
        }
        for (int i = 0; i < countRows; i += lengthOfSquare) {
            for (int j = 0; j < countRows; j += lengthOfSquare) {
                //check all squares
                if (!checkPartOfMatrixSudoku(Matrixsudoku, i, i + lengthOfSquare, j, j + lengthOfSquare))
                    return false;
            }
        }

        return true;
    }

//        [iStart; iEnd) including row\column with starting index and not including row\column with ending index
    private static boolean checkPartOfMatrixSudoku(int[][] sudoku, int iStartRow, int iEndRow, int iStartColumn, int iEndColumn) {
        int[] temp = new int[(iEndRow - iStartRow) * (iEndColumn - iStartColumn)];
        int iTemp = 0;

        for (int i = iStartRow; i < iEndRow; i++) {
            for (int j = iStartColumn; j < iEndColumn; j++) {
                temp[iTemp] = sudoku[i][j];
                iTemp++;
            }
        }

        Arrays.sort(temp);
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != i + 1)
                return false;
        }

        return true;
    }

}
