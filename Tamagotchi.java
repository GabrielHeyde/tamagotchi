//Gabriel Heyde Pintos
public class Tamagotchi{
    //variáveis de instância
    private String nome;
    private int idade;
    private int peso;
    private int semDormir;

    //Construtor para objetos da classe Tamagotchi.
    public Tamagotchi(String nome){
        //inicializa variáveis de instância
        this.nome = nome;
        this.idade = 0;
        this.peso = 1;
        this.semDormir = 0;
    }
    
    //método de acesso(set) para a instância nome.
    public void setNome(String nome){
        this.nome = nome;
    }
    
    //método de acesso(set) para a instância idade.
    public void setIdade(int idade){
        this.idade = idade;
    }
    
    //método de acesso(set) para a instância peso.
    public void setPeso(int peso){
        this.peso = peso;
    }
    
    //método de acesso(set) para a instância semDormir.
    public void setSemDormir(int semDormir){
        this.semDormir = semDormir;
    }
    
    // método de acesso(get) para a instância nome.
    public String getNome(){
        return nome;
    }
    
    // método de acesso(get) para a instância idade.
    public int getIdade(){
        return idade;
    }
    
    // método de acesso(get) para a instância peso.
    public int getPeso(){
        return peso;
    }
    
    //método de acesso(get) para a instância semDormir.
    public int getSemDormir(){
        return semDormir;
    }
    
    //método criado para facilitar a execução caso o usuário selecione a opção de dormir, onde será acrescido um dia de vida ao Tamagotchi e o contador chamado semDormir é zerado.
    public void dormirNormal(){
        System.out.println("Zzz Boa noite! " + nome + " foi dormir. ");
        idade++;
        semDormir=0;
        System.out.println(nome + " | " + "Idade = " + idade + " dias | Peso = " + peso + "kg.\n\n----------------------------\n\nDIA " + idade + "\n\nVamos ver como será o dia de seu Tamagotchi!\n\n");
    }
    
    //método criado para facilitar a execução caso o usuário selecione a opção de permanecer acordado, onde o contador chamado semDormir é acrescido de um.
    public void naoDormir(){
        System.out.println(nome + " se manteve acordado. ");
        semDormir++;
        System.out.println(nome + " | " + "Idade = " + idade + " dias | Peso = " + peso + "kg.\n\n");
        System.out.println("");        
    }
    
    //método que poderá aparecer na tela dependendo do número que vier do aleatorizador(Classe Principal), no qual será perguntado ao usuário se o mesmo deseja que seu Tamagotchi durma ou permaneça acordado.
    public void dormir(){
        System.out.println(nome + " está com sono, o que você deseja fazer?");
        int opcao = 0;
        while(opcao!=1 || opcao!=2 ){
            //comando de repetição que irá imprimir o menu na tela até o usuário digitar uma das opções presentes no mesmo.    
            System.out.println("----------------------------");
            System.out.println("Digite 1 - Dormir");
            System.out.println("Digite 2 - Permanecer acordado");
            System.out.println("----------------------------");
            System.out.println("");
            opcao = Teclado.leInt("Digite a opção desejada: ");
            System.out.println("");
                if(opcao==1){
                //condicional que executará o método dormirNormal caso o usuário opte por esta opção.
                dormirNormal();
                break;
            }
        
                if (opcao==2){
                //condicional que executará o método naoDormir caso o usuário opte por esta opção.
                naoDormir();
                break;
            }
        }
    }
    
    //método criado para facilitar a execução caso o usuário selecione a opção de comer muito, onde serão acrescidos 5kg ao peso do Tamagotchi.
    public void comerMuito(){
        System.out.println("Quanta comida! " + nome + " comeu muito.");
        peso=peso+5;
        System.out.println(nome + " | " + "Idade = " + idade + " dias | Peso = " + peso + "kg.\n\n");
    }
    
    //método criado para facilitar a execução caso o usuário selecione a opção de comer pouco, onde será acrescido 1kg ao peso do Tamagotchi.
    public void comerPouco(){
        System.out.println("Hora de comer! " + nome + " comeu pouco.");
        peso=peso+1;
        System.out.println(nome + " | " + "Idade = " + idade + " dias | Peso = " + peso + "kg.\n\n");
        System.out.println("");
    }
    
    //método criado para facilitar a execução caso o usuário selecione a opção de não comer, onde será removido 2kg do peso do Tamagotchi.
    public void naoComer(){
        System.out.println("Que fome!" + nome + " não comeu.");
        peso=peso-2;
        System.out.println(nome + " | " + "Idade = " + idade + " dias | Peso = " + peso + "kg.\n\n");
        System.out.println("");
    }
    
