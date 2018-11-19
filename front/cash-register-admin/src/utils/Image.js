export class Image {
    static createObjectUrl (svg) {
        let DOMURL = self.URL || self.webkitURL || self;
        let data = new XMLSerializer().serializeToString(svg);
        let blob = new Blob([data], {type: "image/svg+xml;charset=utf-8"});
        let url = DOMURL.createObjectURL(blob);
        return url;
    }

    static drawImage (svg) {
        let url = Plano.createObjectUrl(svg);
        let image = new Image();
        image.src = url;
        // image.setAttribute('href', url)
        return new Promise(resolve => {
            image.onload = () => {
                resolve(image);
            };
        });
    }

    static async urlToBase64(url, type = "png") {
        function arrayBufferToBase64(buffer) {
            let binary = "";
            let bytes = [].slice.call(new Uint8Array(buffer));

            bytes.forEach(b => {
                binary += String.fromCharCode(b);
            });

            return window.btoa(binary);
        }

        let res = await fetch(url, {
            method: "GET"
        });

        let buffer = await res.arrayBuffer();
        let base64Flag = `data:image/${type};base64,`;
        let imageStr = arrayBufferToBase64(buffer);
        let base64 = base64Flag + imageStr;
        return base64;
    }
}