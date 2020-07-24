function funcionCarga(){
    cargarRoles();
}


function cargarRoles(){
    fetch('https://sevidorbd2.herokuapp.com/api/rol/roles')
    .then(function(res){
        return res.json();
    })
    .then(function(data){
        var select = document.getElementsByName('rol')[0];
        data.forEach(function(roles){
            var option = document.createElement('option');
            option.value = roles.id_rol;
            option.text = roles.nombre;
            select.add(option);
        });
    })
}