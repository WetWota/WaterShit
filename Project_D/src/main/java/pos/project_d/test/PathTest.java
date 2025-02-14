package pos.project_d.test;

import java.io.File;
import java.net.URL;

/**
 * PathTest - Verifies each directory leading to the image.
 */
public class PathTest {

    public static void main(String[] args) {
        // ✅ Define the expected image path inside the project
        String relativePath = "src/main/java/pos/resources/Logo.png"; // Adjust based on your actual location
        verifyEachDirectory(relativePath);

        // ✅ Attempt to load the image from the classpath
        URL imageUrl = PathTest.class.getResource("/Logo.png");
        System.out.println("Image URL: " + imageUrl);

        if (imageUrl == null) {
            throw new RuntimeException("Image not found! Make sure it's in the correct directory.");
        }
    }

    /**
     * Verifies whether each directory in the path exists.
     * @param path The relative path to the image.
     */
    public static void verifyEachDirectory(String path) {
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("❌ File/Path does not exist: " + file.getAbsolutePath());
        } else {
            System.out.println("✅ File/Path exists: " + file.getAbsolutePath());
        }

        // ✅ Check each parent directory in the path
        File parent = file.getParentFile();
        while (parent != null) {
            if (parent.exists()) {
                System.out.println("✅ Directory exists: " + parent.getAbsolutePath());
            } else {
                System.out.println("❌ Directory missing: " + parent.getAbsolutePath());
            }
            parent = parent.getParentFile();
        }
    }
}
