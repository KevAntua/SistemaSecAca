const form = document.getElementById("form_UM");
const inputs = document.querySelectorAll('#form_UM input,textarea,select');
const nombres = /^[a-zA-ZÀ-ÿ\s]{1,40}$/; // Letras y espacios, pueden llevar acentos.

window.onload = function () {
    var fecha = new Date(); //Fecha actual
    var mes = fecha.getMonth() + 1; //obteniendo mes
    var dia = fecha.getDate(); //obteniendo dia
    var ano = fecha.getFullYear(); //obteniendo año
    if (dia < 10)
        dia = '0' + dia; //agrega cero si el menor de 10
    if (mes < 10)
        mes = '0' + mes //agrega cero si el menor de 10
    document.getElementById('input_date_REA').value = ano + "-" + mes + "-" + dia;
}

const validateForm = (e) => {
    let valor;
    console.log(e.target.id);
    let ide = document.getElementById(e.target.id);
    let ide2 = document.getElementById(ide.parentNode.id);
    switch (e.target.name) {
        case "id":
            valor = e.target.value;

            (valor.length > 0 && valor > 0) ? validado(ide, ide2) : NoValid(ide, ide2);
            break;
        case "Desc":
            valor = e.target.value;
            (valor.length > 1) ? validado(ide, ide2) : NoValid(ide, ide2);
            break;
        case "combo":
            valor = document.getElementById(e.target.id).selectedIndex;
            (valor > 0) ? validado(ide, ide2) : NoValid(ide, ide2);
            break;
        case "nombre":
            valor = e.target.value;
            (nombres.test(valor)) ? validado(ide, ide2) : NoValid(ide, ide2);
            break;
        case "apellidos":
            valor = e.target.value;
            (nombres.test(valor)) ? validado(ide, ide2) : NoValid(ide, ide2);
            break;
    }

}

const validado = (ide, ide2) => {
    document.getElementById(ide2.parentNode.id).classList.remove('form_group--incorrecto');
    document.getElementById(ide2.parentNode.id).classList.add('form_group--correcto');
    document.querySelector(`#${ide2.parentNode.id} i`).classList.remove('fa-circle-xmark');
    document.querySelector(`#${ide2.parentNode.id} i`).classList.add('fa-circle-check');
    document.querySelector(`#${ide2.parentNode.id} p`).classList.remove('form_input_error-activo');
    document.querySelector(`#${ide2.parentNode.id} p`).classList.add('form_input_error');
}
const NoValid = (ide, ide2) => {
    document.getElementById(ide2.parentNode.id).classList.remove('form_group--correcto');
    document.getElementById(ide2.parentNode.id).classList.add('form_group--incorrecto');
    document.querySelector(`#${ide2.parentNode.id} i`).classList.remove('fa-circle-check');
    document.querySelector(`#${ide2.parentNode.id} i`).classList.add('fa-circle-xmark');
    document.querySelector(`#${ide2.parentNode.id} p`).classList.remove('form_input_error');
    document.querySelector(`#${ide2.parentNode.id} p`).classList.add('form_input_error-activo');
}

inputs.forEach((input) => {
    input.addEventListener('keyup', validateForm);
    input.addEventListener('blur', validateForm);
});

var candado = function () {
    for (i = 0; i < inputs.length; i++) {
        var input = inputs[i];
        switch (input.name) {
            case 'id':
                if (!(input.value.length > 0)) {
                    return false;
                }

                break;
            case 'Desc':
                if (!(input.value.length > 1)) {
                    return false;
                }
                break;
            case 'combo':
                if (!input.selectedIndex > 0) {
                    return false;
                }
                break;
            default:

                break;
        }

    }
    return true;
}

form.addEventListener('submit', (e) => {
    e.preventDefault();
    //console.log(inputs);


    if (candado()) {
        ShowMessage();
    }
    else {

        HideMessage();
    }

});

const ShowMessage = () => {
    let mensaje;
    mensaje = document.getElementById('Parrafo_M').classList.add('form_message_succes--activo');
    mensaje = document.getElementById('form_message').classList.remove('form_message--activo');
}
const HideMessage = () => {
    mensaje = document.getElementById('Parrafo_M').classList.remove('form_message_succes--activo');
    mensaje = document.getElementById('form_message').classList.add('form_message--activo');
}

//let dia = hoy.getDate();