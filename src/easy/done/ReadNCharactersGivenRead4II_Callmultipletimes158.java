package easy.done;

public class ReadNCharactersGivenRead4II_Callmultipletimes158 {
    
    //这道题跟157类似，但需要存储上次多读的的字符，所以需要对存储方面做一定的处理
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    
    public int leftoverCount = 0;
    public char[] leftover = new char[3];
    
    public int read(char[] buf, int n) {
        if(n <= 0) return 0;
        
        char[] tmp = new char[4];
        int total = 0;
        boolean eof = false;
        
        for(int i = 0; i < Math.min(leftoverCount, n); i++) {
            buf[total++] = leftover[i];
        }
        
        if(n <= leftoverCount) {
            leftoverCount -= n; 
            for(int i = 0; i < leftoverCount; i++) {
                leftover[i] = leftover[i + n];
            }
            return total;
        } else {
            n -= leftoverCount;
            leftoverCount = 0;
        }
        
        while(n > 0) {
            int len = read4(tmp);
            for(int i = 0; i < Math.min(len, n); i++) {
                buf[total++] = tmp[i];    
            }
            
            if(len >= n) {
                leftoverCount = len - n;
                for(int i = 0; i < leftoverCount; i++) {
                    leftover[i] = tmp[n + i];
                }
                break;
            }
            
            if(len < 4) {
                eof = true;
                break;
            }
            
            n -= 4;
        }
        
        return total;
    }
}
