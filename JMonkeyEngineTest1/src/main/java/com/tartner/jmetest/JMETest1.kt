package com.tartner.jmetest

import com.jme3.app.SimpleApplication
import com.jme3.material.Material
import com.jme3.math.ColorRGBA
import com.jme3.math.Vector3f
import com.jme3.scene.Geometry
import com.jme3.scene.shape.Box
import com.jme3.scene.shape.Sphere

public class Main : SimpleApplication() {

    override fun simpleInitApp() {
        val box = Box(Vector3f.ZERO, 1f, 1f, 1f);

        val geometry = Geometry("Box", box);

        // create a simple blue material
        val material = Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        material.setColor("Color", ColorRGBA.Blue);
        // give the object the blue material
        geometry.setMaterial(material);
        // make the object appear in the scene
        rootNode.attachChild(geometry);

        val vector2 = Vector3f(2.0f, 1.0f, -3.0f);
        val shape = Sphere(5,10,5f);
        val geometry2 = Geometry("Box", shape);
        val material2 = Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        material2.setColor("Color", ColorRGBA.Green);
        geometry2.setMaterial(material2);
        geometry2.setLocalTranslation(vector2);
        rootNode.attachChild(geometry2);
    }

}

fun main(args: Array<String>) {
    val main = Main()
    main.start()
}
