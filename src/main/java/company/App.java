package company;
import com.blade.Blade;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
	Blade.of().get("/", ctx -> ctx.text("Hello Blade")).start();
    }
}
