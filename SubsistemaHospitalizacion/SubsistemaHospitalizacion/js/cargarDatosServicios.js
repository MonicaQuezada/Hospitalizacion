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
            option.value= pacientes.id;
            option.text = pacientes.cedula;
            select.add(option);
        });
    })
}

function cargarCaso(){
    var cod = document.getElementById('paciente');
    var seleccionado = cod.value;
    var url='https://radiant-temple-35339.herokuapp.com/api/atencion/'+seleccionado;
    fetch(url)
    .then(function(res){
        return res.json();
    })
    .then(function(data){
        document.getElementById('atencion').innerHTML = ""
        var select = document.getElementsByName('atencion')[0];
        data.forEach(function(caso){
            var option = document.createElement('option');
            option.text=caso.cod_atencion;
            select.add(option);
        });
    })

}