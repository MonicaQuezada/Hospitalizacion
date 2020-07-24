
const url2 = 'https://hospitalizacion.herokuapp.com/api/interno';
var formulario = document.getElementById('medicoForm');
//var listaElementos = document.getElementById('listaTodos');
//var modificar=document.getElementById('modificar');
//Al hacer click en el boton Crear
formulario.addEventListener('submit', function (e) {
    e.preventDefault();
    var datos = new FormData(formulario);
    var cedula = datos.get('cedula');
    var nombre = datos.get('nombre');
    var apellido = datos.get('apellido')
    var direccion = datos.get('direction')
    var telefono = datos.get('phoneNumber')
    var fechaNacimiento = datos.get('fechaNacimiento')
    var edad = datos.get('edad')
    var sexo = datos.get('sexo')
    var universidad = datos.get('universidad')
    var fechaIngreso = datos.get('fechaIngreso')
    var correo = datos.get('email')
    var estado = datos.get('estado')
    var contrasenia = datos.get('contrasenia')
    var rol = datos.get('rol')

    fetch(url2, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            "cedula": `${e.target.cedula.value}`,
            "nombre": `${e.target.nombre.value}`,
            "apellido": `${e.target.apellido.value}`,
            "fechaNacimiento": `${e.target.fechaNacimiento.value}`,
            "edad": `${e.target.edad.value}`,
            "sexo": `${e.target.sexo.value}`,
            "direccion": `${e.target.direccion.value}`,
            "email": `${e.target.email.value}`,
            "telefono": `${e.target.telefono.value}`,
            "estadoCivil": `${e.target.estado.value}`,
            "fechaIngreso": `${e.target.fechaIngreso.value}`,
            "contrasenia": `${e.target.contrasenia.value}`,
            "rol": `${e.target.rol.value}`,
            "universidad": `${e.target.universidad.value}`,

        })
    })
        .then(res => res.json())
        .then(data => {
            console.log(data)
            alert("Registro agregado");
            location.reload();
        })
})
