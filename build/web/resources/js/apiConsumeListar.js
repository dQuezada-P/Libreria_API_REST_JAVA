import {deleteBook} from './apiCrud.js'

const pathName = window.location

const jsonElement = document.querySelector('.json');
const tableElement = document.querySelector('tbody');

window.onload = e => requestJson(e)

// function getAll(){
//     const request = new XMLHttpRequest();

//     request.open('GET','http://localhost:8080/Libreria/webresources/book/all');
//     request.send();
//     request.onload = () => {
//         if (request.status == 200){
//             fillTable(request)
//         }
//     }
// }

function requestJson(e) {
    const request = new XMLHttpRequest();

    request.open('GET','http://localhost:8080/Libreria/webresources/book/all');
    request.send();
    request.onload = () => {
        if (request.status == 200){
            if(e.type == 'load'){
                fillTable(request) 
                return
            }
            fillJson(request)
        }
    }
}

function fillTable(request){
    const res = JSON.parse(request.response)
    res.forEach(libro => {
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
            requestJson(e) 
        })

        const trashIconElement = document.createElement('i')
        trashIconElement.classList = 'far fa-trash-alt fa-1x btn-icon'

        buttonTrashElement.appendChild(trashIconElement)      
        column.appendChild(buttonTrashElement)

        row.appendChild(column)

        tableElement.appendChild(row)
    })
    
    fillJson(request)
}

function fillJson(request) {
    jsonElement.textContent = request.responseText
}













