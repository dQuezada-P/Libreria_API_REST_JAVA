export function deleteBook(e){
    let element = e.target
    if (element.nodeName == 'I') element = element.parentElement
    
    const idLibro = element.getAttribute('id')
    const request = new XMLHttpRequest();
    
    

    request.open('DELETE',`http://localhost:8080/Libreria/webresources/book/${idLibro}`);
    request.send();
    request.onload = () => {
        const rs = JSON.parse(request.responseText);
        if (request.status == "200") {
            console.log(request.status)
            const tr = element.parentElement.parentElement
            tr.parentElement.removeChild(tr)
            console.table(rs)
        } else {
            console.error(rs)
        }
        
    }
    
}