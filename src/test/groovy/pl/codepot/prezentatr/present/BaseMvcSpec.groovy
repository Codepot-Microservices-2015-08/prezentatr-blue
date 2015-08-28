package pl.codepot.prezentatr.present

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc
import pl.codepot.prezentatr.feed.FeedController
import pl.codepot.prezentatr.state.State
import spock.lang.Specification

class BaseMvcSpec extends Specification {

    def setup() {
        setupMocks()
        State state = new State()
        RestAssuredMockMvc.standaloneSetup(new PresentController(), new FeedController(state))
    }

    void setupMocks() {
    }



}