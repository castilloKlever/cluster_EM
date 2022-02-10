# cluster_EM
Grupo 4-5

*Recomendamos manejar el proyecto en el IDE NetBeans debido a que el proceso de instalación es más simple

Instalación, Ejecución y Utilización en NetBeans IDE o Eclipse IDE

                    1. Pasos para la instalación en NetBeans

1.1 Descargar y abrir o directamente clonar el proyecto "Cluster_EM" dentro de NetBeans, 
debería mostrarse en el IDE como "ClusteringWekaV01"

1.2 Expandir el proyecto y encontrar la carpeta "Libraries"

1.3 Click derecho en "Libraries" y hacer click en "ADD JAR/Folder..." para instalar
la libreria weka

1.4 Seleccionar la libreria "weka.jar" que en caso de haberse clonado directamente desde
GitHub, su ubicación sería ..\NetBeansProjects\cluster_EM, y en caso de haberse descargado
el proyecto, estaría ubicado dentro de la carpeta cluster_EM en su carpeta de descargas

1.5Una vez seleccionada la libreria hacer click en el boton "Open"

1.6 Desde NetBeans verificar si en la carpeta "Libreria" del proyecto se encuentra ya 
instalada la libreria "weka.jar"

                  2. Pasos para la instalación en Eclipse
                  
2.1 Descargar y abrir o directamente clonar el proyecto "Cluster_EM" dentro de Eclipse, 
debería mostrarse en el IDE como "Clustering"

2.2 Hacer click derecho en el proyecto dentro de Eclipse y seleccionar "Properties"

2.3 En la ventana emergente de nombre "Properties for Clustering" ingresar en 
"Java Build Path" y hacer click en el boton "ADD External JARs..."

2.3 Seleccionar la libreria "weka.jar" que en caso de haberse clonado directamente desde
GitHub, su ubicación sería ..\git\cluster_EM, y en caso de haberse descargado
el proyecto, estaría ubicado dentro de la carpeta cluster_EM en su carpeta de descargas

2.4 Una vez seleccionada la libreria hacer click en el boton "Abrir" y se debe mostrar la 
libreria "weka.jar" en el campo "JARs and class folders on the build path"

2.5 Hacer click en el boton "Apply and Close"

2.6 Desde Ecplise verificar si en la carpeta "Referenced Libraries" del proyecto se encuentra ya 
instalada la libreria "weka.jar"

                  3. Pasos para la ejecución NetBeans y Eclipse

3.1 Ejecutar el archivo EMClusterWeka.java que se encuentra
dento del package interfaz.

                  4. Pasos para la utilización NetBeans y Eclipse

4.1 Dentro de la interfaz que se muestra, se debe cargar el archivo fuente
que puede ser de tipo CSV (Haciendo click en el boton "Cargar CSV") o de tipo
ARFF (Haciendo click en el boton "Cargar ARFF")

4.2 Seleccione el archivo fuente y haga click en "Open"

4.3 La ruta del archivo fuente una vez cargado se debe mostrar en el campo que se 
encuentra debajo de los botones "Cargar CSV" y "Cargar ARFF"

4.4 Escoja la semilla para la clusterización, por defecto esta el valor 10

4.5 Haga click en el boton "Clusterizar"

4.6 El informe de clusterizacion y clasificación se debe abrir automaticamente en su pantalla

4.7 Los informes son de tipo .txt y lo puede encontrar en la carpeta en donde se encuentra el proyecto 
en la dirección ..\cluster_EM
  
    4.7.1 El archivo informe.txt guarda el informe de clusterización
    4.7.2 El archivo informeFinal.txt guarda el informe de clasificación unido al informe de clusterización

4.8 Si desea probar un nuevo archivo fuente, regrese al paso 2 de los Pasos de utilización
