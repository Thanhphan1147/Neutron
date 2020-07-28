package vn.tphan.jhipster.neutron.errors;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;
import vn.tphan.jhipster.core.Constants;

import java.net.URI;

public class GameNotFoundException extends AbstractThrowableProblem {
    public GameNotFoundException(String name) {
        super(URI.create(Constants.PROBLEM_BASE_URL+"/game-not-found"), String.format("Game %s does not exists", name), Status.NOT_FOUND);
    }
}
