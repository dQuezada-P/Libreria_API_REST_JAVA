import {updateBook} from './apiCrud.js'



const buttonEditarElement = document.getElementById('editar')
buttonEditarElement.addEventListener('click', e =>{
    const libro = getLibro()
    updateBook(libro)
})

function getLibro(){
    const inputElements = document.getElementsByTagName('input')
    let libro = '{'
    for(let input in inputElements){
        libro += `"${inputElements[input].id}": ${ !isNaN(parseInt(inputElements[input].value ))? inputElements[input].value : `"${inputElements[input].value}"`}`
        libro+=','
    }
    libro = libro.substring(0,libro.length-1)
    libro += '}'
    console.log(libro)
    return libro
}

