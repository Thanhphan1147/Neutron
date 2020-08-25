package vn.tphan.jhipster.neutron.errors;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;
import vn.tphan.jhipster.core.Constants;

import java.net.URI;

public class IllegalMoveException extends AbstractThrowableProblem {
    public IllegalMoveException() {
        super(URI.create(Constants.PROBLEM_BASE_URL+"/illegal-move"), "Illegal move", Status.BAD_REQUEST);
    }
}
