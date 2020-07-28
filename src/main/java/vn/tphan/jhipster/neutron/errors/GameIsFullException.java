package vn.tphan.jhipster.neutron.errors;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;
import vn.tphan.jhipster.core.Constants;

import java.net.URI;

public class GameIsFullException extends AbstractThrowableProblem {
    public GameIsFullException(String name) {
        super(URI.create(Constants.PROBLEM_BASE_URL+"/game-is-full"), "Game is full", Status.BAD_REQUEST, String.format("The game (%s) that you are trying to join is full", name));
    }
}
