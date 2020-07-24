function funcionCarga(){
    cargarPacientes();
}


function cargarPacientes(){
    fetch('https://turno-paciente.herokuapp.com/api/paciente')
    .then(function(res){
        return res.json();
    })
    .then(function(data){
        var select = document.getElementsByName('paciente')[0];
        data.forEach(function(pacientes){
            var option = document.createElement('option');
            option.value = pacientes.id;
            option.text = pacientes.cedula;
            select.add(option);
        });
    })
}