//API HOSPITALIZACION
const url2 = 'https://hospitalizacion.herokuapp.com/api/hospitalizacion';
var formulario = document.getElementById('hospitalForm');
//Al hacer click en el boton Crear
formulario.addEventListener('submit', function (e) {
    e.preventDefault();
    var datos = new FormData(formulario);
    var paciente = datos.get('paciente');
    var atencion = datos.get('atencion').value;
    var cama = datos.get('cama');
    var fechaingreso = datos.get('fechaingreso');
    var horaingreso = datos.get('horaingreso');
    var fechasalida = datos.get('fechasalida');
    var horasalida = datos.get('horasalida')

    fetch(url2, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            "cedulaPaciente": `${e.target.paciente.value}`,
            "idCaso": `${e.target.atencion.value}`,
            "fechaIngreso": `${e.target.fechaingreso.value}`,
            "horaIngreso": `${e.target.horaingreso.value}`,
            "idCama": `${e.target.cama.value}`,
            "fechaSalida": `${e.target.fechasalida.value}`,
            "horaSalida": `${e.target.horasalida.value}`,
        })
    })
        .then(res => res.json())
        .then(data => {
            console.log(data)
            alert("Registro ingresado");
            location.reload();
        })
})
