import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Local[] locais = new Local[2];
        locais[0] = new Local("Auditório IFCE", 120);
        locais[1] = new Local("LAB INFOR 1", 24);

        while (true) {
            System.out.println("Menu Sistema GE:");
            System.out.println("1. Cadastrar Eventos");
            System.out.println("2. Associar Participantes a Eventos");
            System.out.println("3. Listar Eventos por Local");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 4) {
                break;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Evento: ");
                    String nomeEvento = scanner.nextLine();
                    System.out.print("Data do Evento: ");
                    String dataEvento = scanner.nextLine();
                    System.out.println("Escolha o local do Evento:");
                    for (int i = 0; i < locais.length; i++) {
                        System.out.println(i + ". " + locais[i].nome);
                    }
                    int indiceLocal = scanner.nextInt();
                    scanner.nextLine();
                    Local localEscolhido = locais[indiceLocal];
                    Evento novoEvento = new Evento(nomeEvento, dataEvento, localEscolhido, 10);
                    localEscolhido.adicionarEvento(novoEvento);
                    System.out.println("Evento cadastrado com sucesso, Obrigado!");
                    break;
                case 2:
                    System.out.print("Nome do participante: ");
                    String nomeParticipante = scanner.nextLine();
                    System.out.print("Email do participante: ");
                    String emailParticipante = scanner.nextLine();
                    Participante novoParticipante = new Participante(nomeParticipante, emailParticipante);

                    System.out.println("Escolha o local do evento:");
                    for (int i = 0; i < locais.length; i++) {
                        System.out.println(i + ". " + locais[i].nome);
                    }
                    indiceLocal = scanner.nextInt();
                    scanner.nextLine();
                    localEscolhido = locais[indiceLocal];

                    System.out.println("Escolha o evento:");
                    for (int i = 0; i < localEscolhido.numeroEventos; i++) {
                        System.out.println(i + ". " + localEscolhido.eventos[i].nome);
                    }
                    int indiceEvento = scanner.nextInt();
                    scanner.nextLine();
                    Evento eventoEscolhido = localEscolhido.eventos[indiceEvento];
                    eventoEscolhido.adicionarParticipante(novoParticipante);
                    System.out.println("Participante associado com sucesso!");
                    break;
                case 3:
                    System.out.println("Escolha o local:");
                    for (int i = 0; i < locais.length; i++) {
                        System.out.println(i + ". " + locais[i].nome);
                    }
                    indiceLocal = scanner.nextInt();
                    scanner.nextLine();
                    localEscolhido = locais[indiceLocal];
                    listarEventosPorLocal(localEscolhido);
                    break;
                default:
                    System.out.println("Opção Errada!");
            }
        }
    }

    public static void listarEventosPorLocal(Local local) {
        System.out.println("Eventos no " + local.nome + ":");
        for (int i = 0; i < local.numeroEventos; i++) {
            Evento evento = local.eventos[i];
            System.out.println("Evento: " + evento.nome + ", Data: " + evento.data);
            System.out.println("Participantes:");
            for (int j = 0; j < evento.numeroParticipantes; j++) {
                System.out.println(evento.participantes[j]);
            }
        }
    }
}
