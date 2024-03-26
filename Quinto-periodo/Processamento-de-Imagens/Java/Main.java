import java.io.IOException;

public class Main {
//float T[] = new float[img.getMax()+1];
// for(int i = 0; i<img.getMax();i++)
// T[i] = Math.sqrt(i)/Math.sqrt(img.getMax()) * img.getmax();
  public static void main(String[] args) throws IOException {
    Image img = new Image(args[0]);
    Image out;
    out = Transform.negative(img);
    // out = Transform.convolucao(img);
    out.saveToFile("result");

    boolean isWindows = System
      .getProperty("os.name")
      .toLowerCase()
      .startsWith("windows");
    if (isWindows) {
      Runtime.getRuntime().exec("i_view64.exe result.pgm");
    } else {
      Runtime.getRuntime().exec("eog result.pgm &");
    }
  }
}
