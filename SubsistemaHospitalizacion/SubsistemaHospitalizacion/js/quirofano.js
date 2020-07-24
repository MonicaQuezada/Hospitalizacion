//API QUIROFANO
const url2 = 'https://hospitalizacion.herokuapp.com/api/quirofano';
var formulario = document.getElementById('quirofanoForm');
//var listaElementos = document.getElementById('listaTodos');
//var modificar=document.getElementById('modificar');
//Al hacer click en el boton Crear
formulario.addEventListener('submit', function (e) {
    e.preventDefault();
    var datos = new FormData(formulario);
    var descripcion = datos.get('descripcion')

    fetch(url2, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            "descripcion": `${e.target.descripcion.value}`
        })
    })
        .then(res => res.json())
        .then(data => {
            console.log(data)
            alert("Recurso agregado");
            location.reload();
        })
})
