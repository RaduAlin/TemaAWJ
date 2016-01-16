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
public class FructController {
  private List<Fruct> fructe = new ArrayList<Fruct>();

  FructController() {
    Fruct p1 = new Fruct(1, "Mar");
    Fruct p2 = new Fruct(2, "Para");
    Fruct p3 = new Fruct(3, "Pepene");

    fructe.add(p1);
    fructe.add(p2);
    fructe.add(p3);
  }

  @RequestMapping(value="/fruct", method = RequestMethod.GET)
  public List<Fruct> index() {
    return this.fructe;
  }

  @RequestMapping(value="/fruct/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Fruct p : this.fructe) {
      if(p.getId() == id) {
        return new ResponseEntity<Fruct>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/fruct/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Fruct p : this.fructe) {
      if(p.getId() == id) {
        this.fructe.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}
