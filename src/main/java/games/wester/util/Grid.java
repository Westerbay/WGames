package games.wester.util;

/*
 * Wester
 * This code is open source and free to use.
 *
 * You are free to copy, modify, and distribute this file without restriction.
 * No warranties are provided, and any use of this code is at your own risk.
 */

import java.util.Iterator;

/**
 * @author Wester
 */
public class Grid<E> implements Iterable<E> {

    private final int _numberOfRows;
    private final int _numberOfColumns;
    private final E[][] _matrix;

    public Grid(E[][] matrix) {
        _numberOfRows = matrix.length;
        _numberOfColumns = matrix[0].length;
        _matrix = matrix;
    }

    public Grid(E[][] matrix, E valueToFill) {
        this(matrix);
        fill(valueToFill);
    }

    public Grid(E[][] matrix, ClassGenerator<E> classGenerator) {
        this(matrix);
        fill(classGenerator);
    }

    public void fill(E valueToFill) {
        for (int i = 0; i < _numberOfRows; i ++) {
            for (int j = 0; j < _numberOfColumns; j ++) {
                _matrix[i][j] = valueToFill;
            }
        }
    }

    public void fill(ClassGenerator<E> classGenerator) {
        for (int i = 0; i < _numberOfRows; i ++) {
            for (int j = 0; j < _numberOfColumns; j ++) {
                _matrix[i][j] = classGenerator.generate();
            }
        }
    }

    public int getNumberOfRows() {
        return _numberOfRows;
    }

    public int getNumberOfColumns() {
        return _numberOfColumns;
    }

    public E get(int numberOfCell) {
        if (numberOfCell < 0) {
            throw new IndexOutOfBoundsException("Negative index is not allowed in Grid");
        }
        if (numberOfCell >= _numberOfRows * _numberOfColumns) {
            throw new IndexOutOfBoundsException("The number of the cell is bigger than the grid size");
        }
        return _matrix[numberOfCell / _numberOfColumns][ numberOfCell % _numberOfColumns];
    }

    public E get(int indexRow, int indexColumn) {
        if (indexRow >= _numberOfRows || indexRow < 0) {
            throw new IndexOutOfBoundsException("Row index is bigger than the number of rows");
        }
        if (indexColumn >= _numberOfColumns || indexColumn < 0) {
            throw new IndexOutOfBoundsException("Column index is bigger than the number of columns");
        }
        return _matrix[indexRow][indexColumn];
    }

    public void set(int indexRow, int indexColumn, E value) {
        if (indexRow >= _numberOfRows || indexRow < 0) {
            throw new IndexOutOfBoundsException("Row index is bigger than the number of rows");
        }
        if (indexColumn >= _numberOfColumns || indexColumn < 0) {
            throw new IndexOutOfBoundsException("Column index is bigger than the number of columns");
        }
        _matrix[indexRow][indexColumn] = value;
    }

    public void set(int numberOfCell, E value) {
        if (numberOfCell < 0) {
            throw new IndexOutOfBoundsException("Negative index is not allowed in Grid");
        }
        if (numberOfCell >= _numberOfRows * _numberOfColumns) {
            throw new IndexOutOfBoundsException("The number of the cell is bigger than the grid size");
        }
        _matrix[numberOfCell / _numberOfColumns][numberOfCell % _numberOfColumns] = value;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

}
