package org.academiadecodigo.mathinha.grid;

public interface Grid {

    /**
     * Initializes the grid
     */
    public void init() throws InterruptedException;

    /**
     * Gets the number of columns in the grid
     *
     * @return the number of columns
     */
    public int getCols();

    /**
     * Gets the number of rows in the grid
     *
     * @return the number of rows
     */
    public int getRows();


}
