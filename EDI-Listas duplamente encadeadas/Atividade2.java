import java.util.Random;

public class Atividade2 {
    public static void main(String[] args) {

        Random numerosGerados = new Random();
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        
        for(int i=0; i<51000000; i++){
            int numeroSorteado = numerosGerados.nextInt(1, 61); //cartela da mega sena vai de 01 a 60.
            lista.Adiciona(numeroSorteado);
        }

        int[] numerosSorteados = {1, 15, 16, 25, 32, 36};
        boolean encontradaOrdemDireta = false;
        boolean encontradaOrdemInversa = false;
        int qntdSequenciaDireta = 0;
        int qntdSequenciaInversa = 0;


        Celula atual = lista.getPrimeira();
        int posicao = 0;
        while(atual != null){
            if(atual.getElemento().equals(numerosSorteados[0])){
                Celula proxima = atual.getProxima();
                int contador = 1;
                boolean sequenciaEncontrada = true;

                for(int i=1; i<numerosSorteados.length; i++ ){
                    if(proxima == null || !proxima.getElemento().equals(numerosSorteados[i])){
                        sequenciaEncontrada = false;
                        break;
                    }
                    proxima = proxima.getProxima();
                    contador++;
                }
                if(sequenciaEncontrada){
                    encontradaOrdemDireta = true;
                    System.out.println("Sequência encontrada em ordem direta na posição: " + posicao);
                    qntdSequenciaDireta++;
                    posicao += contador;
                }
            }
                atual = atual.getProxima();
                posicao++;
        }

        lista.inverterLista();

        atual = lista.getPrimeira();
        posicao = 0;
        while(atual != null){
            if(atual.getElemento().equals(numerosSorteados[0])){
                Celula proxima = atual.getProxima();
                int contador = 1;
                boolean sequenciaEncontrada = true;

                for(int i=1; i<numerosSorteados.length; i++){
                    if(proxima == null || !proxima.getElemento().equals(numerosSorteados[i])){
                        sequenciaEncontrada = false;
                        break;
                    }
                    proxima = proxima.getProxima();
                    contador++;
                }
                if(sequenciaEncontrada){
                    encontradaOrdemInversa = true;
                    System.out.println("Sequência encontrada em ordem inversa na posição: " + posicao);
                    qntdSequenciaInversa++;
                    posicao += contador;
                    }
            }
                    atual = atual.getProxima();
                    posicao++;
        }


        System.out.println("Quantidade de vezes que a sequência foi encontrada em ordem direta: " + qntdSequenciaDireta);
        System.out.println("Quantidade de vezes que a sequência foi encontrada em ordem inversa: " + qntdSequenciaInversa);
    }
}
        


  


