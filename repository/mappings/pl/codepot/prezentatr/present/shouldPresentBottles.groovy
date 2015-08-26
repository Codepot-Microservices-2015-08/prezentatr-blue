io.codearte.accurest.dsl.GroovyDsl.make {
    request {
        method 'GET'
        url $(client(regex('^/present/bottles$')), server('/present/bottles'))
    }
    response {
        status 200
        body (
                $(client(regex('[0-9]+')), server('0'))
        )
    }
}