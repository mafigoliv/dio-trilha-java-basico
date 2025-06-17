import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Locale;

public class ContaTerminal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        int numeroConta;
        while (true) {
            System.out.println("Digite o número da conta: ");
            if (sc.hasNextInt()) {
                numeroConta = sc.nextInt();
                sc.nextLine();
                break;
            }
            System.out.println("Entrada inválida. Por favor, digite um número inteiro!");
            sc.nextLine();
        }

        String numeroAgencia;
        while (true) {
            System.out.println("Digite o número da agência: ");
            numeroAgencia = sc.nextLine().trim();

            if (!numeroAgencia.matches("\\d+")) {
                System.out.println("Entrada inválida. Por favor, digite apenas números!");
                continue;
            }

            numeroAgencia = numeroAgencia.length() > 1
                    ? numeroAgencia.substring(0, numeroAgencia.length() - 1) + "-" + numeroAgencia.charAt(numeroAgencia.length() - 1)
                    : numeroAgencia;
            break;
        }

        System.out.println("Digite o seu nome: ");
        String nomeCliente = sc.nextLine().toUpperCase();

        BigDecimal saldo = BigDecimal.ZERO;
        while (true) {
            System.out.println("Digite o saldo atual: ");
            if (sc.hasNextBigDecimal()) {
                saldo = sc.nextBigDecimal();
                break;
            } else {
                System.out.println("Entrada inválida. Por favor, use ponto como separador decimal!");
                sc.nextLine();
            }
        }

        sc.close();

        System.out.printf(
            "%nOlá %s, obrigado por criar uma conta em nosso banco,%n" +
            "sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque.%n",
            nomeCliente, numeroAgencia, numeroConta, saldo
        );

    }
}
