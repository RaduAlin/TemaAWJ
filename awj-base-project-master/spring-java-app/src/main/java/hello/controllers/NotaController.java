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
public class NotaController {
  private List<Nota> note = new ArrayList<Nota>();

  NotaController() {
    Nota p1 = new Nota(1, "10");
    Nota p2 = new Nota(2, "5");
    Nota p3 = new Nota(3, "1");

    note.add(p1);
    note.add(p2);
    note.add(p3);
  }

  @RequestMapping(value="/nota", method = RequestMethod.GET)
  public List<Nota> index() {
    return this.note;
  }

  @RequestMapping(value="/nota/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Nota p : this.note) {
      if(p.getId() == id) {
        return new ResponseEntity<Nota>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/nota/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Nota p : this.note) {
      if(p.getId() == id) {
        this.note.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}
