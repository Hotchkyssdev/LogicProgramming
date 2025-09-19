'''
JSON Y XML
'''
import os
import xml.etree.ElementTree as xml
import json

datos = {
    "nombre": "Gersom Tomas Hotchkyss",
    "edad": 19,
    "anio_nacimiento": "03-03-2006",
    "lenguajes_programacion": ["Python", "C", "Java"]
}

archivo_xml = "hotchkyssdev.xml"
archivo_json = "hotchkyssdev.json"

#XML
def crear_xml():
    root = xml.Element("datos")
    for llave, valor in datos.items():
        niño = xml.SubElement(root, llave)
        if isinstance(valor, list):
            for item in valor:
                xml.SubElement(niño, "item").text = item
        else:
            niño.text = str(valor)
    tree = xml.ElementTree(root)
    tree.write(archivo_xml)

crear_xml()
with open(archivo_xml, "r") as datos_xml:
    print(datos_xml.read())

os.remove(archivo_xml)

#JSON
def crear_json():
    with open(archivo_json, "w") as datos_json:
        json.dump(datos, datos_json)

crear_json()
with open(archivo_json, "r") as datos_json:
    print(datos_json.read())

os.remove(archivo_json)

'''
* DIFICULTAD EXTRA (opcional):
 * Utilizando la lógica de creación de los archivos anteriores, crea un
 * programa capaz de leer y transformar en una misma clase custom de tu 
 * lenguaje los datos almacenados en el XML y el JSON.
 * Borra los archivos.
'''
crear_xml()
crear_json()

class Datos:
    def __init__(self, nombre, edad, anio_nacimiento, lenguajes_programacion):
        self.nombre = nombre
        self.edad = edad
        self.anio_nacimiento = anio_nacimiento
        self.lenguajes_programacion = lenguajes_programacion

with open(archivo_xml, "r") as datos_xml:
    root = xml.fromstring(datos_xml.read())
    nombre = root.find("nombre").text
    edad = root.find("edad").text
    anio_nacimiento = root.find("anio_nacimiento").text
    lenguajes_programacion = []
    for item in root.find("lenguajes_programacion"):
        lenguajes_programacion.append(item.text)

    clase_xml = Datos(nombre, edad, anio_nacimiento, lenguajes_programacion)
    print(clase_xml.__dict__)

with open(archivo_json, "r") as datos_json:
    diccionario_json = json.load(datos_json)
    clase_json = Datos(
        diccionario_json["nombre"],
        diccionario_json["edad"],
        diccionario_json["anio_nacimiento"],
        diccionario_json["lenguajes_programacion"]
    )
    print(clase_json.__dict__)

os.remove(archivo_xml)
os.remove(archivo_json)