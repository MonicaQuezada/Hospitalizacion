//API EMERGENCIAS
const url2 = 'https://hospitalizacion.herokuapp.com/api/emergencia/';
var formulario = document.getElementById('formulario');
var listaElementos = document.getElementById('listaTodos');
var modificar=document.getElementById('modificar');
//LISTAR ELEMENTOS
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
                        </span></th>
                    <th scope="row">${valor.idEmergencia}</th>
                    <td>${valor.cedulaPaciente}</td>
                    <td>${valor.fechaIngreso}</td>
                    <td>${valor.horaIngreso}</td>
                    <td>${valor.causa}</td>
                    <td>${valor.prioridad}</td>
                    <td>
						<a href="#editModal"  type="edit" name="edit" data-toggle="modal" target="Editar"><i class="material-icons">&#xe254;</i><span>Editar</span></a>
						<a href="" class="delete" data-toggle="modal" target="Borrar"><i class="material-icons">&#xe872;</i><span>Borrar</span></a>
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
        var id = e.path[3].childNodes[3].innerHTML;
        var paciente = e.path[3].childNodes[5].innerHTML;
        var fechaIngreso = e.path[3].childNodes[7].innerHTML;
        var horaIngreso = e.path[3].childNodes[9].innerHTML;
        var causa = e.path[3].childNodes[11].innerHTML;
        var prioridad = e.path[3].childNodes[13].innerHTML;
        
        
        //Conseguir valores
        document.getElementById('ModEmergencia').value = id;
        document.getElementById('ModPaciente').value = paciente;
        document.getElementById('ModFechaI').value=fechaIngreso;
        document.getElementById('ModHoraI').value=horaIngreso;
        document.getElementById('ModCausa').value=causa;
        document.getElementById('ModPrioridad').value=prioridad;
    }


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
    var mId= datosModificar.get('ModEmergencia');
    var mPaciente= datosModificar.get('ModPaciente');
    var mFecha= datosModificar.get('ModFechaI');
    var mHora= datosModificar.get('ModHoraI');
    var mCausa= datosModificar.get('ModCausa');
    var mPrioridad= datosModificar.get('ModPrioridad');
    
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
            "idEmergencia": `${e.target.ModEmergencia.value}`,
            "cedulaPaciente": `${e.target.ModPaciente.value}`,
            "fechaIngreso": `${e.target.ModFechaI.value}`,
            "horaIngreso": `${e.target.ModHoraI.value}`,
            "causa": `${e.target.ModCausa.value}`,
            "prioridad": `${e.target.ModPrioridad.value}`,
            

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