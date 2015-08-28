package pl.codepot.prezentatr.present

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc
import org.springframework.http.HttpEntity
import pl.codepot.prezentatr.feed.FeedController
import pl.codepot.prezentatr.services.PresentService
import pl.codepot.prezentatr.state.State
import spock.lang.Specification

class BaseMvcSpec extends Specification {

    def setup() {
        setupMocks()
        State state = new State()
        RestAssuredMockMvc.standaloneSetup(new PresentController(new PresentService(state){
            @Override
            String order(HttpEntity<String> body) {
                return "'ingredients': [\n" +
                        "                        {'type': 'MALT', 'quantity': 200},\n" +
                        "                        {'type': 'WATER', 'quantity': 200},\n" +
                        "                        {'type': 'HOP', 'quantity': 200},\n" +
                        "                        {'type': 'YIEST', 'quantity': 200}\n" +
                        "                ]"
            }

            @Override
            String dojrzewatr() {
                return super.dojrzewatr()
            }

            @Override
            String butelkatr() {
                return super.butelkatr()
            }

            @Override
            String bottles() {
                return super.bottles()
            }
        }), new FeedController
            (state))
    }

    void setupMocks() {
    }



}