import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.io.IOException;

	public class Main{
		public static void main(String args[]) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String input= br.readLine();
			String answer="";
      
        while(input!=null) {
       
        	int numberBooks = Integer.parseInt(input); 
          String line = br.readLine();
			    String [] stringSplit = line.split(" ");
			    int[] books = new int[numberBooks];
			    for(int i=0;i<numberBooks;i++) {
  				  books[i]=Integer.parseInt(stringSplit[i]);
			    }
			    
			    int money = Integer.parseInt(br.readLine());
			    Arrays.sort(books);
			    ArrayList<Integer> diferences = new ArrayList<Integer>();
			    
			    for(int i=0;i<numberBooks;i++) {
			    	int answerBinary = binarySearch(books,money-books[i]);
			    	if(answerBinary != -1&&answerBinary-i!=0) {
			    		diferences.add(Math.abs(books[answerBinary]-books[i]));
			    	}
			    }
			    
			  Collections.sort(diferences);
			
			  int price = (money-diferences.get(0))/2;
			  int firstPrice = Math.abs(money-price);
			  
			      if(firstPrice<price) {
				      answer+=("Peter has to buy the books whose prices are "+firstPrice+" and "+price+".\n");
			      }
			      else {
				    answer+=("Peter has to buy the books whose prices are "+price+" and "+firstPrice+".\n");
			     }
			      br.readLine();
			      input=br.readLine();
		  }
        
			bw.write(answer);
			br.close();
			bw.close();
      }
			
		public static int binarySearch(int[] books,int Search) {
			int down = -1;
			int i = 0;
			int j = books.length-1;
			while(i<=j && down<0) {
				int m = (i+j)/2;
				if(books[m]==Search) {
					down=m;
				}
				else if(books[m]>Search){
					j=m-1;
				}
				else {
					i=m+1;
				}
			}
			return down;
		}
	}	