//API AREAS
const url2 = 'https://hospitalizacion.herokuapp.com/api/area';
var formulario = document.getElementById('areaForm');
//var listaElementos = document.getElementById('listaTodos');
//var modificar=document.getElementById('modificar');
//Al hacer click en el boton Crear
formulario.addEventListener('submit', function (e) {
    e.preventDefault();
    var datos = new FormData(formulario);
    var nombre = datos.get('nombre');
    var piso = datos.get('numpiso');
    var habitaciones = datos.get('numhab')

    fetch(url2, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            "nombre": `${e.target.nombre.value}`,
            "habitaciones": `${e.target.habitaciones.value}`,
            "piso": `${e.target.piso.value}`
        })
    })
        .then(res => res.json())
        .then(data => {
            console.log(data)
            alert("Area registrada");
            location.reload();
        })
})
