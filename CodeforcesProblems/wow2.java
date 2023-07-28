
/* package codechef; // don't place package name! */
 
import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
  
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
  
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
  
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }
  
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
  
            if (neg)
                return -ret;
            return ret;
        }
  
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
  
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
  
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
  
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
  
            if (neg)
                return -ret;
            return ret;
        }
  
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                                 BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
  
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
  
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int t = Integer.parseInt(st.nextToken());
	    while(t-- > 0)
	    {
	        st = new StringTokenizer(br.readLine());
	        int n = Integer.parseInt(st.nextToken());
	        int m = Integer.parseInt(st.nextToken());
	        String s = br.readLine();
	        
	        int extra = 0;
	        int pre[] = new int[n];
	        int back[] = new int[n];
	        int front[] = new int[n];
	        
	        TreeMap<Integer,Integer> pos = new TreeMap<Integer,Integer>();
	        
	        for(int i = 0 ; i < n ; i++)
	        {
	            if(i+1 < n && s.charAt(i) == '1' && s.charAt(i+1) == '0')
	            pos.put(i,1);
	            
	            
	            if(i > 0)
	            pre[i] = pre[i-1];
	            
	            if(s.charAt(i) == '1')
	            pre[i]++;
	            
	            if(i != 0)
	            {
	                if(s.charAt(i) != s.charAt(i-1))
	                back[i] = i;
	                
	                else 
	                back[i] = back[i-1];
	            }
	        }
	        
	        for(int i = n-1 ; i >= 0 ; i--)
	        {
	            if(i == n-1)
	            front[i] = n-1;
	            
	            else 
	            {
	                if(s.charAt(i) != s.charAt(i+1))
	                front[i] = i;
	                
	                else 
	                front[i] = front[i+1];
	            }
	        }
	        
	        
	        TreeMap<pair,Integer> map = new TreeMap<pair,Integer>(new Compare());
	        for(int i = 0 ; i < m ; i++)
	        {
	            st = new StringTokenizer(br.readLine());
	            int l = Integer.parseInt(st.nextToken());
	            int r = Integer.parseInt(st.nextToken());
	            
	            l--;
	            r--;
	            
	           boolean bl = false;
	           if(pos.higherKey(l-1) != null && pos.higherKey(l-1) < r)
	           bl = true;
	            
	            if(!bl)
	            extra = 1;
	            
	            else 
	            {
	                if(l-1 >= 0 && s.charAt(l-1) == '0')
	                l = back[l-1];
	                
	                if(r+1 < n && s.charAt(r+1) == '1')
	                r = front[r+1];
	                
	                map.put(new pair(l,r),1);
	                
	               // System.out.println((l+1) + " " + (r+1) + " " + i);
	                
	            }
	        }
	        
	        
	        System.out.println(map.size()+extra);
	    }
	}
}
 
class pair 
{
    int x , y;
    public pair(int x , int y)
    {
        this.x = x;
        this.y = y;
    }
}
 
class Compare implements Comparator<pair>
{
    public int compare(pair a , pair b)
    {
        if(a.x != b.x)
        return a.x-b.x;
        
        return a.y-b.y;
    }
}
