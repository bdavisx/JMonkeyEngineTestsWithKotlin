package com.tartner.jmetest

import com.jme3.app.SimpleApplication
import com.jme3.font.BitmapText
import com.jme3.material.Material
import com.jme3.math.ColorRGBA
import com.jme3.math.FastMath
import com.jme3.math.Quaternion
import com.jme3.math.Vector3f
import com.jme3.scene.Geometry
import com.jme3.scene.shape.Box
import com.jme3.scene.shape.Sphere
import com.jme3.system.AppSettings
import java.awt.GraphicsEnvironment

public class Main : SimpleApplication() {

    override fun simpleInitApp() {
        setDisplayFps(false)
        setDisplayStatView(false)

        val box = Box(Vector3f.ZERO, 1f, 0.5f, 0.25f);
        val boxGeometry = Geometry("Box", box);
        // create a simple blue material
        val boxMaterial = Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        boxMaterial.setColor("Color", ColorRGBA.Blue);
        // give the object the blue material
        boxGeometry.setMaterial(boxMaterial);
        val boxRotation = Quaternion()
        val rotationAngle = FastMath.DEG_TO_RAD * 45f
        boxRotation.fromAngleAxis(rotationAngle, Vector3f.UNIT_X)
        boxRotation.mult(Vector3f.UNIT_Y)
        boxGeometry.setLocalRotation(boxRotation)

        // make the object appear in the scene
        rootNode.attachChild(boxGeometry);

        val vector2 = Vector3f(2.0f, 1.0f, -3.0f);
        val shape = Sphere(500,300,2f);
        val geometry2 = Geometry("Box", shape);
        val material2 = Material(assetManager, "Common/MatDefs/Misc/ShowNormals.j3md");
//        material2.setColor("Color", ColorRGBA.Green);
        geometry2.setMaterial(material2);
        geometry2.setLocalTranslation(vector2);
        rootNode.attachChild(geometry2);

        val text = BitmapText(guiFont)
        text.setText("This is a test")
        text.setSize(guiFont.getCharSet().getRenderedSize().toFloat())
        text.setColor(ColorRGBA.Pink)
        text.setLocalTranslation(100f, 50f, 0f)
        guiNode.attachChild(text)
    }

}

fun main(args: Array<String>) {
//    val device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
//    val modes = device.getDisplayModes();

    val settings = AppSettings(true)
    settings.setBitsPerPixel(32)
    settings.setFrameRate(60)
    settings.setFrequency(60)

//    settings.setFullscreen(true)
//    settings.setWidth(1600)
//    settings.setHeight(900)

    settings.setFullscreen(false)
    settings.setWidth(1024)
    settings.setHeight(768)

    val main = Main()
    main.setShowSettings(false)
    main.setSettings(settings)
    main.start()
}
