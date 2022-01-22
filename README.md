# Proyecto: Envio de email

Este repositorio fue dedicado a mejorar conocimientos sobre la biblioteca java mail. Esta es una api que te permite enviar un correo a cualquier persona usando los siguientes puntos:
- Te permite agregar un titulo para el correo
- Puedes agregar el correo al que quiere enviar el mensaje
- Agregar el mensaje o cuerpo del correo.

## Uso de la app
Sigue estos pasos para ejecutar la aplicacion.

Paso 1: Clonar el repositorio
```git
git clone https://github.com/KenCuevas/JavaEmailSender.git
```
Paso 2: Cambiar las variables de entorno en el archivo [**application-prod.yml**](https://github.com/KenCuevas/JavaEmailSender/blob/master/src/main/resources/application-prod.yml "Enlace al archivo") para utilizar el correo que quieras.
> Debes de tener en cuenta que el correo que vayas a usar no tenga habilitado la verificacion en 2 pasos.

Paso 3: Editar el archivo [**EmailServiceImpl**](https://github.com/KenCuevas/JavaEmailSender/blob/master/src/main/java/com/mailsender/emailsend/Services/EmailServiceImpl.java "Enlace al archivo") debes editar la siguiente seccion (se te indica en el comentario.):
```java
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setTo(email.getEmailTo());
        mailMessage.setSubject(email.getSubject());
        mailMessage.setText(email.getMessage());
        mailMessage.setFrom("tucorreoaqui"); // editar aqui, debes poner tu correo.
```
Paso 4: Ejecutar la aplicacion.
```maven
mvn spring-boot:run
```
- La aplicacion estara corriendo en: http://localhost:8080

Paso 5: Para este paso utilizaremos Postman para enviar el correo:
1. Ir a postman
2. Crear un nuevo request
3. indicar la url (debe ser de tipo post) **URL:** http://localhost:8080/send-email
4. pegar lo siguiente en el body y listo: 
```json
{
    "subject": "Titulo del correo",
    "emailTo": "Correo al que se quiere enviar el mensaje",
    "message": "Mensaje que se quiere enviar"
}
```
Si no hay ningun error y configuraste los archivos indicados recibiras el siguiente mensaje:
> Email sent successfully!!
