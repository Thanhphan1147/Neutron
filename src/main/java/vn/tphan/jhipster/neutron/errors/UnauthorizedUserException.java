package vn.tphan.jhipster.neutron.errors;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;
import vn.tphan.jhipster.core.Constants;

import java.net.URI;

public class UnauthorizedUserException extends AbstractThrowableProblem {
    public UnauthorizedUserException() {
        super(URI.create(Constants.PROBLEM_BASE_URL+"/unauthorized"), "You don't have permission to update", Status.UNAUTHORIZED);
    }
}
