const jsonElement = document.querySelector('.json');
const tableElement = document.querySelector('.table');

const libros = []

const request = new XMLHttpRequest();


request.open('GET','http://localhost:8080/Libreria/webresources/book/all');
request.send();
request.onload = () => {
    if (request.status == 200){
        const res = JSON.parse(request.response)
        res.forEach(libro => {
            const row = document.createElement('tr')
            for (let prop in libro) {
                const column = document.createElement('td')
                column.textContent = libro[prop]
                row.appendChild(column)
            }
            tableElement.appendChild(row)
        })
        
        jsonElement.textContent = request.responseText
       
    }
}







