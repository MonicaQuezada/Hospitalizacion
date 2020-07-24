const url2 = 'https://hospitalizacion.herokuapp.com/api/servicio';
var formulario = document.getElementById('servicioForm');
//var listaElementos = document.getElementById('listaTodos');
//var modificar=document.getElementById('modificar');
//Al hacer click en el boton Crear
formulario.addEventListener('submit', function (e) {
    e.preventDefault();
    var datos = new FormData(formulario);
    var atencion=datos.get('atencion');
    var paciente = datos.get('paciente').text;
    var descripcion = datos.get('descp');
    var costo= datos.get('costo');
    var cantidad=datos.get('cant');
    fetch(url2, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            "cedulaPaciente": `${e.target.paciente.value}`,
            "fechaIngreso": `${e.target.fecha.value}`,
            "horaIngreso": `${e.target.hora.value}`,
            "causa": `${e.target.causa.value}`,
            "prioridad": `${e.target.prioridad.value}`
        })
    })
        .then(res => res.json())
        .then(data => {
            console.log(data)
            alert("Registro agregado");
            location.reload();
        })
})