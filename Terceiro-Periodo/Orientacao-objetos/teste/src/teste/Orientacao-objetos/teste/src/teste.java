public class teste {
	
	public static void main(String[] args) {
		int[] n = {0,0,0,0,0,0,0,0,0,0};
		int[] x = {0,0,0,0,0};
		int[] y = {0,0,0,0,0};
			for (int i = 0; i < 10; i++) {
				n[i] = (int)(Math.random() * 101);
				System.out.println(n[i]);
			}
			for (int i = 0, j = 0; i< 5 || j < 10; i++, j = j+2) {
				x[i] = Math.max(n[j], n[j+1]);
				y[i] = Math.min(n[j], n[j+1]);
				System.out.println(x[i]);
				System.out.println(y[i]);
			}
		}
	}