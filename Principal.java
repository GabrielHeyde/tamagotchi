//Gabriel Heyde Pintos
import java.util.Random;
public class Principal{
    //classe void main para execução do programa
    public static void main(String[] args){
        //exibição de um menu para inicializar o programa
        System.out.println("----------------------------------------------------------------------------------------------------------------\nBem vindo(a), ao seu Tamagotchi! Aqui você poderá cuidar e brincar com seu amiguinho virtual.\nEle possui necessidades básicas, como comer, dormir e se entreter, e você deverá auxiliá-lo nestas atividades.\nMas como qualquer criatura, você deve se atentar para algumas condições:\n1. Seu Tamagotchi vive por até 15 dias;\n2. Seu Tamagotchi não deve pesar menos de 1kg;\n3. Seu Tamagotchi não deve pesar mais de 20kg;\n4. Caso seu Tamagotchi fique cinco vezes consecutivas sem dormir, o mesmo dorme automaticamente.\n----------------------------------------------------------------------------------------------------------------\n");
    
        //exibição de uma mensagem para o usuário definir o nome de seu Tamagotchi
        String nomeDoTamagotchi = Teclado.leString("Para começar, digite um nome para seu Tamagotchi: ");
    
        //atualização do nome do Tamagotchi durante a execução do programa
        String nome = nomeDoTamagotchi;
        Tamagotchi play = new Tamagotchi(nome);
    
        //primeira mensagem que será exibida, onde aparecerão condições da vida do Tamagotchi.
        System.out.println("----------------------------------------------------------------------------------------------------------------\nDIA 0\n\n" + nome + " | " + "Idade = 0 dias | Peso = 1kg\n\n");
        System.out.println("Vamos ver como será o dia de seu Tamagotchi!\n\n");
        while(play.getIdade()<15){
            //comando de repetição que executará o programa enquanto a idade do Tamagotchi for inferior à 15 dias.
            if(play.getPeso()>20){
                //condicional que verifica se o peso do Tamagotchi ultrapassou os 20kg, em caso afirmativo, imprime uma mensagem informando que o mesmo explodiu e quebra o laço de repetição.
                System.out.println("Seu amiguinho acabou comendo muito durante a vida e ultrapassou os 20kg. " + nome + " veio a explodir.\n\n");
                break;
            }
    
            if(play.getPeso()<1){
                //condicional que verifica se o peso do Tamagotchi está menor que 1kg, em caso afirmativo, imprime uma mensagem informando que o mesmo morreu de desnutrição e quebra o laço de repetição.
                System.out.println("Seu amiguinho acabou ficando com muita fome e atingiu um peso menor que 1kg. " + nome + " veio a falecer de desnutrição.\n\n");
                break;
            }
    
            if(play.getSemDormir()>4){
                //condicional que verifica se o usuário selecionou 5 vezes seguidas para o Tamagotchi se manter acordado, em caso afirmativo, executa o método dormirNormal automaticamente.
                System.out.println("Seu amiguinho virtual ficou sem dormir por cinco vezes consecutivas, por conta disso, " + nome + " precisou dormir.");
                play.dormirNormal();
            }
    
            //método que funciona como um aleatorizador de números, indo de 1 a 3, que servirá para chamar os métodos comer, dormir e exercitar de forma aleatória durante a execução do programa.
            int numRandom = (int)(Math.random() * 3 ) + 1;
    
            if (numRandom==1){
                //condicional que determina se o número gerado pelo aleatorizador for igual à 1, o método comer será chamado.
                play.comer();
            }
    
            if (numRandom==2){
                //condicional que determina se o número gerado pelo aleatorizador for igual à 2, o método dormir será chamado.
                play.dormir();
            }
    
            if (numRandom==3 && play.getIdade()>0){
                //condicional que determina se o número gerado pelo aleatorizador for igual à 3 e a idade do Tamagotchi for maior que 0, o método exercitar será chamado. Foi posto a obrigatoriedade da idade do Tamagotchi ser maior que 0 para evitar que o mesmo morra antes do primeiro dia completo de vida.
                play.exercitar();
            }
        }
    
        if(play.getIdade()==15){
            //condicional que imprime uma mensagem na tela caso o Tamagotchi atinja 15 dias de vida.
            System.out.println("Seu amigo passou uma longa e divertida vida com você, porém agora é hora de descansar...\n\nApós este tempo, " + nome + " veio a falecer."); 
        }
    
        //mensagem informando ao usuário que o programa foi encerrado, e agradece o mesmo pela utilização do sistema.
        System.out.println("Muito obrigado por utilizar o programa! :D\n\nSinta-se à vontade para encerrar o programa e iniciar novamente, começando assim uma história nova com um novo amiguinho.");
    }   
}