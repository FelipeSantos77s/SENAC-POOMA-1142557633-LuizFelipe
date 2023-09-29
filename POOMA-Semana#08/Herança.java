import java.util.Scanner;

abstract class Funcionario {
    String nome;
    String departamento;
    String funcao;

    abstract double calcularSalario();

    void imprimirComprovante() {
        System.out.println("Nome: " + nome);
        System.out.println("Departamento: " + departamento);
        System.out.println("Função: " + funcao);
        System.out.println("Salário: " + calcularSalario());
    }
}

class Tarefereiro extends Funcionario {
    int quantidadeTarefas;
    double valorTarefa;

    double calcularSalario() {
        return quantidadeTarefas * valorTarefa;
    }
}

class Horista extends Funcionario {
    int horasTrabalhadas;
    double valorHora;

    double calcularSalario() {
        return horasTrabalhadas * valorHora;
    }
}

class Mensalista extends Funcionario {
    double salarioMensal;

    double calcularSalario() {
        return salarioMensal;
    }
}

public class Herança {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o tipo de funcionário (Tarefereiro, Horista, Mensalista): ");
        String tipoFuncionario = scanner.nextLine();

        Funcionario funcionario;

        switch (tipoFuncionario) {
            case "Tarefereiro":
                funcionario = new Tarefereiro();
                System.out.println("Digite a quantidade de tarefas: ");
                ((Tarefereiro) funcionario).quantidadeTarefas = scanner.nextInt();
                System.out.println("Digite o valor da tarefa: ");
                ((Tarefereiro) funcionario).valorTarefa = scanner.nextDouble();
                break;
            case "Horista":
                funcionario = new Horista();
                System.out.println("Digite as horas trabalhadas: ");
                ((Horista) funcionario).horasTrabalhadas = scanner.nextInt();
                System.out.println("Digite o valor da hora: ");
                ((Horista) funcionario).valorHora = scanner.nextDouble();
                break;
            case "Mensalista":
                funcionario = new Mensalista();
                System.out.println("Digite o salário mensal: ");
                ((Mensalista) funcionario).salarioMensal = scanner.nextDouble();
                break;
            default:
                throw new IllegalArgumentException("Tipo de funcionário inválido");
        }

        System.out.println("Digite o nome do funcionário: ");
        funcionario.nome = scanner.next();
        System.out.println("Digite o departamento do funcionário: ");
        funcionario.departamento = scanner.next();
        System.out.println("Digite a função do funcionário: ");
        funcionario.funcao = scanner.next();

        funcionario.imprimirComprovante();
    }
}
