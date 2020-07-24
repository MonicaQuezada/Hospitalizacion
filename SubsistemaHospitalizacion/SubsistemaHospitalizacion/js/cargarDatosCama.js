function funcionCarga(){
    cargarAreas();
}


function cargarAreas(){
    fetch('https://hospitalizacion.herokuapp.com/api/area')
    .then(function(res){
        return res.json();
    })
    .then(function(data){
        var select = document.getElementsByName('area')[0];
        data.forEach(function(area){
            var option = document.createElement('option');
            option.value = area.idArea;
            option.text = area.nombre;
            select.add(option);
        });
    })
}