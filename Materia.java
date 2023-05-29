package trabalhoAriana;

public class Materia extends Transportadora {
    private String tipo;

    public Materia(int id, String nome, String endereco, String tipo) {
        super(id, nome, endereco);
        this.tipo = tipo;
    }

    // Método getter e setter para tipo

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Implementação do método abstrato calcularCustoTransporte
    @Override
    public double calcularCustoTransporte(double distancia) {
        // Lógica para calcular o custo do transporte para a matéria
        // Pode ser implementado de acordo com a sua necessidade
        return distancia * 0.3; // Exemplo simples: R$0,30 por km
    }
}
