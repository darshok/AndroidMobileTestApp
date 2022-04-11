# AndroidMobileTestApp

La aplicación Android desarrollada en Kotlin, muestra un ejemplo de llamada API para obtener las diferentes imágenes de la API pública de la Nasa "Astronomy Picture of the Day". Ofrece un formulario básico para crear y editar las publicaciones de las imágenes, además de permitir ampliar la imagen una vez seleccionada.

## Funcionalidades

- **Listado de publicaciones:** Al iniciar la aplicación, se realiza la petición a la API pública y se obtienen las plublicaciones, mostrando el título, copyright, fecha y la imagen de la misma.

- **Ver imagen completa:** Al pinchar sobre cualquier imagen de las publicaciones listadas, es posible visualizarla al completo, pudiendo ampliar haciendo uso de los gestos de zoom con dos dedos o haciendo doble toque sobre la misma.

- **Crear una publicación:** Al pulsar en el action button, se abre un formulario donde poder introducir los datos para crear una publicación (no funcional).

- **Editar una publicación:** Al pulsar en el botón de editar, se abre un formulario donde muestra los datos de dicha publicación listos para editar (no funcional).

## Tecnologías utilizadas

- Kotlin
- Kotlin Coroutines
- Retrofit
- Gson
- Glide
- Zoomage by jsibbold
