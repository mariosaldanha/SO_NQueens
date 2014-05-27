public class NQueens extends Thread{

    boolean[][] queen;
    int numQueen;
    int nThreads;
    int idThread;
    NQueens(int numQueen, int nThreads, int idThread) {
        queen = new boolean[numQueen][numQueen];
        this.numQueen = numQueen;
        this.nThreads = nThreads;
        this.idThread = idThread;
    }
 
    void executa() {
        for (int i = idThread; i < numQueen; i += nThreads) { 
            Tab tabuleiro = new Tab(numQueen, i, idThread);
            //System.out.println("Thread : " + idThread + " Novo tab, pos: " + i);
            tabuleiro.insereQueen(1);
        }
    }

    public void run(){
        executa();
    }

    public static void main(String[] args) {
        int nQueens = 0;
        
        if(args.length == 1){
            nQueens = Integer.parseInt(args[0]);
        }
        else{
            System.out.println("Informe o numero de rainhas");
            System.exit(0);
        }
        
        int nThreads = Runtime.getRuntime().availableProcessors();
        //System.out.println("Numero de processadores: " + nThreads);
        
        if(nThreads > nQueens){
            nThreads = nQueens;
        }

        NQueens[] threads = new NQueens[nThreads];

        for(int i = 0; i < nThreads; i++){
            threads[i] = new NQueens(nQueens, nThreads, i);
        }

        for(int i = 0; i < nThreads; i++){
            threads[i].start();
        }

        for(int i = 0; i < nThreads; i++){
            try{
                threads[i].join();
            } catch(InterruptedException e){
                System.out.println("Error: InterruptedException");       
            }
        }

    }
}
