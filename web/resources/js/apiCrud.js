export function deleteBook(e, callback) {
    let element = e.target
    if (element.nodeName == 'I') element = element.parentElement

    const idLibro = element.getAttribute('id')
    const request = new XMLHttpRequest();



    request.open('DELETE', `http://localhost:8080/Libreria/webresources/book/${idLibro}`);
    request.send();
    request.onload = () => {
        const rs = JSON.parse(request.responseText);
        if (request.status == "200") {
            console.log(request.status)
            const tr = element.parentElement.parentElement
            tr.parentElement.removeChild(tr)
            if(callback) callback()
            console.table(rs)
        } else {
            console.error(rs)
        }
    }
}

export function addBook(json, alertElement) {

    const request = new XMLHttpRequest();
    const alertContent = alertElement.querySelector('.alert-content')

    request.open('POST', `http://localhost:8080/Libreria/webresources/book`);
    request.setRequestHeader('content-Type', 'application/json');
    request.send(json)
    request.onload = () => {
        if (request.status == "200") {
            if (alertElement.className == 'alert alert-danger') {
                alertElement.classList.remove('alert-danger')
                alertElement.classList.add('alert-success')
            }
            alertContent.textContent = 'Se ha agregado el libro con exito!'
        } else {
            if (alertElement.className == 'alert alert-success') {
                alertElement.classList.remove('alert-success')
                alertElement.classList.add('alert-danger')
            }
            alertContent.textContent = 'No se ha podido agregar el libro'
        }

        alertElement.removeAttribute('hidden')
    }
}

export function updateBook(libro){
    const request = new XMLHttpRequest();

    request.open('PUT','http://localhost:8080/Libreria/webresources/book')
    request.setRequestHeader('content-Type', 'application/json');
    request.send(libro)
    request.onload = () => {
        if (request.status == "200") console.log(request.status) 
        else console.log(request.status)
    }
}

export function getBookById(id, callback){
    const request = new XMLHttpRequest();
    request.open('GET',`http://localhost:8080/Libreria/webresources/book/${id}`);
    request.send();
    request.onload = () => {
        if (request.status == 200){
            console.log(request.status)
            if(callback) callback(request)
        }
    }
}


export function getBooks(callback) {
    const request = new XMLHttpRequest();

    request.open('GET','http://localhost:8080/Libreria/webresources/book/all');
    request.send();
    request.onload = () => {
        if (request.status == 200){
            console.log(request.status)
            if(callback) callback(request)
        }
    }
}