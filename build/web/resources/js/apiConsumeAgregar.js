import { addBook } from './apiCrud.js'

const buttonAgregarElement = document.getElementById('agregar')
const alertElement = document.querySelector('.alert')


buttonAgregarElement.addEventListener('click', e => {

    alertElement.setAttribute('hidden', 'true')

    const inputElements = e.target.parentElement.getElementsByClassName('form-control')

    const libroString =
        `{"isbn":${inputElements['isbn'].value ? `"${inputElements['isbn'].value}"` : null},
    "titulo":${inputElements['titulo'].value ? `"${inputElements['titulo'].value}"` : null},
    "editorial":${inputElements['editorial'].value ? `"${inputElements['editorial'].value}"` : null},
    "anno":${inputElements['anno'].value ? `"${inputElements['anno'].value}"` : null},
    "autor1":${inputElements['autor1'].value ? `"${inputElements['autor1'].value}"` : null},
    "autor2":${inputElements['autor2'].value ? `"${inputElements['autor2'].value}"` : null},
    "precio":${inputElements['precio'].value ? inputElements['precio'].value : null}                   
    }`
    
    console.log(JSON.parse(libroString))

    addBook(e, libroString, alertElement)
})


