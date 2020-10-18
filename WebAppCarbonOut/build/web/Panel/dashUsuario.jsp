<%-- 
    Document   : dashUsuario
    Created on : 17/10/2020, 11:00:21 PM
    Author     : 51968
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="MyApp">
    <head>
        <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet" />
        <link href="../Resources/css/ccsDash.css" rel="stylesheet" />
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.0/angular.min.js"></script>
        <script src="../Resources/js/angular.js"></script>
        <title>carbon Out</title>
    </head>
    <body ng-controller="dashController as pc">
        <div class="header">
            <a href="#default" class="logo"><img src="../Resources/img/carbonoutLogo.png" /></a>
          <div class="header-right">
          </div>
        </div>
        <div class="cardPrincipal">
                <img src="../Resources/img/usuarioImg.png" class="imageUsuario" alt="" />
                
                <a href="encuestaUsuario.jsp" class="btnEncuesta">Calcular Score</a>
        </div>
        <div class="cardScore">
             <h1 class="textNumero">{{(((nota1 * 100)* 40/100 + (nota2 * 100)* 20/100 +  
                                      (nota3 * 100)* 30/100 + (nota4 * 100)* 10/100) - 100) * - 1
                                    }}</h1>
             <h3 class="textNombre">Score -CO2</h3>
        </div>
        
        <div class="cardsEnfoques">
            <div class="cardsEnfoquesHogar">
                <h1 class="textNumero"  ng-model="nota1" ng-value="nota1" >{{ ((nota1 * 100) - 100) * -1 }}</h1>
                <h3 class="textNombre">Hogar</h3>
            </div>
            <div class="cardsEnfoquesEstiloVida">
                <h1 class="textNumero" ng-model="nota2" ng-value="nota2">{{((nota2 * 100) - 100) * -1}}</h1>
                <h3 class="textNombre">Estilo de Vida</h3>
            </div>
            <div class="cardsEnfoquesTransporte">
                <h1 class="textNumero" ng-model="nota3" ng-value="nota3">{{((nota3 * 100) - 100) * -1}}</h1>
                <h3 class="textNombre">Transporte</h3>
            </div>
            <div class="cardsEnfoquesAlimentacion">
                <h1 class="textNumero" ng-model="nota4" ng-value="nota4">{{((nota4 * 100) - 100) * -1}}</h1>
                <h3 class="textNombre">Alimentación</h3>
            </div>
        </div>
        
        <div class="cardsEnfoques2">
            <div class="cardsEnfoquesHogar">
                <label style="font-style: italic; ">Se recomienda la instalación de paneles solares para disminuir a 3000KW y tu ahorro monetario sería de 200 pesos mensuales</label>
            </div>
            <div class="cardsEnfoquesEstiloVida">
                <label style="font-style: italic; ">Se recomienda el siguiente crédito para adiquirir el siguiente producto ecologico y tu ahorro monetario sería de 200 pesos mensuales</label>
            </div>
            <div class="cardsEnfoquesTransporte">
                <label style="font-style: italic; ">Se recomienda el uso de carro toyoya 2020 ya que subiría en un 10% su score de disminución del CO2 y este esta a su alcance. Tendrías un ahorro monetario de 100 pesos</label>
            </div>
            <div class="cardsEnfoquesAlimentacion">
                <label style="font-style: italic; ">Se recomienda comer más frutas y elementos organicos y tu ahorro monetario sería de 350 pesos.</label>
            </div>
        </div>
    </body>
</html>
