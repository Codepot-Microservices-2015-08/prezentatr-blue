package pl.codepot.prezentatr.present

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc
import pl.codepot.prezentatr.feed.FeedController
import spock.lang.Specification

class BaseMvcSpec extends Specification {

    def setup() {
        setupMocks()
        RestAssuredMockMvc.standaloneSetup(new PresentController(), new FeedController())
    }

    void setupMocks() {
    }



}