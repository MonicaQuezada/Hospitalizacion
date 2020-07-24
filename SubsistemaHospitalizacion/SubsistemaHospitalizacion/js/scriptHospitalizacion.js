//API HOSPITALIZACIÓN
const url2 = 'https://hospitalizacion.herokuapp.com/api/hospitalizacion/';
var formulario = document.getElementById('formulario');
var listaElementos = document.getElementById('listaTodos');
var modificar=document.getElementById('modificar');

//LISTAR REGISTROS
function obtenerTodos() {
    fetch(url2)
        .then(response => response.json())
        .then(data => {
            for (let valor of data) {
                listaElementos.innerHTML += `
                <tr>
                    <th>
                        <span class="custom-checkbox">
                            <input type="checkbox" name ="check" id="checkbox1" data-toggle="toggle" data-off="Disabled" value="${valor.idPersona}">
                            <label for="checkbox1"></label>
                        </span>
                    </th>
                    <th scope="row">${valor.idIngreso}</th>
                    <td>${valor.cedulaPaciente}</td>
                    <td>${valor.idCaso}</td>
                    <td>${valor.fechaIngreso}</td>
                    <td>${valor.horaIngreso}</td>
                    <td>14</td>
                    <td>${valor.fechaSalida}</td>
                    <td>${valor.horaSalida}</td>
                    <td>
					    <a href="#editModal"  type="button" name="edit" data-toggle="modal" target="Editar"><i class="material-icons">&#xe254;</i><span>Editar</span></a>
                        <a href="" name="delete" data-toggle="modal" target="Borrar"><i class="material-icons">&#xe872;</i><span>Borrar</span></a>
                    </td>
                </tr>
                `
            }
        })
        .catch(err => console.log(err))
}

//Cuando se presione sobre boton editar/eliminar 
listaElementos.addEventListener('click', (e) => {
    e.preventDefault();
    if(e.target.innerHTML === 'Editar'){
        //posicion en el listar
        var idIngreso = e.path[3].childNodes[3].innerHTML;
        var cedulaPaciente = e.path[3].childNodes[5].innerHTML;
        var idCaso = e.path[3].childNodes[7].innerHTML;
        var fechaIngreso = e.path[3].childNodes[9].innerHTML;
        var horaIngreso = e.path[3].childNodes[11].innerHTML;
        var idCama = e.path[3].childNodes[13].innerHTML;
        var fechaSalida = e.path[3].childNodes[15].innerHTML;
        var horaSalida = e.path[3].childNodes[17].innerHTML;
       
        //Conseguir valores
        document.getElementById('ModHosp').value = idIngreso;
        document.getElementById('ModPaciente').value=cedulaPaciente;
        document.getElementById('ModAtencion').value=idCaso;
        document.getElementById('ModDateI').value=fechaIngreso;
        document.getElementById('ModHoraI').value=horaIngreso;
        document.getElementById('ModCama').value=idCama;
        document.getElementById('ModDateS').value=fechaSalida;
        document.getElementById('ModHoraS').value=horaSalida;
    }
        
    //console.log(e.path[3].childNodes[13].innerHTML.value);
    if (e.target.innerHTML === 'Borrar'){
        var id = e.path[3].childNodes[3].innerHTML
        eliminar(id);
    }
    })

//Editar
modificar.addEventListener('submit', function(e) {
    //console.log("hace click")
    e.preventDefault();
    var datosModificar = new FormData(modificar);
    var ModHosp= datosModificar.get('ModHosp');
    var ModPaciente= datosModificar.get('ModPaciente');
    var ModAtencion= datosModificar.get('ModAtencion');
    var ModDateI= datosModificar.get('ModDateI');
    var ModHoraI= datosModificar.get('ModHoraI');
    var ModCama= datosModificar.get('ModCama');
    var ModDateS= datosModificar.get('ModDateS');
    var ModHoraS= datosModificar.get('ModHoraS');
     
    //console.log(mId + " : " + mCedula + " : " + mNombre + " : "  + mApellido + " : " + mFechaN + " : " + mEdad + " : " + mSexo + " : "  + mDireccion + " : " + mEmail + " : " + mTelefono + " : " + mEstadoCivil + " : " + mFechaI + " : " + mCredencial + " : " +mEspecialidad ); 
    fetch(url2, {
        method: 'PUT',
        mode: 'cors', // no-cors, *cors, same-origin
        cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
        credentials: 'same-origin', // include, *same-origin, omit
        headers: {
            'Content-Type' : 'application/json'
        },
        redirect: 'follow', // manual, *follow, error
        referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url

        body: JSON.stringify({
            "idIngreso": `${e.target.ModHosp.value}`,
            "cedulaPaciente": `${e.target.ModPaciente.value}`,
            "idCaso": `${e.target.ModAtencion.value}`,
            "fechaIngreso": `${e.target.ModDateI.value}`,
            "horaIngreso": `${e.target.ModHoraI.value}`,
            "idCama": `${e.target.ModCama.value}`,
            "fechaSalida": `${e.target.ModDateS.value}`,
            "horaSalida": `${e.target.ModHoraS.value}`,
        })
    })
        .then(res=> res.json())
        .then(data => {
            console.log(data);
            alert("Registro actualizado");
            location.reload();
        })
        .catch(err => console.error(err)) 
})


//Metodo para eliminar una persona con fetch
function eliminar(id) {
    var urlE = `${url2}` + id;
    console.log(urlE);
    fetch(urlE, {
        method: 'DELETE',
        mode: 'cors', // no-cors, *cors, same-origin
        cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
        credentials: 'same-origin', // include, *same-origin, omit
        headers: {
            "Access-Control-Allow-Origin": "*",
            'Content-Type' : 'application/json'
        },
        redirect: 'follow', // manual, *follow, error
        referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
        body: JSON.stringify(id),
    })
    
        .then(res => res.json()) // or res.json()
        .then(res => console.log(res))
        alert("Registro eliminado");
        location.reload();
}

//Metodo para seleccionar todos los registros
function selectAll() {
    var items = document.getElementsByName('check');
    for (var i = 0; i < items.length; i++) {
        if (items[i].type == 'checkbox') {
            if (items[i].checked == false)
                items[i].checked = true;
            else items[i].checked = false;

        } 
    }
}




