<%-- 
    Document   : MenuInicio
    Created on : 17/10/2020, 03:06:00 PM
    Author     : 51968
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!--<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
        -->
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.0/angular.min.js"></script>
        <script src="https://kit.fontawesome.com/64d58efce2.js" crossorigin="anonymous"></script>
        <link href="Resources/css/styleGeneral.css" rel="stylesheet" type="text/css" />
        <script src="Resources/js/angular.js"></script>
        <title>carbon Out</title>
    </head>
    <body>
            <jsp:include page="Encabezado.html" />
            <div class="panelInicial">
                <span class="titleInicial">Limpia el planeta con simples acciones</span> 
                <span class="textPrincipal">
                    Nuestra solución se basá en una aplicación que tiene como objetivo ayudar a que las personas 
                    puedan contribuir en la disminución de CO2 en México. 
                                         
                </span>
                <a href="Panel/index.html" class="btnEntrar">Entrar</a>
                <!--<button type="button" class="btnEntrar" ng-click="pc.openSign()">Agregar</button>-->
                <div class="circleGreen"></div>
                <div class="circleWithImage"></div>
                <div class="circleSkyBlue"></div>
               
            </div>
            <div class="panelSecond">
                 <div class="circleOnlyBorder"></div>
                 <span class="titleSecond">Nuestros 4 enfoques</span> 
                 <span class="textSecond">
                    Para lograrlo, nos enfocamos en promover que las personas puedan realizar 
                    diversas acciones en su hogar, 
                    su estilo de vida y medios de transportes que utilizan para favorecer a la disminución del CO2. 
                    </span>
                 <div class="circleWithImageHogar"></div>
                 <div class="circleWithImageAlimentacion"></div>
                 <div class="circleWithImageEstiloVida"></div>
                 <div class="circleWithImageTransporte"></div>
            </div>
            <div class="panelThird">
                 <div class="circleOnlyBorder"></div>
                 <div class="circleOnlyBorderGreen"></div>
                 <div class="circleWithImagePlaya"></div>
                 <div class="circleGreenSecond"></div>
                 <div class="circleSkyBlueSecond"></div>
                 <span class="titleThird">Nuestro propósito</span> 
                 <span class="textThird">
                    Por ello, los acompañaremos a que estas personas puedan cumplir con diferentes retos que les ayude 
                    también a que ahorren gastos de su hogar, puedan tener un mejor estilo de vida y recomendarles una inversión en la ecotecnología más adecuada.  
                 </span>
            </div>
            <div>
                <span class="titleFour">Nos respaldan</span> 
                <div class="circleWithImageFour1"></div>
                <div class="circleWithImageFour2"></div>
                <div class="circleWithImageFour3"></div>
            </div>
            
            <div class="footerImage"></div>
            <span class="textLast">
                Copyright © carbonout 2020 -Todos los derechos reservados
            </span>
           
    </body>
</html>
