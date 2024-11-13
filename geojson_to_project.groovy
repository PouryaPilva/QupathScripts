###Credits to @ycblue

import qupath.lib.roi.*
import qupath.lib.gui.scripting.QPEx
 
def imageData = QPEx.getCurrentImageData()
def server = imageData.getServer()
name = GeneralTools.getNameWithoutExtension(server.getMetadata().getName())
print(name)
//def json = new File("d:/1L1_nuclei_anno.json").text
 
String geojson_root = "/homeStor1/datasets/geojson"
//def pathInput = Paths.get("/homeStor1/datasets/RCCs/qupath0.4/geojson/", "${fileName}").toString()
 
slide_name = name.substring(0, name.lastIndexOf('_'))
slide_name = slide_name.substring(0, slide_name.lastIndexOf('_'))
//println slide_name
def json_fp = geojson_root + '/' + slide_name + '_lymphocytes.geojson'
//def json_fp = geojson_root + '/' + slide_name + '_monocytes.geojson'
 
def json = new File(json_fp)//.text
 
def annotations = PathIO.readObjects(json)
 
 
//def deserializedAnnotations = gson.fromJson(json_with_brackets, type)
addObjects(annotations)
print('done')
