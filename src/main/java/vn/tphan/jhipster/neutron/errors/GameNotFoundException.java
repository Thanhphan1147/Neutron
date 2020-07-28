package vn.tphan.jhipster.neutron.errors;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;
import vn.tphan.jhipster.core.Constants;

import java.net.URI;

public class GameNotFoundException extends AbstractThrowableProblem {
    public GameNotFoundException() {
        super(URI.create(Constants.PROBLEM_BASE_URL+"/game-not-found"), "Game does not exists", Status.NOT_FOUND);
    }
}
