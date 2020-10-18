<%-- 
    Document   : encuestaUsuario
    Created on : 18/10/2020, 12:02:09 AM
    Author     : 51968
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="MyApp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css" >
        
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js" ></script> 
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.0/angular.min.js"></script>
        <script src="../Resources/js/angular.js"></script>
        <title>carbon Out</title>
    </head>
    <body ng-controller="encuestaController as pc">
    <div class="header">
            <a href="#default" class="logo"><img src="../Resources/img/carbonoutLogo.png" /></a>
          <div class="header-right">
          </div>
    </div>
    <br>
    <div class="container">
      <section class="row">
        <div class="col-md-12">
          <h1 class="text-center">Carbuneate</h1>
          <p class="text-center">Este es un cuestionario hecho con preguntas claves para medir tu exposición al CO2.</p>
        </div>
      </section>
      <hr><br />
      <!--<section class="row">
        <section class="col-md-12">
          <h3>Datos basicos</h3>
          <p></p>
        </section>
      </section>
      <section class="row">
        <section class="col-md-12">
          <section class="row">
            <div class="col-md-4">
              <label for="tipoAtencion">Tipo de Atención: *</label>
              <select class="form-control" id="tipoAtencion">
              <option value="ce">Consulta Externa</option>
              <option value="farm">Farmacia</option>
              <option value="fisi">Fisioterapia</option>
              <option value="fo">Fo</option>
              <option value="hosp">Hospitalizació</option>
              <option value="odon">Odontologia</option>
              <option value="pyp">Promoción y Prevención</option>
              <option value="rx">Rayos X</option>
              <option value="urge">Urgencias</option>
            </select>
            </div>
            <div class="col-md-4">
              <div class="form-group">
                <label for="fechaActual">Fecha Actual: *</label>
                <input type="date" class="form-control" id="fechaActual" required>
              </div>
            </div>
            <div class="col-md-4">
              <div class="form-group">
                <label for="fechaActencion">Fecha Atención: *</label>
                <input type="date" class="form-control" id="fechaAtencion" required>
              </div>
            </div>
          </section>
          <section class="row">
            <div class="col-md-8">
              <div class="form-group">
                <label for="nombreCompleto">Nombre Compelto: *</label>
                <input type="text" class="form-control" id="nombreCompleto" maxlength="128" placeholder="Nombre Compelto" required>
              </div>
            </div>
            <div class="col-md-4">
              <div class="form_group">
                <label for="edadEncuestado">Edad: *</label>
                <input type="number" class="form-control" id="edadEncuestado" placeholder="Edad" maxlength="3" required/>
              </div>
            </div>
          </section>
          <section class="row">
            <div class="col-md-4">
              <div class="form-group">
                <label for="idIdentificacion">Identificación: *</label>
                <input type="number" id="idIdentificacion" class="form-control" placeholder="Numero de Identificación" maxlength="15" required/>
              </div>
            </div>
            <div class="col-md-4">
              <label for="telefono">Telefono: *</label>
              <input type="text" class="form-control" id="telefono" placeholder="Numero Telefonico" maxlength="12" required/>
            </div>
            <div class="col-md-4">
              <label for="epsPaciente">EPS: *</label>
              <input type="text" class="form-control" id="epsPaciente" placeholder "EPS del Paciente" required />
            </div>
          </section>
        </section>
      </section>
      <hr />

      <!--  Servicios  -->
      <section class="row">
        <div class="col-md-12">
          <h3>Hogar</h3>
          <p></p>
        </div>
      </section>
      <!--  PREGUNTA 1  -->
      <section class="row">
        <div class="col-md-6">
          <p>1- ¿Utilizas aire condicionado en tu casa?</p>
        </div>
        <div class="col-md-3">
              <select class="form-control" id="pregunta1" ng-model="p1">
              <option value="1">Sí</option>
              <option value="0">No</option>
            </select>
        </div>
        <div class="col-md-3"></div>
      </section>
      <!--  PREGUNTA 2  -->
      <section class="row">
        <div class="col-md-6">
          <p>2- ¿A cuanto asciende la factura electrica de tu casa? </p>
        </div>
        <div class="col-md-3">
            <select class="form-control" id="pregunta1" ng-model="p2">
              <option value="0">80  a 180 pesos</option>
              <option value="1">181 a 500 pesos</option>
              <option value="2">501 a 1000 pesos</option>
              <option value="3">Más de 1000 pesos</option>
            </select>
        </div>
        <div class="col-md-3"></div>
      </section>
      <hr>
      <!--  Durante la Atención  -->
      <section class="row">
        <div class="col-md-12">
          <h3>Estilo de Vida</h3>
          <p></p>
        </div>
      </section>
      <!--  PREGUNTA 5  -->
      <section class="row">
        <div class="col-md-6">
          <p>3- ¿Reciclas?</p>
        </div>
        <div class="col-md-3">
            <select class="form-control" id="pregunta1" ng-model="p3">
              <option value="1">Sí</option>
              <option value="0">No</option>
            </select>
        </div>
        <div class="col-md-3"></div>
      </section>
      <!--  PREGUNTA 6  -->
      <section class="row">
        <div class="col-md-6">
          <p>4- ¿Reciclas papel?</p>
        </div>
        <div class="col-md-3">
            <select class="form-control" id="pregunta1" ng-model="p4">
              <option value="1">Sí</option>
              <option value="0">No</option>
            </select>
        </div>
        <div class="col-md-3"></div>
      </section>
      <!--  PREGUNTA 7  -->
      <section class="row">
        <div class="col-md-6">
          <p>5- ¿Reciclas cartón?</p>
        </div>
        <div class="col-md-3">
            <select class="form-control" id="pregunta1" ng-model="p5">
              <option value="1">Sí</option>
              <option value="0">No</option>
            </select>
        </div>
        <div class="col-md-3"></div>
      </section>
      <hr />
      <!--  Durante la Atención  -->
      <section class="row">
        <div class="col-md-12">
          <h3>Transporte</h3>
          <p></p>
        </div>
      </section>
      <!--  PREGUNTA 10  -->
      <section class="row">
        <div class="col-md-6">
        <p>6- ¿Cuantos vuelos de hasta 2 horas haces cada año para asuntos personales? </p>
        </div>
        <div class="col-md-3">
            <select class="form-control" id="pregunta1" ng-model="p6">
              <option value="0">Raramente vuelo</option>
              <option value="1">1 a 2</option>
              <option value="2">3 a 8</option>
              <option value="3">Más de 8</option>
            </select>
        </div>
        <div class="col-md-3"></div>
      </section>
      <!--  PREGUNTA 11  -->
      <section class="row">
        <div class="col-md-6">
        <p>7- ¿Cuantos vuelos de más de 2 horas haces cada año para asuntos personales? </p>
        </div>
        <div class="col-md-3">
            <select class="form-control" id="pregunta1" ng-model="p7">
              <option value="0">Raramente vuelo</option>
              <option value="1">1 a 2</option>
              <option value="2">3 a 8</option>
              <option value="3">Más de 8</option>
            </select>
        </div>
        <div class="col-md-3"></div>
      </section>
      <!--  PREGUNTA 12  -->
      <section class="row">
        <div class="col-md-6">
        <p>8- ¿Te mueves habitualmente en coche? </p>
        </div>
        <div class="col-md-3">
            <select class="form-control" id="pregunta1" ng-model="p8">
              <option value="1">Sí</option>
              <option value="0">No</option>
            </select>
        </div>
        <div class="col-md-3"></div>
      </section>
      <!--  PREGUNTA 13  -->
        <section class="row">
        <div class="col-md-6">
        <p>9- ¿Cuantas veces usas el metro cada semana? </p>
        </div>
        <div class="col-md-3">
            <select class="form-control" id="pregunta1" ng-model="p9">
              <option value="0">De vez en cuando o Nunca</option>
              <option value="1">1-6 veces por semana</option>
              <option value="2">7-12 veces por semana</option>
              <option value="3">Más de 12 veces por semana</option>
            </select>
        </div>
        <div class="col-md-3"></div>
      </section>
      <hr />
      <!--  Satisfacción General  -->
      <section class="row">
        <div class="col-md-12">
          <h3>Alimentación</h3>
          <p></p>
        </div>
      </section>
      <!--  PREGUNTA 13  -->
      <section class="row">
        <div class="col-md-6">
        <p>10- ¿Qué tipo de dieta sigues? </p>
        </div>
        <div class="col-md-3">
            <select class="form-control" id="pregunta1" ng-model="p10">
              <option value="0">Como de todo, poca carne</option>
              <option value="1">Como de todo, carne frecuentemente</option>
              <option value="2">Como de todo, mucha carne</option>
              <option value="3">Soy vegetariano/pescariano</option>
            </select>
        </div>
        <div class="col-md-3"></div>
      </section>
      <!--  PREGUNTA 14  -->
              <section class="row">
        <div class="col-md-6">
        <p>11- ¿Cuanto gastas en restaurantes y bares en una semana? </p>
        </div>
        <div class="col-md-3">
            <select class="form-control" id="pregunta1" ng-model="p11">
              <option value="0">Nada</option>
              <option value="1">50 a 150 pesos</option>
              <option value="2">151 a 300 pesos</option>
              <option value="3">301 a 1000 pesos</option>
              <option value="4">Más de 1000 pesos</option>
            </select>
        </div>
        <div class="col-md-3"></div>
      </section>
      <hr />
      
      <section class="row">
        <div class="col-md-12">
            <button type="button" class="btn btn-info" id="saveForm" ng-click="pc.calcularScore()">Evaluar mi score</button>
        </div>
      </section>
    </div>

    <br /><br />
    <footer class="container">
      <p> Copyright © carbonout 2020 -Todos los derechos reservados</p>
    </footer>
    </body>
</html>
