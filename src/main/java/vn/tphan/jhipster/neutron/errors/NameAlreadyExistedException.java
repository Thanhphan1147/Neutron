package vn.tphan.jhipster.neutron.errors;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;
import vn.tphan.jhipster.core.Constants;

import java.net.URI;

public class NameAlreadyExistedException extends AbstractThrowableProblem {
    public NameAlreadyExistedException() {
        super(URI.create(Constants.PROBLEM_BASE_URL+"/name-already-used"), "Game already existed", Status.BAD_REQUEST);
    }
}
