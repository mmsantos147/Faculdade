import java.io.*;
import java.util.*;

public class Image {

  private int rows;
  private int cols;
  private int maxValue;
  public int[][] pixels;

  public Image(int rows, int cols, int maxValue) {
    this.rows = rows;
    this.cols = cols;
    this.maxValue = maxValue;
    pixels = new int[rows][cols];
  }

  // Constructor, needs filename
  public Image(String filename) {
    try {
      Scanner infile = new Scanner(new FileReader(filename + ".pgm"));
      String filetype = infile.nextLine();
      String comment = infile.nextLine();
      if (comment.charAt(0) != '#') {
        String[] dim = comment.split(" ");
        cols = Integer.parseInt(dim[0]);
        rows = Integer.parseInt(dim[1]);
      } else {
        System.out.println(comment);
        cols = infile.nextInt();
        rows = infile.nextInt();
      }
      maxValue = infile.nextInt();

      pixels = new int[rows][cols];

      System.out.println(
        "Leitura da imagem " +
        filename +
        ".pgm, type=" +
        filetype +
        " (" +
        rows +
        " x " +
        cols +
        ")"
      );

      //Read in image
      for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {
          pixels[r][c] = infile.nextInt();
        }
      }
      infile.close();
    } catch (FileNotFoundException fe) {
      System.out.println("arquivo não encontrado");
    } catch (Exception e) {
      System.out.println(e.toString() + " erro no arquivo .PGM");
      e.printStackTrace();
    }
  }

  public void setPixel(int r, int c, int value) {
    pixels[r][c] = value;
  }

  public int getPixel(int r, int c) {
    return pixels[r][c];
  }

  public int getNumCols() {
    return cols;
  }

  public int getNumRows() {
    return rows;
  }

  public int getMaxValue() {
    return maxValue;
  }

  public void saveToFile(String filename) {
    try {
      PrintWriter outfile = new PrintWriter(filename + ".pgm");
      System.out.println("Escrevendo o arquivo: " + filename + ".pgm");

      outfile.println("P2"); // Ascii PPM file
      outfile.println("# Image created by Image.java");
      outfile.println(cols + " " + rows);
      outfile.println(maxValue);

      for (int count = 0, r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {
          outfile.print(pixels[r][c] + " ");
          if (++count > 20) {
            count = 0;
            outfile.println("");
          }
        }
      }
      outfile.close();
    } catch (Exception e) {
      System.out.println(e.toString() + " erro no arquivo .PGM.");
      e.printStackTrace();
    }
  }
}
