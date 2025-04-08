
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GeradorID {

    private static final Random gerarIdTurma = new Random();
    private static final Set<Integer> idsGeradosT = new HashSet<>(); // 'Set<   > HashSet<>()', não permite duplicação de elementos, nesse caso, os id

    public static int gerarIDTurma() {
        int id;
        do {
            id = gerarIdTurma.nextInt(10000, 1000000); //gera e adiciona a variavel 'id'
        } while (idsGeradosT.contains(id));// 'Contains' verifica antes de sair do laço 'if true' retorna, 'false' atribui a idsGerados e retorna o 'id'
        idsGeradosT.add(id);               // usa com 'HashSet, ArrayList e HashMap'...
        return id;
    }

    private static final Random gerarIdAluno = new Random();
    private static final Set<Integer> idsGeradosA = new HashSet<>(); // 'Set<   > HashSet<>()', não permite duplicação de elementos, nesse caso, os id

    public static int gerarIdAluno() {
        int id;
        do {
            id = gerarIdTurma.nextInt(10000, 1000000); //gera e adiciona a variavel 'id'
        } while (idsGeradosA.contains(id));// 'Contains' verifica antes de sair do laço 'if true' retorna, 'false' atribui a idsGerados e retorna o 'id'
        idsGeradosA.add(id);               // usa com 'HashSet, ArrayList e HashMap'...
        return id;
    }

    public static int matricula() {
        int acont = 0;
        acont++;
        return acont;
    }

    /*public static int acont(){
         int acont = 0;
         acont ++;
         return acont;
     }*/
}
