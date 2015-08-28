package pl.codepot.prezentatr.state

import org.springframework.stereotype.Component

@Component
class State {

    Set<String> brewing
    Set<String> bottling
    int bottles

    public State() {
        this.brewing = new HashSet<>()
        this.bottling = new HashSet<>()
        this.bottles = 0
    }

}
