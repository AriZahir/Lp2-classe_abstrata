package trabalhoAriana;

public class Cliente extends Transportadora {
    private String telefone;

    public Cliente(int id, String nome, String endereco, String telefone) {
        super(id, nome, endereco);
        this.telefone = telefone;
    }

    // Método getter e setter para telefone

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Implementação do método abstrato calcularCustoTransporte
    @Override
    public double calcularCustoTransporte(double distancia) {
        // Lógica para calcular o custo do transporte para o cliente
        // Pode ser implementado de acordo com a sua necessidade
        return distancia * 0.5; // Exemplo simples: R$0,50 por km
    }
}
