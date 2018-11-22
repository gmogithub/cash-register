const BASE_URL = 'http://localhost:8000/';

export class HttpService {

    static METHOD_GET = 'GET';
    static METHOD_POST = 'POST';
    static METHOD_PUT = 'PUT';
    static METHOD_DELETE = 'DELETE';
    static HEADERS_JSON = new Headers({
        'Accept': 'application/json',
        'Content-Type': 'application/json;charset=UTF-8'
    });

    constructor (middlewares, headers = HttpService.HEADERS_JSON) {
        this.middlewares = middlewares;
        this.headers = headers;
    }

    checkStatus (response) {
        let json = response.json();
        return json;
    }

    send (api, method = HttpService.METHOD_GET, body = null) {
        let init = {
            method: method,
            headers: this.headers
        };

        if (body != null) {
            if (body instanceof Object)
                init.body = JSON.stringify(body);
            else
                init.body = body;
        }

        let url = `${BASE_URL}${api}`;
        return fetch(url, init)
            .then(this.checkStatus)
            .catch(async (error) => {
                for (const middleware of this.middlewares) {
                    try {
                        await middleware(error, api, method, body);
                    } catch (e) {
                        console.error(e);
                    }


                }
            })
    }

    get (api, body) {
        return this.send(api, HttpService.METHOD_GET, body);
    }

    post (api, body) {
        return this.send(api, HttpService.METHOD_POST, body);
    }

    put (api, body) {
        return this.send(api, HttpService.METHOD_PUT, body);
    }

    delete (api, body) {
        return this.send(api, HttpService.METHOD_DELETE, body);
    }
}