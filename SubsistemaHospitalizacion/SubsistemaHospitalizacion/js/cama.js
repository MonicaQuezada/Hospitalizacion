//API CAMAS
const url2 = 'https://hospitalizacion.herokuapp.com/api/cama';
var formulario = document.getElementById('camaForm');
//var listaElementos = document.getElementById('listaTodos');
//var modificar=document.getElementById('modificar');
//Al hacer click en el boton Crear
formulario.addEventListener('submit', function (e) {
    e.preventDefault();
    var datos = new FormData(formulario);
    var area = datos.get('area').value;
    var habitacion = datos.get('hab');
    var estado = datos.get('estado');

    fetch(url2, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            "idArea": `${e.target.area.value}`,
            "idHabitacion": `${e.target.habitacion.value}`,
            "estado": `${e.target.estado.value}`
        })
    })
        .then(res => res.json())
        .then(data => {
            console.log(data)
            alert("Recurso agregado");
            location.reload();
        })
})
