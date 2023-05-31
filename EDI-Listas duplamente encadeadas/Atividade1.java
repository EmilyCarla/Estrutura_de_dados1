import java.util.Random;

public class Atividade1{
        public static void main(String[] args) {
            ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
            Random numerosAleatorios = new Random();
            int vetor[] = new int[1000];
            
            for(int i=0; i<1000; i++){
                vetor[i] = numerosAleatorios.nextInt(-9999, 9999);
                System.out.println("Vetor: " + vetor[i]);
            }

            for(int i=0; i<1000; i++){
                int elemento = vetor[i];
                int indexCrescente = 0;
                while(indexCrescente<lista.tamanho() && (int) lista.Pega(indexCrescente) < elemento ){
                    indexCrescente++;
                }
                lista.Adiciona(indexCrescente, elemento);
            }

            System.out.println("\n\nLista crescente: " + lista.imprimir());
            lista.inverterLista();
            System.out.println("\n\nLista decrescente: " + lista.imprimir());
            removerPrimos(lista);
            System.out.println("\n\nLista sem os números primos: " + lista.imprimir());
    }

    private static void removerPrimos(ListaDuplamenteEncadeada lista){
        int pos = 0;
        while(pos<lista.tamanho()){
            int valor = (int) lista.Pega(pos);
            if(numPrimo(valor)){
                lista.Remove(pos);
            }else{
                pos++;
            }
        }
    }

    private static boolean numPrimo(int numero){
        if(numero <= 1){
            return false;
        }
        for(int i=2; i<=Math.sqrt(numero); i++){
            if(numero%i==0){
                return false;
            }
        }
        return true;
    }

}
    

    
