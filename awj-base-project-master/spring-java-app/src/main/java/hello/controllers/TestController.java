package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class TestController {
  private List<Test> teste = new ArrayList<Test>();

  TestController() {
    Test p1 = new Test(1, "Merge");
    Test p2 = new Test(2, "Nu Merge");
    Test p3 = new Test(3, "Poate");

    teste.add(p1);
    teste.add(p2);
    teste.add(p3);
  }

  @RequestMapping(value="/test", method = RequestMethod.GET)
  public List<Test> index() {
    return this.teste;
  }

  @RequestMapping(value="/test/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Test p : this.teste) {
      if(p.getId() == id) {
        return new ResponseEntity<Test>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/test/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Test p : this.teste) {
      if(p.getId() == id) {
        this.teste.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}
