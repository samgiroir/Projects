import java.awt.*;
import javax.swing.*;
/**
 * Samantha Giroir
 * The class GameDisplay is a class to be used with the GameGui class
 * It provides the setup of the grid and the paintComponent.
 */
public class GameDisplay extends JPanel{
  
  boolean[][] grid;
  
  /*
   * The constructor takes a grid so the grid passed in 
   * is set to the grid in the class, those pointing to the 
   * same memory allocation
   */
  public GameDisplay(boolean [][] newGrid){
    this.grid = newGrid;
    setBackground(Color.BLACK);
  }
  
  public void setGrid(boolean[][] newGrid){
    grid = newGrid;
  }
  
  /*
   * The cellWidth and cellHeight are set to 10 these are the 
   * amount of pixels for each side of the cell
   * The loop creates the color of the cells and draws the border 
   * around each cell. The cell is white if it is not true and magenta
   * or pink if it is true.
   * The border is black.
   */
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    
    int cellWidth = 10;
    int cellHeight = 10;
    for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid.length; j++){
        if(grid[i][j] == true){
          g.setColor(Color.MAGENTA);
          g.fillRect(((j*cellWidth)), ((i*cellHeight)), cellWidth, cellHeight);
        }
        else{
          g.setColor(Color.WHITE);
          g.fillRect(((j*cellWidth)), ((i*cellHeight)), cellWidth, cellHeight);
        }
        g.setColor(Color.BLACK);
        g.drawRect((j*cellWidth), (i*cellHeight), cellWidth, cellHeight);
      }
    }
  }
}//end of class

