import qupath.lib.io.PathIO
import qupath.lib.gui.scripting.QPEx
import qupath.lib.objects.PathObject
import qupath.lib.objects.PathObjects
import java.nio.file.Paths
import java.io.File

// Get the current image data
def imageData = QPEx.getCurrentImageData()

// Get image metadata and construct the .qpdata path
def imageName = imageData.getServer().getMetadata().getName()
def imageBaseName = imageName.substring(0, imageName.lastIndexOf('.'))

def qdataPath = Paths.get("/home/", "${imageBaseName}.qpdata").toString()
def file = new File(qdataPath)

// Load annotations from the .qpdata file
def annotations = PathIO.readObjects(file)



// Add the loaded annotations to the current image hierarchy
def hierarchy = imageData.getHierarchy()
annotations.each { annotation ->
    hierarchy.addPathObject(annotation)
}

// Define the path to save GeoJSON
def outputGeoJsonPath = Paths.get("/home/Geojson/", "${imageBaseName}.geojson").toString()

// Export annotations to GeoJSON
exportAllObjectsToGeoJson(outputGeoJsonPath, "PRETTY_JSON", "FEATURE_COLLECTION")

// Optionally, remove the annotations after exporting
annotations.each { annotation ->
    hierarchy.removeObject(annotation, true)
}
fireHierarchyUpdate()

println "Annotations successfully saved to GeoJSON file: ${outputGeoJsonPath}"
