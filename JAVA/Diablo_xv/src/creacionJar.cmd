set PATH=C:\Program Files\Java\jdk1.8.0_72\bin;%PATH%
jar cvf artefactos.jar Modelo/Artefacto.class Modelo/Arma.class Modelo/Armadura.class Modelo/Saco.class Controlador/GestorArtefacto.class 
jar cvf mundo.jar Modelo/Celda.jar Modelo/Laberinto.class Controlador/GestorLaberinto.class Modelo/Avatar.class Modelo/ObjetoGrafico.class Modelo/Enemigo.class Modelo/Entidad.class Modelo/IntPair.class Modelo/Pared.class Modelo/Pasadizo.class Modelo/Anterior.class Modelo/Siguiente.class Controlador/GestorAvatar.class Controlador/GestorEnemigo.class
jar cvf interfaz.jar Vista/Render.class Controlador/GestorInteraccion.class Controlador/Consola.class Controlador/GestorJuego.class 
jar cvf juego.jar Controlador/Juego.class