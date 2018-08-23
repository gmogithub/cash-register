// import Axios from 'axios';

const BASE_URL = 'http://localhost:8000/';

// export const Http = Axios.create({
//     baseURL: `${BASE_URL}/`,
//     withCredentials: false,
//     credentials: 'same-origin'
// });

const HTTP_METHOD_GET = 'GET';
const HTTP_METHOD_POST = 'POST';
const HTTP_METHOD_PUT = 'PUT';
const HTTP_METHOD_DELETE = 'DELETE';

export const Http = {
    send(api, method = HTTP_METHOD_GET, body = null) {
        let headers = new Headers({
            'Accept': 'application/json',
            'Content-Type': 'application/json;charset=UTF-8'
        });

        let init = {
            method: method,
            headers: headers
        };

        if (body != null) {
            if (body instanceof Object)
                init.body = JSON.stringify(body);
            else
                init.body = body;
        }

        let url = `${BASE_URL}${api}`;
        // console.log(url);
        // let request = new Request(url, init);


        // console.log(res);
        return fetch(url, init).then(res => res.json())
    },

    get(api, body) {
        return this.send(api, HTTP_METHOD_GET, body);
    },

    post(api, body) {
        return this.send(api, HTTP_METHOD_POST, body);
    },

    put(api, body) {
        return this.send(api, HTTP_METHOD_PUT, body);
    },

    delete(api, body) {
        return this.send(api, HTTP_METHOD_DELETE, body);
    }
};

