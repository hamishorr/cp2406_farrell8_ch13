// Program reads in a file of phone numbers without area codes
// inserts "(312) " in front of each phone number
// and produces an output file with the new complete phone numbers
import com.sun.corba.se.spi.orbutil.fsm.Input;

import java.nio.file.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
import static java.nio.file.StandardOpenOption.*;
public class DebugThirteen2
{
   public static void main(String[] args)
   {
      FileSystem fs = FileSystems.getDefault();
      Path fileIn =
         fs.getPath("C:\\Java\\Chapter.13\\DebugData3.txt");
      Path fileOut =
         fs.getPath("C:\\Java\\Chapter.13\\DebugData3New.txt");
      String areaCode = "(312) ";
      String phone = null;
      InputStream input = null;


      try
      {
         input = Files.newInputStream(fileIn);
         BufferedReader reader = new BufferedReader(new InputStreamReader((input)));

         phone = reader.readLine();
         while (phone != null)
         {
            phone = areaCode + phone + System.getProperty("line.separator");
            byte[] data = phone.getBytes();
            OutputStream output = null;
            output = Files.newOutputStream(fileOut);
            output.write(data);
            output.flush();
            output.close();

            phone = reader.readLine();
         }
         input.close();
       }
       catch (Exception e)
       {
          System.out.println("Message: " + e);
       }
   }
}

