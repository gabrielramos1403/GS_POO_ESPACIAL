package gspoo;

import java.util.Scanner;

// a cllasse principal do projto: menu interativo por console.
public class SistemaMonitoramento {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SensorTemperatura sensorTemperatura = new SensorTemperatura(1, "Sensor Térmico Principal");
        SensorPressao sensorPressao = new SensorPressao(2, "Sensor de Pressão Interna");
        SensorRadiacao sensorRadiacao = new SensorRadiacao(3, "Sensor de Radiação Cósmica");

        Sensor[] sensores = {sensorTemperatura, sensorPressao, sensorRadiacao};

        for (Sensor sensor : sensores) {
            ((ComponenteEspacial) sensor).ligar();
        }

        PropulsaoQuimica propulsaoQuimica = new PropulsaoQuimica("Motor Químico Principal");
        PropulsaoEletrica propulsaoEletrica = new PropulsaoEletrica("Motor Elétrico Auxiliar");

        SistemaPropulsao[] propulsoes = {propulsaoQuimica, propulsaoEletrica};

        DadosMissao dadosMissao = new DadosMissao(
                "Órbita Baixa da Terra - Setor A7",
                "GS2026",
                75,
                "Terra -> Lua -> Estação Orbital",
                4
        );

        int opcao;

        do {
            exibirMenuPrincipal();
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    verificarSensores(sensores);
                    break;
                case 2:
                    controlarPropulsao(propulsoes);
                    break;
                case 3:
                    gerenciarDadosMissao(dadosMissao);
                    break;
                case 4:
                    simularAlertas(sensorTemperatura, sensorPressao, sensorRadiacao, dadosMissao);
                    break;
                case 5:
                    exibirStatusCompleto(sensores, propulsoes, dadosMissao);
                    break;
                case 0:
                    System.out.println("Sistema encerrado. Boa viagem espacial!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n========== PLATAFORMA DE MONITORAMENTO ESPACIAL ==========");
        System.out.println("1 - Verificar sensores");
        System.out.println("2 - Controlar propulsão");
        System.out.println("3 - Gerenciar dados da missão");
        System.out.println("4 - Simular alertas");
        System.out.println("5 - Exibir status completo");
        System.out.println("0 - Encerrar");
        System.out.println("==========================================================");
    }

    private static void verificarSensores(Sensor[] sensores) {
        System.out.println("\n--- VERIFICAÇÃO DOS SENSORES ---");

        for (Sensor sensor : sensores) {
            double valor = sensor.lerValor();
            ComponenteEspacial componente = (ComponenteEspacial) sensor;

            System.out.println("\n" + sensor.retornarTipo());
            System.out.println(componente.exibirInformacoesBasicas());
            System.out.println("Valor lido: " + String.format("%.2f", valor));
            System.out.println("Funcionamento: " + (sensor.verificarFuncionamento() ? "OK" : "FALHA"));
            System.out.println("Status: " + componente.verificarStatus());
        }
    }

    private static void controlarPropulsao(SistemaPropulsao[] propulsoes) {
        System.out.println("\n--- CONTROLE DE PROPULSÃO ---");
        System.out.println("1 - Propulsão Química");
        System.out.println("2 - Propulsão Elétrica");

        int escolha = lerInteiro("Escolha o sistema de propulsão: ");

        if (escolha < 1 || escolha > propulsoes.length) {
            System.out.println("Sistema de propulsão inválido.");
            return;
        }

        SistemaPropulsao propulsao = propulsoes[escolha - 1];

        System.out.println("\nSistema selecionado: " + propulsao.getNome());
        System.out.println("1 - Ligar motor");
        System.out.println("2 - Desligar motor");
        System.out.println("3 - Acelerar");
        System.out.println("4 - Exibir status");

        int acao = lerInteiro("Escolha uma ação: ");

        switch (acao) {
            case 1:
                propulsao.ligarMotor();
                System.out.println("Motor ligado com sucesso.");
                break;

            case 2:
                propulsao.desligarMotor();
                System.out.println("Motor desligado com sucesso.");
                break;

            case 3:
                double potencia = lerDouble("Informe a potência desejada entre 0 e 100: ");
                System.out.println(propulsao.acelerar(potencia));
                break;

            case 4:
                System.out.println(propulsao.exibirStatus());
                break;

            default:
                System.out.println("Ação inválida.");
        }
    }

