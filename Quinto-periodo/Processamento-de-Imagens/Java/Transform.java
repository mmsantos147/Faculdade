public class Transform {

  public static Image negative(Image img) {
    for (int i = 0; i < img.getNumRows(); i++) {
      for (int j = 0; j < img.getNumCols(); j++) {
        img.setPixel(i, j, img.getMaxValue() - img.getPixel(i, j));
      }
    }
    return img;
  }

  public static Image convolucao(Image In) {
    Image Out = new Image(In.getNumRows(), In.getNumCols(), In.getMaxValue());
    for (int i = 1; i < In.getNumRows() - 1; i++) {
      for (int j = 1; j < In.getNumCols() - 1; j++) {
        int sum = 0;
        for (int y = -1; y <= 1; y++) {
          for (int x = -1; x <= 1; x++) {
            sum += In.pixels[i + y][j + x];
          }
        }
        Out.pixels[i][j] = sum / 9;
      }
    }
    return Out;
  }
}
