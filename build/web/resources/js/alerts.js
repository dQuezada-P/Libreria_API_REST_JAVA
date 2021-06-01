export function showAlert(status, action, alertElement){
    console.log("asfas")
    //console.log(status)
    alertElement.removeAttribute('hidden')
    const alertContent = alertElement.querySelector('.alert-content')
    if (status == '200'){
        if (alertElement.className == 'alert alert-danger') {
            alertElement.classList.remove('alert-danger')
            alertElement.classList.add('alert-success')
        }
        alertContent.textContent = 'Se ha '+action+' el libro con exito!'
    } else {
        if (alertElement.className == 'alert alert-success') {
            alertElement.classList.remove('alert-success')
            alertElement.classList.add('alert-danger')
        }
        alertContent.textContent = 'No se ha '+action+' el libro'
    }
}