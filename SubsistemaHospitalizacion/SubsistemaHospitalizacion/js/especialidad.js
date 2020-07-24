const url = 'https://hospitalizacion.herokuapp.com/api/especialidad/';
var formulario = document.getElementById('especialidadForm');
//var listaElementos = document.getElementById('listaTodos');
//var modificar=document.getElementById('modificar');
//Al hacer click en el boton Crear
formulario.addEventListener('submit', function (e) {
    e.preventDefault();
    var datos = new FormData(formulario);
    var nombre = datos.get('nombre');
    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            "nombre": `${e.target.nombre.value}`,
        })
    })
        .then(res => res.json())
        .then(data => {
            console.log(data)
            alert("Reggistro agregado");
            location.reload();
        })
})