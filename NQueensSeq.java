import java.io.*;
public class NQueensSeq{

    boolean[][] queen;
    int numQueen;
    File arq;
    //static int n = 0;
    NQueensSeq(int numQueen, File arq) {
        queen = new boolean[numQueen][numQueen];
        this.numQueen = numQueen;
        this.arq = arq;
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
      //      n++;
            imprimi();
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

    void imprimi(){
        
        try{
          
            FileWriter fw = new FileWriter(arq, true);
            BufferedWriter bw = new BufferedWriter(fw);                    
            for (int i = 0; i < numQueen; i++) {
                for (int j = 0; j < numQueen; j++) {
                    if (queen[i][j]) {
                        //System.out.print("R");
                        bw.write("R");  
                    } 
                    else {
                        //System.out.print("X");
                        bw.write("X");  
                    }
                    if (j < numQueen - 1) {
                        //System.out.print(" ");
                        bw.write(" ");  
                    } 
                    else {
                        //System.out.println();
                        bw.write("\n"); 
                    }  
                }
            }
            //System.out.println();
            bw.write("\n");

            bw.close();
            fw.close(); 
        }catch(Exception e){
            System.out.println("Error: Escrita no arquivo de saida\n" + e);
        }
    }


    public static void main(String[] args) {
        int nQueens = 0;
        
        if(args.length == 1){
            nQueens = Integer.parseInt(args[0]);
        }
        else{
            System.exit(0);
        }

        File arq = new File(nQueens + "queensSeq.txt");
        try{
            if(!arq.exists())
                arq.createNewFile();
        }catch(Exception e){
            System.out.println("Error: Criar arquivo de saida\n" + e);
        }

        NQueensSeq obj = new NQueensSeq(nQueens, arq);
        obj.insereQueen(0);

    }
}