modules.exports = function bodyParser(request, response, next) {
    if(request.method != "POST") {
        next()
    }
    else {
        // Array.push() more performant than String append (immutable => copy)
        let body = []
        request
        .on('data', (chunk) => body.push(chunk))
        .on('end', () => {
            request.body = Buffer.contact(body).toString()
            next()
        })
    }
}
