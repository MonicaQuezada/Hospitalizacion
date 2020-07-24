//API CIRUGIA
const url2 = 'https://hospitalizacion.herokuapp.com/api/cirugia/';
var formulario = document.getElementById('formulario');
var listaElementos = document.getElementById('listaTodos');
var modificar=document.getElementById('modificar');


//LISTAR DATOS
function obtenerTodos() {
    fetch(url2)
        .then(response => response.json())
        .then(data => {

            for (let valor of data) {
                listaElementos.innerHTML += `
                <tr>
                    <td>
                        <span class="custom-checkbox">
                            <input type="checkbox" name ="check" id="checkbox1" data-toggle="toggle" data-off="Disabled" value="${valor.idPersona}">
                            <label for="checkbox1"></label>
                        </span>
                    </td>
                    <th scope="row">${valor.idCirugia}</th>
                    <td>${valor.idCaso}</td>
                    <td>${valor.cedulaPaciente}</td>
                    <td>${valor.cedulaMedico}</td>
                    <td>${valor.tipoCirugia}</td>
                    <td>${valor.costo}</td>
                    <td>${valor.descripcion}</td>
                    <td>${valor.idQuirofano}</td>
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
        var caso = e.path[3].childNodes[5].innerHTML;
        var paciente = e.path[3].childNodes[7].innerHTML;
        var medico = e.path[3].childNodes[9].innerHTML;
        var cirugia = e.path[3].childNodes[11].innerHTML;
        var costo = e.path[3].childNodes[13].innerHTML;
        var desc = e.path[3].childNodes[15].innerHTML;
        var quirofano = e.path[3].childNodes[17].innerHTML;
        
        //Conseguir valores
        document.getElementById('ModCirugia').value = id;
        document.getElementById('ModAtencion').value = caso;
        document.getElementById('ModPaciente').value=paciente;
        document.getElementById('ModDoctor').value=medico;
        document.getElementById('ModNombre').value=cirugia;
        document.getElementById('ModCosto').value=costo;
        document.getElementById('ModDesc').value=desc;
        document.getElementById('ModQuirofano').value=quirofano;
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
    var mId= datosModificar.get('ModCirugia');
    var mCaso= datosModificar.get('ModAtencion');
    var mPaciente= datosModificar.get('ModPaciente');
    var mMedico= datosModificar.get('ModDoctor');
    var mTipo= datosModificar.get('ModNombre');
    var mCosto= datosModificar.get('ModCosto');
    var mDesc= datosModificar.get('ModDesc');
    var mQ= datosModificar.get('ModQuirofano');
    
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
            "idCirugia": `${e.target.ModCirugia.value}`,
            "idCaso": `${e.target.ModAtencion.value}`,
            "cedulaPaciente": `${e.target.ModPaciente.value}`,
            "cedulaMedico": `${e.target.ModDoctor.value}`,
            "tipoCirugia": `${e.target.ModNombre.value}`,
            "costo": `${e.target.ModCosto.value}`,
           "descripcion": `${e.target.ModDesc.value}`,
            "idQuirofano": `${e.target.ModQuirofano.value}`,
            

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