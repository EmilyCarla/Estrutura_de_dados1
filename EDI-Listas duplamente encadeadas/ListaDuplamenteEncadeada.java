public class ListaDuplamenteEncadeada {
    Celula Primeira;
    Celula Ultima;
    int TotalDeElementos = 0;


    //metodo para verificar se a lista está ocupada
    boolean PosicaoOcupada(int pos){
        return((pos >= 0) && (pos < this.TotalDeElementos));
    }

    //recuperar a celula numa determinada posição
    Celula PegaCelula(int pos){
        if(!this.PosicaoOcupada(pos)){
            throw new IllegalArgumentException("Posição não existe");
        }else{
            Celula atual = this.Primeira;
            for(int i=0; i<pos; i++){
                atual = atual.getProxima();
            }
            return(atual);
        }
    }

    //recuperar um objeto(informação) numa determinada posição
    Object Pega(int pos){
        return(this.PegaCelula(pos).getElemento());
    }

    //Adicionar objetos(informações) no começo da lista
    void AdicionaNoComeco(Object elemento){
        if(this.TotalDeElementos==0){
            Celula nova = new Celula(elemento);
            this.Primeira = nova;
            this.Ultima = nova;
        }else{
            Celula nova = new Celula(this.Primeira, elemento);
            this.Primeira.setAnterior(nova);
            this.Primeira = nova;
        }
        this.TotalDeElementos++;
    }

    //Adicionar objetos(informações) na lista
    void Adiciona(Object elemento){
        if(this.TotalDeElementos == 0){
            this.AdicionaNoComeco(elemento);
        }else{
            Celula nova = new Celula(elemento);
            this.Ultima.setProxima(nova);
            nova.setAnterior(this.Ultima);
            this.Ultima = nova;
            this.TotalDeElementos++;
        }
    }

    //Adicionar objetos(informações) na lista numa determinada posição
    void Adiciona(int pos, Object elemento){
        if(pos == 0){
            this.AdicionaNoComeco(elemento);
        }else if(pos == this.TotalDeElementos){
            this.Adiciona(elemento);
        }else{
            Celula anterior = this.PegaCelula(pos-1);
            Celula proxima = anterior.getProxima();
            Celula nova = new Celula(anterior.getProxima(), elemento);
            nova.setAnterior(anterior);
            anterior.setProxima(nova);
            proxima.setAnterior(nova);
            this.TotalDeElementos++;
        }
    }

    //Remove celulas no começo da lista
    void RemoveComeco(){
        if(!this.PosicaoOcupada(0)){
            throw new IllegalArgumentException("Posição não existe");
        }else{
            this.Primeira = this.Primeira.getProxima();
            this.TotalDeElementos--;
        }
        if(this.TotalDeElementos == 0){
            this.Ultima = null;
        }
    }


    //Remove celulas no final da lista
    void RemoveFim(){
        if(!this.PosicaoOcupada(TotalDeElementos-1)){
            throw new IllegalArgumentException("Posição não existe");
        }else{
            if(this.TotalDeElementos == 1){
                this.RemoveComeco();
            }else{
                Celula penultima = this.Ultima.getAnterior();
                penultima.setProxima(null);
                this.Ultima = penultima;
                this.TotalDeElementos--;
            }
        }
    }


    //Remove celulas em uma determinada posição na lista
    void Remove(int pos){
        if(!PosicaoOcupada(pos)){
            throw new IllegalArgumentException("Posição não existe");
        }else{
            if(pos == 0){
                this.RemoveComeco();
            }else if(pos == this.TotalDeElementos-1){
                this.RemoveFim();
            }else{
                Celula anterior = this.PegaCelula(pos-1);
                Celula atual = anterior.getProxima();
                Celula proxima = atual.getProxima();
                anterior.setProxima(proxima);
                proxima.setAnterior(anterior);
                this.TotalDeElementos--;
            }
        }
    }


    //Verifica se um determinado Objeto(informação) está na lista
    boolean Contem(Object elemento){
        Celula atual = this.Primeira;
        while(atual != null){
            if(atual.getElemento().equals(elemento)){
                return true;
            }
            atual = atual.getProxima();
        }
        return(false);
    }


    //Verifica o tamanho da lista(quantidade de elementos)
    int tamanho(){
        return(this.TotalDeElementos);
    }


    //Esvazia a lista
    void EsvaziaLista(){
        this.Primeira = null;
        this.Ultima = null;
        this.TotalDeElementos = 0;
    }


    public void inverterLista() {
        if (this.TotalDeElementos <= 1) {
            return; // Lista vazia ou com apenas um elemento, não é necessário reverter
        }
    
        Celula atual = this.Primeira;
        Celula anterior = null;
    
        while (atual != null) {
            Celula proxima = atual.getProxima();
            atual.setProxima(anterior);
            atual.setAnterior(proxima);
            anterior = atual;
            atual = proxima;
        }
    
        Celula temp = this.Primeira;
        this.Primeira = this.Ultima;
        this.Ultima = temp;
    }


    //Imprime a lista (se os objetos forem do tipo String)
    String imprimir(){
        if(this.TotalDeElementos == 0){
            return("[]");
        }else{
            StringBuilder builder = new StringBuilder("[");
            Celula atual = this.Primeira;
            for(int i=0; i<this.TotalDeElementos-1; i++){
                builder.append(atual.getElemento());
                builder.append(",");
                atual = atual.getProxima();
            }
            builder.append(atual.getElemento());
            builder.append("]");
            return(builder.toString());
            }
        }

    public Celula getPrimeira() {
        return Primeira;
    }

    public Celula getUltima() {
        return Ultima;
    }

    public int getTotalDeElementos() {
        return TotalDeElementos;
    }
    }

