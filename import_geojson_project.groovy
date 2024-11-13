import qupath.lib.roi.*
import qupath.lib.gui.scripting.QPEx
 
def imageData = QPEx.getCurrentImageData()
def server = imageData.getServer()
name = GeneralTools.getNameWithoutExtension(server.getMetadata().getName())
print(name)
String geojson_root = "/home/datasets/RCCs/OurTumors/qupath0.4/geojson/" 
def json_fp = geojson_root + '/' + name + '.geojson'
def json = new File(json_fp)//.text
def annotations = PathIO.readObjects(json)
addObjects(annotations)
print('done')
