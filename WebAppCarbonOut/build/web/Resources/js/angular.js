var myApp = angular.module('MyApp', []); //'ngRoute'

myApp.controller("encuestaController", function ($scope, $http) {
    var pc = this;
    $scope.p1 = 0;
    $scope.p2 = 0;
    $scope.p3 = 0;
    $scope.p4 = 0;
    $scope.p5 = 0;
    $scope.p6 = 0;
    $scope.p7 = 0;
    $scope.p8 = 0;
    $scope.p9 = 0;
    $scope.p10 = 0;
    $scope.p11 = 0;
    
    pc.calcularScore = function(){
        
        if($scope.p1.length > 0 &&
           $scope.p2.length > 0 &&
           $scope.p3.length > 0 &&
           $scope.p4.length > 0 &&
           $scope.p5.length > 0 &&
           $scope.p6.length > 0 &&
           $scope.p7.length > 0 &&
           $scope.p8.length > 0 &&
           $scope.p9.length > 0 &&
           $scope.p10.length > 0 &&
           $scope.p11.length > 0
           ){
        console.log($scope.p1 + $scope.p2);
        console.log($scope.p3 + $scope.p4 + $scope.p5);
        console.log($scope.p6 + $scope.p7 + $scope.p8 + $scope.p9);
        console.log($scope.p10 + $scope.p11);
        
        $http({method: "POST", url: "/WebAppCarbonOut/UsuarioServlet", 
               params: {
                id: 4,
                p1: $scope.p1,
                p2: $scope.p2,
                p3: $scope.p3,
                p4: $scope.p4,
                p5: $scope.p5,
                p6: $scope.p6,
                p7: $scope.p7,
                p8: $scope.p8,
                p9: $scope.p9,
                p10: $scope.p10,
                p11: $scope.p11
               }}).then(function (result){
                   alert("Éxito! Score Calculado!"); 
                   window.location.href="dashUsuario.jsp";
                    }, function() {
                    alert("Error!"); 
                });
      }else{
          alert('Responda las preguntas!');
      }
        //window.location.href="Panel/index.html";
    };
    
});

myApp.controller("dashController", function ($scope, $http) {
    var pc = this;
    var score = "";
    $scope.nota1 = 100;
    $scope.nota2 = 100;
    $scope.nota3 = 100;
    $scope.nota4 = 100;
    
    pc.obtenerScore = function(){
         $http({
            method: "GET",
            url: "/WebAppCarbonOut/UsuarioServlet",
            params: {
                id:  2
            }}).then(function (result){
                score = result.data;
                $scope.nota1 = score.nota1;
                $scope.nota2 = score.nota2;
                $scope.nota3 = score.nota3;
                $scope.nota4 = score.nota4;
                console.log($scope.nota1);
            } );
    };
    
    pc.obtenerScore();
    
});
myApp.controller("usuarioController", function ($scope, $http) {
    var pc = this;
    $scope.nombreUsuario2 = "";
    $scope.correoUsuario2 = "";
    $scope.contraseniaUsuario2 = "";
    $scope.uSesion = "";
   
    /*Inicio - Sección Accesos*/
    
    /*Cerrar Sesión*/
    //pc.logOut = function (){ myApp.logOut($http);};
    
    
    pc.signUp= function(){
        console.log($scope.correoUsuario2);
        $http({method: "POST", url: "/WebAppCarbonOut/UsuarioServlet", 
               params: {
                id: 1,
                nombreUsuario: $scope.nombreUsuario2,
                correoUsuario: $scope.correoUsuario2,
                contrasenia: $scope.contraseniaUsuario2,
                flgActivo: 'A'
               }}).then(function (result){
                   alert("Éxito! Usuario Registrado!"); 
                    }, function() {
                    alert("Error!"); 
                });
    };
   
   
    
    pc.signIn = function(){ 
            $http({
            method: "GET",
            url: "/WebAppCarbonOut/UsuarioServlet",
            params: {
                id:  1,
                correoUsuario: $scope.correoUsuario1,
                contrasenia: $scope.contraseniaUsuario1
            }}).then(function (result){
                $scope.uSesion = result.data; 
                pc.verifyLogin($scope.uSesion);
            } );
    };
    
    pc.recoverUser = function(){ 
            $http({
            method: "POST",
            url: "/WebAppCarbonOut/UsuarioServlet",
            params: {
                id:  2,
                correoRecuperar: $scope.correoRecuperar
            }}).then(function (result){
            alert("chevere!");
                //$scope.uSesion = result.data; 
                //pc.verifyLogin($scope.uSesion);
            } );
    };

    pc.verifyLogin = function(jsonUser){
        jsonUserT = jsonUser;
        if(jsonUserT.idUsuario === 0){
            alert("Error al ingresar. Por favor vuelva a intentar!")
        }else{
            window.location.href="dashUsuario.jsp";
        };
    };
    /*Validar Sesión activa*/
    /*$http({method: "GET", url: "/PeruReportJavaWeb/UsuarioServlet", params: {id:  5}}).
    then(function (result){
        $scope.uSesionOn = result.data; pc.verifyLogin($scope.uSesionOn); 
        pc.getDataInitial();
    }, function() {
        alert("No existe una sesión activa."); 
        window.location.href="../Error.html";
    });*/ 
    /*Fin - Sección Accesos*/
   
    //Fin - Script Para Exportar Excel

});