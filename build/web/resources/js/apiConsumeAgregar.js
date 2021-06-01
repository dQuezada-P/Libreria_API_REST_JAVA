import { addBook } from './apiCrud.js'
import { showAlert } from './alerts.js'

const buttonAgregarElement = document.getElementById('agregar')
const alertElement = document.querySelector('.alert')

buttonAgregarElement.addEventListener('click', e => {

    alertElement.setAttribute('hidden', 'true')

    const libro = getLibro()
    console.log(alertElement)

    addBook(libro, request =>{
        showAlert(request.status,'añadido',alertElement)
        
    })
})

function getLibro(){
    const inputElements = document.getElementsByTagName('input')
    
    let libro = '{'
    let count = 0
    for(let input in inputElements){
        libro += `"${inputElements[input].id}": ${ !isNaN(parseInt(inputElements[input].value ))? inputElements[input].value : `"${inputElements[input].value}"`}`
        count++
        if (count==7) break
        else libro+=','
    }
    libro += '}'
    console.log(JSON.parse(libro))
    return libro
}

