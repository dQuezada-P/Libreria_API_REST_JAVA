import {deleteBook,getBookById} from './apiCrud.js'

const tableDivElement = document.getElementById('table')
const jsonDivElement = document.getElementById('json')

const tableElement = tableDivElement.querySelector('tbody')
const jsonElement = jsonDivElement.querySelector('.json')

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
    cleanSearch()
    getBookById(inputIdElement.value, request => revealResult(request))
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


function cleanSearch() {
    jsonElement.textContent = null
    jsonDivElement.setAttribute('hidden','True')
    tableDivElement.setAttribute('hidden','True')
    tableElement.innerHTML = ''
}

function revealResult(request){
    cleanSearch()
    jsonElement.textContent = request.responseText

    const libro = JSON.parse(request.response)

    const row = document.createElement('tr')
    
    for (let prop in libro) {
        const column = document.createElement('td')
        column.textContent = libro[prop]
        row.appendChild(column)
    }

    const column = document.createElement('td')

    const buttonEditElement = document.createElement('a')
    buttonEditElement.classList = 'btn btn-outline-primary'
    buttonEditElement.setAttribute('href',`libros?action=editar&id_libro=${libro.id}`)

    const editIconElement = document.createElement('i')
    editIconElement.classList = 'fas fa-pencil-alt fa-1x btn-icon'

    buttonEditElement.appendChild(editIconElement)
    column.appendChild(buttonEditElement)

    const buttonTrashElement = document.createElement('button')
    buttonTrashElement.classList = 'btn btn-outline-danger ml-2'
    buttonTrashElement.type = 'submit'
    buttonTrashElement.setAttribute('id',libro.id)
    buttonTrashElement.addEventListener('click', e => {
        deleteBook(e)
        cleanSearch()
    })

    const trashIconElement = document.createElement('i')
    trashIconElement.classList = 'far fa-trash-alt fa-1x '

    buttonTrashElement.appendChild(trashIconElement)
    
    column.appendChild(buttonTrashElement)

    row.appendChild(column)

    tableElement.appendChild(row)

    tableDivElement.removeAttribute('hidden')
    jsonDivElement.removeAttribute('hidden')
}