    //método que poderá aparecer na tela dependendo do número que vier do aleatorizador(Classe Principal), no qual será perguntado ao usuário se o mesmo deseja que seu Tamagotchi coma muito, coma pouco ou não coma.
    public void comer(){
        System.out.println(nome + " está com fome, o que você deseja fazer?");
        int opcao = 0;
        while(opcao!=1 || opcao!=2 || opcao!=3 ){
            //comando de repetição que irá imprimir o menu na tela até o usuário digitar uma das opções presentes no mesmo.
            System.out.println("----------------------------");    
            System.out.println("Digite 1 - Comer muito");
            System.out.println("Digite 2 - Comer pouco");
            System.out.println("Digite 3 - Não comer");
            System.out.println("----------------------------");
            System.out.println("");
            opcao = Teclado.leInt("Digite a opção desejada: ");
            System.out.println("");
            if(opcao==1){
                //condicional que executará o método comerMuito caso o usuário opte por esta opção.
                comerMuito();
                if(getPeso()<21){
                    //condicional que verifica se o peso do Tamagotchi é menor que 21kg, em caso verdadeiro, o programa executará o método dormirNormal(ação passada pelo enunciado do trabalho).
                    System.out.println("\n\nApós toda esta comida, " + nome + " ficou com sono.");
                    dormirNormal();
                    break;
                }
                break;
            }
        
            if (opcao==2){
                //condicional que executará o método comerPouco caso o usuário opte por esta opção.
                comerPouco();
                break;
            }
        
            if (opcao==3){
                //condicional que executará o método naoComer caso o usuário opte por esta opção.
                naoComer();
                break;
            }
        }
    }
    
    //método criado para facilitar a execução caso o usuário selecione a opção de correr por 10 minutos, onde será removido 4kg do peso do Tamagotchi.
    public void correr(){
        System.out.println("Hora de correr! " + nome + " correu por 10 minutos.");
        peso=peso-4;
        System.out.println(nome + " | " + "Idade = " + idade + " dias | Peso = " + peso + "kg.\n\n");
    }
    
    //método criado para facilitar a execução caso o usuário selecione a opção de caminhar por 10 minutos, onde será removido 1kg do peso do Tamagotchi.
    public void caminhar(){
        System.out.println("Hora de caminhar! " + nome + " caminhou por 10 minutos.");
        peso=peso-1;
        System.out.println(nome + " | " + "Idade = " + idade + " dias | Peso = " + peso + "kg.\n\n");
    }
    
    //método que poderá aparecer na tela dependendo do número que vier do aleatorizador(Classe Principal), no qual será perguntado ao usuário se o mesmo deseja que seu Tamagotchi corra por 10 minutos ou caminhe por 10 minutos.    
    public void exercitar(){
        System.out.println(nome + " está entedidado e deseja se exercitar. O que você deseja fazer?");
        int opcao = 0;
        while(opcao!=1 || opcao!=2 ){
            //comando de repetição que irá imprimir o menu na tela até o usuário digitar uma das opções presentes no mesmo.
            System.out.println("----------------------------");
            System.out.println("Digite 1 - Correr 10 minutos");
            System.out.println("Digite 2 - Caminhar 10 minutos");
            System.out.println("----------------------------");
            System.out.println("");
            opcao = Teclado.leInt("Digite a opção desejada: ");
            System.out.println("");
            if(opcao==1){
                //condicional que executará o método correr caso o usuário opte por esta opção.
                correr();
                if(getPeso()>0){
                    //condicional que verifica se o peso do Tamagotchi é maior que 0kg, em caso verdadeiro, o programa executará o método comerMuito(ação passada pelo enunciado do trabalho).
                    System.out.println("Após esta corrida, " + nome + " ficou com fome.");
                    comerMuito();
                    if(getPeso()<21){
                        //condicional que verifica se o peso do Tamagotchi é menor que 21kg, em caso verdadeiro, o programa executará o método dormirNormal(ação passada pelo enunciado do trabalho).
                        System.out.println("");
                        System.out.println("Após toda esta comida, " + nome + " ficou com sono.");
                        dormirNormal();
                        break;
                    }
                    break;
                }
                break;
            }
        
            if (opcao==2){
                //condicional que executará o método caminhar caso o usuário opte por esta opção.
                caminhar();
                if(getPeso()>0){
                    //condicional que verifica se o peso do Tamagotchi é maior que 0kg, em caso verdadeiro, o programa executará o método comer(ação passada pelo enunciado do trabalho).
                    comer();
                    break;
                }
                break;
            }
        }
    }
}