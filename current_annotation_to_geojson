import qupath.lib.gui.scripting.QPEx
import java.nio.file.Paths
def imageData = QPEx.getCurrentImageData()
def imageName = imageData.getServer().getMetadata().getName()
def imageBaseName = imageName.substring(0, imageName.lastIndexOf('.'))
def outputGeoJsonPath = Paths.get("/homeStor1/Tissue/", "${imageBaseName}.geojson").toString()
exportAllObjectsToGeoJson(outputGeoJsonPath, "PRETTY_JSON", "FEATURE_COLLECTION")
