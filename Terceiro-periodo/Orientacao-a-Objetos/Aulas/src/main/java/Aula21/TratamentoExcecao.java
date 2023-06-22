package Aula21;

public class TratamentoExcecao {
    public static void main(String[] args) {
            try
            {
                for (int i = 0; i < 4; i++) {
                    System.out.println("args[" + i + "] = " + args[i]);
                }
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Exceção capturada..: " + e.toString());
                System.out.println("A aplicação está sendo finalizada");
            }
        }
    }

