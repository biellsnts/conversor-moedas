import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExchangeRateClient apiClient = new ExchangeRateClient("0481ce894154edf0bdf82204");
        CurrencyConverter converter = new CurrencyConverter(apiClient);

        while (true) {
            System.out.println("\n=== Conversor de Moedas ===");
            System.out.println("1. BRL para USD");
            System.out.println("2. USD para BRL");
            System.out.println("3. BRL para ARS");
            System.out.println("4. CLP para BRL");
            System.out.println("5. BOB para BRL");
            System.out.println("6. BRL para COP");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 0) {
                System.out.println("Programa encerrado.");
                break;
            }

            System.out.print("Digite o valor a ser convertido: ");
            double valor = scanner.nextDouble();

            String resultado = converter.converter(opcao, valor);
            System.out.println(resultado);
        }

        scanner.close();
    }
}
