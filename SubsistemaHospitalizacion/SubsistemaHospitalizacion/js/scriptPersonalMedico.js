const url2 = 'https://hospitalizacion.herokuapp.com/api/medico/';
var modificar = document.getElementById('editarMed');
var listaElementos = document.getElementById('listaTodos');

//Cuando se presione sobre boton editar/eliminar 
listaElementos.addEventListener('click', (e) => {
    e.preventDefault();
    if(e.target.innerHTML === 'Editar'){
        //posicion en el listar
        var id = e.path[3].childNodes[3].innerHTML;
        var cedula = e.path[3].childNodes[5].innerHTML;
        var nombre = e.path[3].childNodes[7].innerHTML;
        var apellido = e.path[3].childNodes[9].innerHTML;
        var fechaNacimiento = e.path[3].childNodes[11].innerHTML;
        var edad = e.path[3].childNodes[13].innerHTML;
        var sexo = e.path[3].childNodes[15].innerHTML;
        var direccion = e.path[3].childNodes[17].innerHTML;
        var correo = e.path[3].childNodes[19].innerHTML;
        var telefono = e.path[3].childNodes[21].innerHTML;
        var estado = e.path[3].childNodes[23].innerHTML;
        var fechaIngreso = e.path[3].childNodes[25].innerHTML;
        var credencial = e.path[3].childNodes[27].innerHTML;
        var especialidad=e.path[3].childNodes[29].innerHTML;
        var contraseña=e.path[3].childNodes[31].innerHTML;
        var rol=e.path[3].childNodes[33].innerHTML;
        //Conseguir valores
        document.getElementById('ModId').value = id;
        document.getElementById('ModCedula').value = cedula;
        document.getElementById('ModNombre').value=nombre;
        document.getElementById('ModApellido').value=apellido;
        document.getElementById('ModFechaNacimiento').value=fechaNacimiento;
        document.getElementById('ModEdad').value=edad;
        document.getElementById('ModSexo').value=sexo;
        document.getElementById('ModDireccion').value=direccion;
        document.getElementById('ModEmail').value=correo;
        document.getElementById('ModTelefono').value=telefono;
        document.getElementById('ModEstado').value=estado;
        document.getElementById('ModFechaIngreso').value=fechaIngreso;
        document.getElementById('ModCredencial').value=credencial;
        document.getElementById('ModIdEspecialidad').value=especialidad;
        document.getElementById('ModContraseña').value=contraseña;
        document.getElementById('ModRol').value=rol;
    }
    
    if (e.target.innerHTML === 'Borrar'){
        var ced=e.path[3].childNodes[5].innerHTML; 
        console.log(ced);
        var urlE = `${url2}` + ced;
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
            body: JSON.stringify(ced),
        })
        
        .then(res => res.json()) // or res.json()
        .then(res => console.log(res))
        alert("Eliminar registro");
        location.reload();
    }
})


//Editar
modificar.addEventListener('submit', function(e) {
    //console.log("hace click")
    e.preventDefault();
    var datosModificar = new FormData(modificar);
    var mId= datosModificar.get('ModId');
    var mCedula= datosModificar.get('ModCedula');
    var mNombre= datosModificar.get('ModNombre');
    var mApellido= datosModificar.get('ModApellido');
    var mFechaN= datosModificar.get('ModFechaNacimiento');
    var mEdad= datosModificar.get('ModEdad');
    var mSexo= datosModificar.get('ModSexo');
    var mDireccion= datosModificar.get('ModDireccion');
    var mEmail= datosModificar.get('ModEmail');
    var mTelefono= datosModificar.get('ModTelefono');
    var mEstadoCivil= datosModificar.get('ModEstado');
    var mFechaI= datosModificar.get('ModFechaIngreso');
    var mCredencial= datosModificar.get('ModCredencial');
    var mEspecialidad= datosModificar.get('ModIdEspecialidad');
    var mContraseña= datosModificar.get('ModContraseña');
    var mRol= datosModificar.get('ModRol');
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
            "idPersona": `${e.target.ModId.value}`,
            "cedula": `${e.target.ModCedula.value}`,
            "nombre": `${e.target.ModNombre.value}`,
            "apellido": `${e.target.ModApellido.value}`,
            "fechaNacimiento": `${e.target.ModFechaNacimiento.value}`,
            "edad": `${e.target.ModEdad.value}`,
           "sexo": `${e.target.ModSexo.value}`,
            "direccion": `${e.target.ModDireccion.value}`,
            "email": `${e.target.ModEmail.value}`,
            "telefono": `${e.target.ModTelefono.value}`,
            "estadoCivil": `${e.target.ModEstado.value}`,
            "fechaIngreso": `${e.target.ModFechaIngreso.value}`,
            "credencialMedico": `${e.target.ModCredencial.value}`,
            "idEspecialidad": `${e.target.ModIdEspecialidad.value}`,
            "contrasenia": `${e.target.ModContraseña.value}`,
            "rol": `${e.target.ModRol.value}`,

        })
    })
        .then(res=> res.json())
        .then(data => {
            console.log(data);
            alert("Usuario actualizado");
            location.reload();
        })
        .catch(err => console.error(err)) 
})


//Cargar especialidad
function cargarEspecialidad(){
    fetch('https://hospitalizacion.herokuapp.com/api/especialidad')
    .then(function(res){
        return res.json();
    })
    .then(function(data){
        var select = document.getElementsByName('ModIdEspecialidad')[0];
        data.forEach(function(ModIdEspecialidad){
            var option = document.createElement('option');
            option.value = ModIdEspecialidad.idEspecialidad;
            option.text = ModIdEspecialidad.nombre;
            select.add(option);
        });
    })
}

//Listar elementos
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
                    <th scope="row">${valor.idPersona}</th>
                    <td>${valor.cedula}</td>
                    <td>${valor.nombre}</td>
                    <td>${valor.apellido}</td>
                    <td>${valor.fechaNacimiento}</td>
                    <td>${valor.edad}</td>
                    <td>${valor.sexo}</td>
                    <td>${valor.direccion}</td>
                    <td>${valor.email}</td>
                    <td>${valor.telefono}</td>
                    <td>${valor.estadoCivil}</td>
                    <td>${valor.fechaIngreso}</td>
                    <td>${valor.credencialMedico}</td>
                    <td>${valor.idEspecialidad}</td>
                    <td>${valor.contrasenia.hide}</td>
                    <td>${valor.rol}</td>
                <td>
							<a href="#editModal"  type="edit" name="edit" data-toggle="modal" target="Editar"><i class="material-icons">&#xe254;</i><span>Editar</span></a>
							<a href="" name="delete" data-toggle="modal" target="Borrar"><i class="material-icons">&#xe872;</i><span>Borrar</span></a>
                </td>
              </tr>
                `
            }
        })
        .catch(err => console.log(err))
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


