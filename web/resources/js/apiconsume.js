const pathName = window.location

const jsonElement = document.querySelector('.json');
const tableElement = document.querySelector('.table');

window.onload = () => {
    const request = new XMLHttpRequest();

    request.open('GET','http://localhost:8080/Libreria/webresources/book/all');
    request.send();
    request.onload = () => {
        if (request.status == 200){
            llenarLista(request)
        }
    }
}

function llenarLista(request){
    const res = JSON.parse(request.response)
    res.forEach(libro => {
        const row = document.createElement('tr')
        for (let prop in libro) {
            const column = document.createElement('td')
            column.textContent = libro[prop]
            row.appendChild(column)
        }
        

        const buttonTrashElement = document.createElement('button')
        buttonTrashElement.classList = 'btn btn-outline-danger'
        buttonTrashElement.type = 'submit'
        buttonTrashElement.setAttribute('id',libro.id)
        buttonTrashElement.addEventListener('click', e => {
            eliminarLibro(e)
        })

        const trashIconElement = document.createElement('i')
        trashIconElement.classList = 'far fa-trash-alt fa-1x'

        buttonTrashElement.appendChild(trashIconElement)

        const column = document.createElement('td')
        column.appendChild(buttonTrashElement)

        row.appendChild(column)

        tableElement.appendChild(row)
    })
    
    jsonElement.textContent = request.responseText
}

function eliminarLibro(e){
    const idLibro = e.target.getAttribute('id')
    const request = new XMLHttpRequest();

    request.open('DELETE',`http://localhost:8080/Libreria/webresources/book/${idLibro}`);
    request.send();
    request.onload = () => {
        var rs = JSON.parse(request.responseText);
        if (request.readyState == 4 && request.status == "200") {
            console.table(rs);
        } else {
            console.error(rs);
        }
    }

}







