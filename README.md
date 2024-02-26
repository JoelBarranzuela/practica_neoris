# DESARROLLO DE PRACTICA API REST USUARIOS
PRACTICA DE DESAFIO JAVA 2024

# DIAGRAMA API REST USUARIOS
![diagrama](https://github.com/JoelBarranzuela/practica_neoris/assets/32132384/5fb6d74c-5e2e-4051-89a7-25b728f8fc3b)


# REALIZACIÓN DE PASOS PARA LA PRUEBAS DE LA API REST

NOTA: El proyecto esta realizado con SpringBoot 3, JDK y BD H2.

1. Importar o arrastrar la colección de postman adjunta en la raiz del proyecto-
   ![image](https://github.com/JoelBarranzuela/practica_neoris/assets/32132384/45ce1c2c-ca58-468c-9235-2b9671b9a4ac)

2. Para la creación de usuario tendremos los siguientes detalles. La URL es:  http://localhost:8080/practica/api/v1/user
   2.1 La contraseña esta permitida para tener al menos un numero, una letra, un caracter especial(Ejem: @) y al menos 8 caracteres
   2.2 El correo debe tener el formato @....
   
![image](https://github.com/JoelBarranzuela/practica_neoris/assets/32132384/157d223c-a4da-4579-a337-d531ec46da24)

3. Para dar de baja o activar a un usuario, se envia por parametro el correo registrado. La URL es: http://localhost:8080/practica/api/v1/user?email=bbbbb@gmail.com

![image](https://github.com/JoelBarranzuela/practica_neoris/assets/32132384/fcbf1916-a3c3-447f-bfbc-88aea7367502)


4. Para el siguiente endpoint, listaremos todos los usuarios. la URL es: http://localhost:8080/practica/api/v1/user
   ![image](https://github.com/JoelBarranzuela/practica_neoris/assets/32132384/abcd0268-f747-4702-b88f-06bee4ccddea)

