//API CIRUGIA
const url2 = 'https://hospitalizacion.herokuapp.com/api/cirugia/';
var formulario = document.getElementById('cirugiaForm');
//var listaElementos = document.getElementById('listaTodos');
//var modificar=document.getElementById('modificar');
//Al hacer click en el boton Crear
formulario.addEventListener('submit', function (e) {
    e.preventDefault();
    var datos = new FormData(formulario);
    var combo = document.getElementById('paciente');
    var paciente = combo.options[combo.selectedIndex].text;
    var atencion = datos.get('atencion').value;
    var quirofano = datos.get('quirofano');
    var medico = datos.get('medico');
    var tipo = datos.get('tipo')
    var costo = datos.get('costo')
    var descripcion= datos.get('descripcion')

    fetch(url2, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            "idCaso": `${e.target.atencion.value}`,
            "cedulaPaciente": `${e.target.paciente.value}`,
            "cedulaMedico": `${e.target.medico.value}`,
            "tipoCirugia": `${e.target.tipo.value}`,
            "costo": `${e.target.costo.value}`,
            "descripcion": `${e.target.descripcion.value}`,
            "idQuirofano": `${e.target.quirofano.value}`
        })
    })
        .then(res => res.json())
        .then(data => {
            console.log(data)
            alert("Registro agregado");
            location.reload();
        })
})