    private static void gerenciarDadosMissao(DadosMissao dadosMissao) {
        System.out.println("\n--- GERENCIAMENTO DOS DADOS DA MISSÃO ---");
        System.out.println("1 - Exibir dados públicos");
        System.out.println("2 - Consultar coordenadas protegidas");
        System.out.println("3 - Alterar coordenadas protegidas");
        System.out.println("4 - Alterar combustível");
        System.out.println("5 - Alterar trajetória");
        System.out.println("6 - Alterar número de tripulantes");
        System.out.println("7 - Alterar código de acesso");

        int opcao = lerInteiro("Escolha uma opção: ");

        switch (opcao) {
            case 1:
                System.out.println(dadosMissao.exibirDadosPublicos());
                break;

            case 2:
                System.out.print("Digite o código de acesso: ");
                String codigoConsulta = scanner.nextLine();
                System.out.println("Coordenadas: " + dadosMissao.getCoordenadas(codigoConsulta));
                break;

            case 3:
                System.out.print("Digite o código de acesso: ");
                String codigoAlteracao = scanner.nextLine();

                System.out.print("Digite as novas coordenadas: ");
                String novasCoordenadas = scanner.nextLine();

                if (dadosMissao.setCoordenadas(novasCoordenadas, codigoAlteracao)) {
                    System.out.println("Coordenadas alteradas com sucesso.");
                } else {
                    System.out.println("Não foi possível alterar as coordenadas.");
                }
                break;

            case 4:
                double novoCombustivel = lerDouble("Informe o combustível em %: ");
                dadosMissao.setCombustivel(novoCombustivel);
                System.out.println(dadosMissao.verificarAlertaCombustivel());
                break;

            case 5:
                System.out.print("Informe a nova trajetória: ");
                String novaTrajetoria = scanner.nextLine();
                dadosMissao.setTrajetoria(novaTrajetoria);
                System.out.println("Trajetória atualizada.");
                break;

            case 6:
                int tripulantes = lerInteiro("Informe o número de tripulantes: ");
                dadosMissao.setNumeroTripulantes(tripulantes);
                System.out.println("Número de tripulantes atualizado.");
                break;

            case 7:
                System.out.print("Digite o código atual: ");
                String codigoAtual = scanner.nextLine();

                System.out.print("Digite o novo código com pelo menos 4 caracteres: ");
                String novoCodigo = scanner.nextLine();

                if (dadosMissao.alterarCodigoAcesso(codigoAtual, novoCodigo)) {
                    System.out.println("Código alterado com sucesso.");
                } else {
                    System.out.println("Não foi possível alterar o código.");
                }
                break;

            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void simularAlertas(SensorTemperatura sensorTemperatura,
                                       SensorPressao sensorPressao,
                                       SensorRadiacao sensorRadiacao,
                                       DadosMissao dadosMissao) {
        System.out.println("\n--- SIMULAÇÃO DE ALERTAS ---");

        sensorTemperatura.ligar();
        sensorPressao.ligar();
        sensorRadiacao.ligar();

        sensorTemperatura.definirValorManual(98);
        sensorPressao.definirValorManual(135);
        sensorRadiacao.definirValorManual(85);
        dadosMissao.setCombustivel(15);

        System.out.println("Temperatura simulada: 98 °C -> " + sensorTemperatura.verificarStatus());
        System.out.println("Pressão simulada: 135 kPa -> " + sensorPressao.verificarStatus());
        System.out.println("Radiação simulada: 85 mSv -> " + sensorRadiacao.verificarStatus());
        System.out.println("Combustível simulado: 15% -> " + dadosMissao.verificarAlertaCombustivel());
    }

    private static void exibirStatusCompleto(Sensor[] sensores,
                                             SistemaPropulsao[] propulsoes,
                                             DadosMissao dadosMissao) {
        System.out.println("\n--- STATUS COMPLETO DO SISTEMA ---");

        System.out.println("\nSensores:");
        for (Sensor sensor : sensores) {
            ComponenteEspacial componente = (ComponenteEspacial) sensor;
            System.out.println(componente.exibirInformacoesBasicas());
        }

        System.out.println("\nPropulsão:");
        for (SistemaPropulsao propulsao : propulsoes) {
            System.out.println(propulsao.exibirStatus());
        }

        System.out.println("\nDados da Missão:");
        System.out.println(dadosMissao.exibirDadosPublicos());
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException erro) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
            }
        }
    }

    private static double lerDouble(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Double.parseDouble(scanner.nextLine().replace(",", "."));
            } catch (NumberFormatException erro) {
                System.out.println("Entrada inválida. Digite um número válido.");
            }
        }
    }
}