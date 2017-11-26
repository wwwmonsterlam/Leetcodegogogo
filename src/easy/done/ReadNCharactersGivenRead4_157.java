package easy.done;

public class ReadNCharactersGivenRead4_157 {
    
//    这道题题目已经够难理解的。
//    read4(buf)的功能其实是读一个文件4个字符，将读出来的这四个字符写入char数组buf中。若读取的文件字符数少于四个，则按实际读出来的字符写入buf.
//    注意buf不是读取的对象，而是存放已经读数据的地方，读取的对象不知道，题目内部定义好。
//    这题的难点在于判断读取的结束。

    /* The read4 API is defined in the parent class Reader4.
    int read4(char[] buf); */
  /**
   * @param buf Destination buffer
   * @param n   Maximum number of characters to read
   * @return    The number of characters read
   */
  public int read(char[] buf, int n) {
      if(n <= 0) {
          return 0;
      }
      
      char[] tmp = new char[4];
      int total = 0;
      int count = 0;
      
      while(true) {
          count = read4(tmp);
          for(int i = 0; i < Math.min(count, n); i++) {
              buf[total++] = tmp[i];
          }
          
          if(count < 4)  break;
          
          n = n - 4;
          if(n <= 0) break;
      }
      
      return total;
  }
}
