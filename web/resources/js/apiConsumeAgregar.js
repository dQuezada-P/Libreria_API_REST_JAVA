import { addBook } from './apiCrud.js'

const buttonAgregarElement = document.getElementById('agregar')
const alertElement = document.querySelector('.alert')


buttonAgregarElement.addEventListener('click', e => {

    alertElement.setAttribute('hidden', 'true')

    const inputElements = e.target.parentElement.getElementsByClassName('form-control')

    const libroString =
        `{"isbn":${inputElements['isbn'].value},
    "titulo":${inputElements['titulo'].value},
    "editorial":${inputElements['editorial'].value},
    "anno":${inputElements['anno'].value},
    "autor1":${inputElements['autor1'].value},
    "autor2":${inputElements['autor2'].value},
    "precio":${inputElements['precio'].value}                   
    }`

    console.log(libroString)

    addBook(e, libroString, alertElement)
})


