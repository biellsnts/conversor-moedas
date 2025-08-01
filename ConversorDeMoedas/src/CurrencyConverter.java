public class CurrencyConverter {
    private final ExchangeRateClient client;

    public CurrencyConverter(ExchangeRateClient client) {
        this.client = client;
    }

    public String converter(int opcao, double valor) {
        String base = "", destino = "";

        switch (opcao) {
            case 1 -> { base = "BRL"; destino = "USD"; }
            case 2 -> { base = "USD"; destino = "BRL"; }
            case 3 -> { base = "BRL"; destino = "ARS"; }
            case 4 -> { base = "CLP"; destino = "BRL"; }
            case 5 -> { base = "BOB"; destino = "BRL"; }
            case 6 -> { base = "BRL"; destino = "COP"; }
            default -> { return "Opção inválida."; }
        }

        try {
            ExchangeRateResponse rates = client.getRates(base);
            double taxa = rates.conversion_rates.get(destino);
            double convertido = valor * taxa;

            return String.format("%.2f %s = %.2f %s", valor, base, convertido, destino);
        } catch (Exception e) {
            return "Erro ao buscar taxas de câmbio: " + e.getMessage();
        }
    }
}
