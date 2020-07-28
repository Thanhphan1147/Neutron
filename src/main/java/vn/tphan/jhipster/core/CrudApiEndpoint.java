package vn.tphan.jhipster.core;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * Created by quocvi3t on 11/14/17.
 */
public abstract class CrudApiEndpoint<T extends AbstractEntity, ID extends Serializable> {

    private static Logger logger = LoggerFactory.getLogger(CrudApiEndpoint.class);

    protected CrudService<T, ID> service;

    protected String baseUrl;

    public CrudApiEndpoint(CrudService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<T>> list() {
        List<T> list = service.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
