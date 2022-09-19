# App_Bienestar_Universitario_Backend

### Aplicación utilizada para realizar la conexión a la base de datos y su debido uso

<p> Esta aplicación está creada en base a las prácticas de "clean architecture", usando Arquitectura Hexagonal y principios SOLID 
</p>


<ul>
  <li>Arquitectura Hexagonal</li>
  <p> 
   Tiene como principal motivación separar nuestra aplicación en distintas capas o regiones con su propia responsabilidad.
   De esta manera consigue desacoplar capas de nuestra aplicación permitiendo que evolucionen de manera aislada. 
   Además, tener el sistema separado por responsabilidades nos facilitará la reutilización
  </p>
  
  ![Imagén Ejemplo Arquitectura](https://miro.medium.com/max/1400/1*yR4C1B-YfMh5zqpbHzTyag.png)
  
  <li>Principios SOLID</li>
    <ul>
    <li>
      S – Single Responsability Principle (SRP)
      <p>
        La noción de que un objeto solo debería tener una única razón para cambiar.
      </p>
    </li>
    <li>
      O – Open/Closed Principle (OCP)
      <p>
        La noción de que las entidades de software deben estar abiertas para su extensión, pero cerradas para su modificación.
      </p>
    </li>
    <li>
      L – Liskov Substitution Principle (LSP) 
      <p>
        La noción de que los objetos de un programa deberían ser reemplazables por instancias de sus subtipos sin alterar el correcto funcionamiento del programa.
      </p>
    </li>
    <li>
      I – Interface Segretation Principle (ISP) 
      <p>
        La noción de que muchas interfaces cliente específicas son mejores que una interfaz de propósito general.
      </p>
    </li>
    <li>
      D – Dependency Inversion Principle (DIP) 
      <p>
        La noción de que se debe depender de abstracciones, no depender de implementaciones.
      </p>
    </li>
</ul>
</ul>
![Descripción SOLID](https://miro.medium.com/max/1191/1*JbfRQ05jyfBsO9glDl9E4w.png)

<p>
  El aplicativo se trabaja bajo el framework de Spring-Java (JDK 1.8) junto a la base de datos de postgresql 
</p>

![Spring](https://geeksjavamexico.files.wordpress.com/2017/09/spring-framework.png?w=550)
![Postgresql](https://sqltrainning.files.wordpress.com/2017/03/postgres_logo.png)
