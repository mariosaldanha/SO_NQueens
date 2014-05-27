import java.io.*;
public class PrintTab{

	static void imprimi(int numQueen, boolean queen[][]){
		
		try{
			File arq = new File(numQueen + "queens.txt");
			if(!arq.exists())
				arq.createNewFile();
			
			FileWriter fw = new FileWriter(arq, true);
			BufferedWriter bw = new BufferedWriter(fw);
				 	
	        for (int i = 0; i < numQueen; i++) {
	            for (int j = 0; j < numQueen; j++) {
	                if (queen[i][j]) {
	               //     System.out.print("R");
	                    bw.write("R");	
	                } 
	                else {
	                 //   System.out.print("X");
	                    bw.write("X");	
	                }
	                if (j < numQueen - 1) {
	                   // System.out.print(" ");
	                    bw.write(" ");	
	                } 
	                else {
	                   // System.out.println();
	                    bw.write("\n");	
	                }  
	            }
	        }
	        //System.out.println();
	        bw.write("\n");

	        bw.close();
			fw.close();	
		}catch(Exception e){
			System.out.println("Error: Arquivo de saida\n" + e);
		}
    }
}