package company;
import com.blade.mvc.annotation.*;
import com.blade.mvc.http.Response;


@Path
public class IndexRouter {
    @GetRoute("/")
    public void index(Response res){
        res.header("X-Powered-By", "httpd");
        res.json("{\"a\": \"b\"}");
    }

    @GetRoute("/save")
    public void get_save(Response res){
        res.header("X-Powered-By", "httpd");
        res.json("{\"get get\": \"i'm save\"}");
    }

    @PostRoute("/save")
    public void post_save(Response res){
        res.header("X-Powered-By", "httpd");
        res.json("{\"post post\": \"i'm post\"}");
    }

    @GetRoute("/hello")
    public void get_hello(Response res){
        res.header("X-Powered-By", "httpd");
        res.json("{\"get get \": \"get hello\"}");
    }

    @PostRoute("/hello")
    public void post_hello(Response res){
        res.header("X-Powered-By", "httpd");
        res.json("{\"post post\": \"post hello\"}");
    }
}
