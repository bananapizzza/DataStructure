package com.minseungkwon.datastructure.Array;

public class ArrayAlgorithm {

    //Rotate image to left
    public int[][] rotateImage(int[][] image) {
        for (int s = 0, e = image.length - 1; s < e; s++, e--) {
            for (int i = s, j = e; i < e; i++, j--) {
                int temp = image[s][i];
                image[s][i] = image[i][e];
                image[i][e] = image[e][j];
                image[e][j] = image[j][s];
                image[j][s] = temp;
            }
        }
        return image;
    }

    //Find zero in the given matrix, and set the zero's column and row to all zero
    //Without using extra storage
    public int[][] setZeroToAllZero(int[][] matrix) {
        int fc = -1;
        int fr = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    //Designate one of the zero's col and row as as a storage
                    //to store what col and row should be modified to zero
                    if (fc == -1) {
                        fc = col;
                        fr = row;
                    }
                    //Store the zero's col and row info in the designated col and row by making the data to zero
                    matrix[row][fc] = 0;
                    matrix[fr][col] = 0;
                }
            }
        }

        //If there is no zero, return the original matrix
        if (fc == -1) {
            return matrix;
        }

        //Set all the columns that is set to zero in the designated row to zero
        //Except the designated col (Since it has info of the rows to be set to zero)
        for (int col = 0; col < matrix[0].length; col++) {
            if (matrix[fr][col] == 0 && col != fc) {
                setColsToZero(col, matrix);
            }
        }

        //Set all the rows that is set to zero in the designated col to zero
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][fc] == 0) {
                setRowsToZero(row, matrix);
            }
        }

        //Lastly, set all the data of the designated col to zero
        setColsToZero(fc, matrix);
        return matrix;
    }

    private void setColsToZero(int col, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][col] = 0;
        }
    }

    private void setRowsToZero(int row, int[][] matrix) {
        for (int col = 0; col < matrix[0].length; col++) {
            matrix[row][col] = 0;
        }
    }
}
