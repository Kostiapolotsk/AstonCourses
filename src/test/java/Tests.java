import com.sun.source.tree.AssertTree;
import groovy.transform.ASTTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.apache.commons.lang3.BooleanUtils.and;
import static org.hamcrest.Matchers.*;

public class Tests {

    @Test
    public void checkGet() {
        given().baseUri("https://postman-echo.com/get")
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when().get().then().log().body().statusCode(200)
                .and().body("args.foo1", equalTo("bar1"))
                .and().body("args.foo2", equalTo("bar2"))
                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.x-forwarded-port", equalTo("443"))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.x-amzn-trace-id", notNullValue())
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11)"))
                .and().body("headers.accept-encoding", equalTo("gzip,deflate"))
                .and().body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    public void checkPostText() {
        given().baseUri("https://postman-echo.com")
                .header("Content-Type", "application/json")
                .when().post("/post").then().log().body().statusCode(200)
                .and().body("args.get(0)", equalTo(null))
                .and().body("data.get(0)", equalTo(null))
                .and().body("files.get(0)", equalTo(null))
                .and().body("form.get(0)", equalTo(null))
                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.x-forwarded-port", equalTo("443"))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.x-amzn-trace-id", notNullValue())
                .and().body("headers.content-length", equalTo("0"))
                .and().body("headers.content-type", equalTo("application/json"))
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/19)"))
                .and().body("headers.accept-encoding", equalTo("gzip,deflate"))
                .and().body("json", equalTo(null))
                .and().body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void checkPostData() {
        given().baseUri("https://postman-echo.com")
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when().post("/post").then().log().body().statusCode(200)
                .and().body("args.get(0)", equalTo(null))
                .and().body("data", equalTo(""))
                .and().body("files.get(0)", equalTo(null))
                .and().body("form.foo1", equalTo("bar1"))
                .and().body("form.foo2", equalTo("bar2"))
                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.x-forwarded-port", equalTo("443"))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.x-amzn-trace-id", notNullValue())
                .and().body("headers.content-length", equalTo("19"))
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.content-type", equalTo("application/x-www-form-urlencoded; charset=utf-8"))
                .and().body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/19)"))
                .and().body("headers.accept-encoding", equalTo("gzip,deflate"))
                .and().body("json.foo1", equalTo("bar1"))
                .and().body("json.foo2", equalTo("bar2"))
                .and().body("url", equalTo("https://postman-echo.com/post"));

    }

    @Test
    public void checkPut() {
        given().baseUri("https://postman-echo.com/put")
                .header("Content-Type", "application/json")
                .when().put().then().log().body().statusCode(200)
                .and().body("args.get(0)", equalTo(null))
                .and().body("data.get(0)", equalTo(null))
                .and().body("files.get(0)", equalTo(null))
                .and().body("form.get(0)", equalTo(null))
                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.x-forwarded-port", equalTo("443"))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.x-amzn-trace-id", notNullValue())
                .and().body("headers.content-length", equalTo("0"))
                .and().body("headers.content-type", equalTo("application/json"))
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/19)"))
                .and().body("headers.accept-encoding", equalTo("gzip,deflate"))
                .and().body("json", equalTo(null))
                .and().body("url", equalTo("https://postman-echo.com/put"));
    }

    @Test
    public void checkPatch() {
        given().baseUri("https://postman-echo.com/patch")
                .header("Content-Type", "application/json")
                .when().patch().then().log().body().statusCode(200)
                .and().body("args.get(0)", equalTo(null))
                .and().body("data.get(0)", equalTo(null))
                .and().body("files.get(0)", equalTo(null))
                .and().body("form.get(0)", equalTo(null))
                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.x-forwarded-port", equalTo("443"))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.x-amzn-trace-id", notNullValue())
                .and().body("headers.content-length", equalTo("0"))
                .and().body("headers.content-type", equalTo("application/json"))
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/19)"))
                .and().body("headers.accept-encoding", equalTo("gzip,deflate"))
                .and().body("json", equalTo(null))
                .and().body("url", equalTo("https://postman-echo.com/patch"));
    }

    @Test
    public void checkDelete() {
        given().baseUri("https://postman-echo.com/delete")
                .header("Content-Type", "application/json")
                .when().delete().then().log().body().statusCode(200)
                .and().body("args.get(0)", equalTo(null))
                .and().body("data.get(0)", equalTo(null))
                .and().body("files.get(0)", equalTo(null))
                .and().body("form.get(0)", equalTo(null))
                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.x-forwarded-port", equalTo("443"))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.x-amzn-trace-id", notNullValue())
                .and().body("headers.content-type", equalTo("application/json"))
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/19)"))
                .and().body("headers.accept-encoding", equalTo("gzip,deflate"))
                .and().body("json", equalTo(null))
                .and().body("url", equalTo("https://postman-echo.com/delete"));
    }
}
