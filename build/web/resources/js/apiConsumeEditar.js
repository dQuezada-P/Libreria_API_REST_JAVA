import {updateBook} from './apiCrud.js'

const buttonEditarElement = document.getElementById('editar')
buttonEditarElement.addEventListener('click', e =>{
    const libro = getLibro()
    updateBook(libro)
})

function getLibro(){
    const inputElements = document.getElementsByTagName('input')
    let libro = '{'
    let count = 0
    for(let input in inputElements){
        libro += `"${inputElements[input].id}": ${ !isNaN(parseInt(inputElements[input].value ))? inputElements[input].value : `"${inputElements[input].value}"`}`
        count++
        if (count==8) break
        else libro+=','
    }
    libro += '}'
    console.log(JSON.parse(libro))
    return libro
}

