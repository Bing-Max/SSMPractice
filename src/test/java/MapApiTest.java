import org.junit.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MapApiTest {

    @Test
    public void test(){
        try {
            // 获取数据
            URL url = new URL("https://zaixianke.com/yq/all");
            URLConnection con = url.openConnection();
            InputStream is = con.getInputStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            // 把爬过来的数据显示出来
            System.out.println(bf.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
