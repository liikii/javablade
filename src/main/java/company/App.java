package company;
import com.blade.Blade;


public class App 
{
    public static void main( String[] args ) {
    //        System.out.println("Hello Wuhan!");
//        String a = "{\"errorCode\": \"\", \"data\": {\"message\": \"Chairman Mao Longevity\", \"request_info\": \"Chairman Mao Longevity\"}, \"success\": true, \"errorMessage\": \"\"}";
//        Blade.of().get("/hello_java", ctx -> ctx.json(a)).start();
        Blade.of().listen(9002).start(App.class, args);
    }
}
