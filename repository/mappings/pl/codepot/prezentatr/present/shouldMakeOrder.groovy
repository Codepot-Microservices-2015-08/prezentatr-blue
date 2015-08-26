io.codearte.accurest.dsl.GroovyDsl.make {
    request {
        method 'POST'
        url $(client(regex('^/present/order$')), server('/present/order'))
        body('''
            { "items" : ["MALT","WATER","HOP","YIEST"] }
        ''')
    }
    response {
        status 200
        body (
                ingredients: [
                        [type: 'MALT', quantity: 200],
                        [type: 'WATER', quantity: 200],
                        [type: 'HOP', quantity: 200],
                        [type: 'YIEST', quantity: 200]
                ]
        )
    }
}