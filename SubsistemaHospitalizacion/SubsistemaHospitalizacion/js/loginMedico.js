const url2 = 'https://hospitalizacion.herokuapp.com/api/medico';

/*$(document).ready(function(){
  $.ajax({
      url: 'https://hospitalizacion.herokuapp.com/api/medico',
      dataType: "json",
      complete: function(data){
          var response = data.responseJSON;
          //var items = response.items;
          //var item = items[0];
          var cedula = response.cedula;
          var contrasenia = responde.contrasenia;
          console.log(cedula);
          console.log(contrasenia);

      }
  });
});

*/
var result=[];
var init = {
  method: 'GET',
  headers: {
    'Content-Type': 'application/json'
  },

}

fetch(url2)
.then(function(resp){
  return resp.json();
})
.then(function(data){
  
  console.log(data);
  for (i=0; i < data.length; i++) {
    var datos= data[i];
    
    console.log(datos);
    if("010604" in datos){
      console.log(i);
      console.log("Usuario encontrado");
    } else{
      console.log("Usuario no existe")
    }
    datos="";
  }

  
  
     
});/*
    
$.each(data, function(i, v) {
    if (v.cedula == "010604") {
        alert(v.contrasenia);
        return;
})
    









/*var formulario = document.getElementById('form-signin');

function getData(url2) {
  return fetch(url2)
      .then(response => response.json())
      .then(result => result);
}

getData(URL)
  .then(result => console.log(result));

//Al hacer click en el boton Ingresar
formulario.addEventListener('submit', function (e) {
  var datos = new FormData(formulario);
  var ced = datos.get('cedula');
  var password = datos.get('password');
  

  
  const arrayDatos = fetch(url2).then(res => res.json())
  arrayDatos.then((data) => {
  // hacer algo con los datos
  for (i=0; i < JSONObject.data.length; i++) {
    if (JSONObject.data[i][2].cedula == ced)

        return true;
      } if (JSONObject.data[i][13].contrasenia == password){
        location.href ="http://localhost:5500/verHospitalizacion.html";
      }
return false;
/*
  resultado=data.list.filter( valor => valor.cedula === ced);
  for ( var i=0; i < resultado.length; i++){
    if(resultado[i] == password ){
        console.log("Usuario verificado")
        document.write("SI")
        location.href ="http://localhost:5500/verHospitalizacion.html";
      } else{
        console.log("Contraseña incorrecta");
      }
    
  }
});
})*/



