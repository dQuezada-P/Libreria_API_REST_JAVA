import {deleteBook} from './apiCrud.js'

const inputIdElement = document.getElementById('id')

const buttonSearchElement = document.getElementById('buscar')
buttonSearchElement.addEventListener('click', e => {
    const validate = validateId()
    if (!validate.status){
        alertElement.removeAttribute('hidden')
        alertContent.textContent = validate.message
        return
    }
    alertElement.setAttribute('hidden','True')
    searchBook()
})

const alertElement = document.querySelector('.alert')
const alertContent = alertElement.querySelector('.alert-content')

function validateId(){
    const value = inputIdElement.value
    if (isNaN(parseInt(value))) {
        return {status:false, 'message':'Ingrese un valor numérico en el campo Id'}
    } 
    return {'status':true, 'message':null}
}

function searchBook(){
    const id = inputIdElement.value
    const request = new XMLHttpRequest();

    request.open('GET',`http://localhost:8080/Libreria/webresources/book/${id}`);
    request.send();
    request.onload = () => {
        if (request.status == 200){
            revealResult(request)
        }
    }
}

function revealResult(request){
    const tableDivElement = document.getElementById('table')
    const jsonDivElement = document.getElementById('json')

    const tableElement = tableDivElement.querySelector('.table')
    const jsonElement = jsonDivElement.querySelector('.json')

    jsonElement.textContent = request.responseText

    const libro = JSON.parse(request.response)

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
        deleteBook(e)
    })

    const trashIconElement = document.createElement('i')
    trashIconElement.classList = 'far fa-trash-alt fa-1x'

    buttonTrashElement.appendChild(trashIconElement)

    const column = document.createElement('td')
    column.appendChild(buttonTrashElement)

    row.appendChild(column)

    tableElement.appendChild(row)

    tableDivElement.removeAttribute('hidden')
    jsonDivElement.removeAttribute('hidden')

    console.log(libro)
}