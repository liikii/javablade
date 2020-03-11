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
}
