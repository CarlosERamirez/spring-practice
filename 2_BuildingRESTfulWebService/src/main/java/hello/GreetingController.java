package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//This annotation marks the next class as a controller,
//where every method returns a domain object intead of a view
@RestController
public class GreetingController {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();
  
  //RequestMapping ensures that HTTP requests to /greeting
  //are mapped to the greeting() method
  //RequestMapping is not specific to the GET request, it could
  //be then (in this case) replaced by GetMapping
  @RequestMapping("/greeting")
  //RequestParam binds the value of the query string parameter 'name'
  //into the 'name' parameter of the greeting() method
  public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    return new Greeting(counter.incrementAndGet(),
              String.format(template, name));
  }
}
