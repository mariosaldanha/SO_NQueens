public class Tab {
    boolean [][] queen;
    int numQueen;
    int idThread;
    Tab(int numQueen, int inicial, int idThread){
        queen = new boolean[numQueen][numQueen];
        this.numQueen = numQueen;
        queen[0][inicial] = true;
        this.idThread = idThread;
    }

    // Verifica se as rainhas nao se atacam
    boolean posValida(int linha, int coluna) {
        for (int i = 0; i < linha; i++) {
            if (queen[i][coluna]) { // Verfica a coluna
                return false;
            }
            for (int j = 0; j < numQueen; j++) {
                if (queen[i][j]) {
                    if (Math.abs((i - linha)) == Math.abs((j - coluna))) { // Verifica diagonais
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }

    void insereQueen(int linha) {
        if (linha == numQueen) {    // Terminou
            synchronized(PrintTab.class){
                //System.out.println("Thread: " + idThread);
                PrintTab.imprimi(numQueen, queen);
            }
        } 

        else if (linha < numQueen) {
                for (int coluna = 0; coluna < numQueen; coluna++) { // percorre as colunas da linha atual
                    if (posValida(linha, coluna)) {     // Se posicao valida
                        queen[linha][coluna] = true;    // Insere a rainha
                        insereQueen(linha + 1);         // Passa pra proxima linha (rainha)
                        queen[linha][coluna] = false;   // Não gera uma solução, marca como invalida
                    }
                }
        }
    }
}